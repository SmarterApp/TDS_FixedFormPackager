package tds.packager.model.gitlab;

public class GitCredentials {
    private final String token;
    private final String group;
    private final String url;

    public GitCredentials(final String token, final String group, final String url) {
        this.token = token;
        this.group = group;
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public String getGroup() {
        return group;
    }

    public String getUrl() {
        return url;
    }
}
