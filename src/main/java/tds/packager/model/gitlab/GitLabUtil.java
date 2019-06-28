package tds.packager.model.gitlab;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Project;
import org.gitlab4j.api.models.RepositoryFile;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GitLabUtil {

    public static Map<String, GitLabItemMetaData> getItemMetaData(GitCredentials gitCredentials, Iterable<String> items) {

        //Gitlab login
        final GitLabApi gitLabApi = gitLabApiLogin(gitCredentials.getUrl(), gitCredentials.getToken());
        final String group = gitCredentials.getGroup();

        final HashMap<String, GitLabItemMetaData> gitLabItems = new HashMap<>();

        try {
            for (String itemKey : items) {
                System.out.println("Fetching metadata for " + group + "/Item-" + itemKey);
                Project project = gitLabApi.getProjectApi().getProject(group, "Item-" + itemKey);
                gitLabItems.put(trimBankKey(itemKey), new GitLabItemMetaData(
                                decodeGitLabFile(gitLabApi.getRepositoryFileApi().getFile(project, "metadata.xml", "master")),
                                decodeGitLabFile(gitLabApi.getRepositoryFileApi().getFile(project, "item-" + itemKey + ".xml", "master"))
                        )
                );
            }
        } catch (GitLabApiException e) {
            throw new RuntimeException("Error fetching files from GitLab: ", e);
        }
        System.out.println("Done fetching item metadata.");
        return gitLabItems;
    }

    private static String trimBankKey(final String itemKey) {
        return itemKey.split("-")[1];
    }

    private static String decodeGitLabFile(RepositoryFile file) {
        return new String(Base64.getDecoder().decode(file.getContent()));
    }

    private static GitLabApi gitLabApiLogin(String url, String token) {
        GitLabApi gitLabApi = new GitLabApi(url, token);
        try {
            System.out.println("Successfully authenticated to GitLab API as user " + gitLabApi.getUserApi().getCurrentUser().getUsername());
        } catch (GitLabApiException gae) {
            throw new RuntimeException("Unable to login to Gitlab with provided credentials and URL to retrieve item metadata: ", gae);
        }
        return gitLabApi;

    }
}
