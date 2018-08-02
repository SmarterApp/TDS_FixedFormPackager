package tds.packager.model.gitlab;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Project;
import org.gitlab4j.api.models.RepositoryFile;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;

public class GitLabUtil {

    public static HashMap<String, GitLabItemMetaData> getItemMetaData(GitCredentials gitCredentials, Iterable<String> items) {

        //Gitlab login
        final GitLabApi gitLabApi = gitLabApiLogin(gitCredentials.getUrl(), gitCredentials.getUserName(), gitCredentials.getPassword());
        final String group = gitCredentials.getGroup();

        final HashMap<String, GitLabItemMetaData> gitLabItems = new HashMap<>();

        try {
            for (String itemId : items) {
                System.out.println("Fetching metadata for " + group + "/Item-" + itemId);
                List<Project> projects = gitLabApi.getProjectApi().getProjects("Item-"+ itemId);
                Project project = getGitLabProject(projects, itemId);
                gitLabItems.put(itemId, new GitLabItemMetaData(
                                decodeGitLabFile(gitLabApi.getRepositoryFileApi().getFile(project, "metadata.xml", "master")),
                                decodeGitLabFile(gitLabApi.getRepositoryFileApi().getFile(project, "item-" + itemId + ".xml", "master"))
                        )
                );
            }
        } catch (GitLabApiException e)   {
            throw new RuntimeException("Error fetching files from GitLab: ", e);
        }
        System.out.println("Done fetching item metadata.");
        return gitLabItems;
    }

    private static Project getGitLabProject(List<Project> projects, String itemId) {
        for (Project project : projects) {
            if(project.getName().equalsIgnoreCase("Item-"+itemId)) {
                return project;
            }
        }
        throw new RuntimeException("Unable to find Gitlab project for Item with id " + itemId);
    }

    private static String decodeGitLabFile(RepositoryFile file) {
        return new String(Base64.getDecoder().decode(file.getContent()));
    }

    private static GitLabApi gitLabApiLogin(String url, String username, String password) {
        try {
            System.out.println("trying to log in with username="+ username + " url=" + url + " password=" + password);
            return GitLabApi.login(url, username, password);
        } catch (GitLabApiException gae) {
            throw new RuntimeException("Unable to login to Gitlab with provided credentials and URL to retrieve item metadata: ", gae);
        }
    }
}
