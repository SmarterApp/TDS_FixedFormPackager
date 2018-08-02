package tds.packager.model.gitlab;

public class GitCredentials {
    private final String userName;
    private final String password;
    private final String group;
    private final String url;

    public GitCredentials(final String userName, final String password, final String group, final String url) {
        this.userName = userName;
        this.password = password;
        this.group = group;
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getGroup() {
        return group;
    }

    public String getUrl() {
        return url;
    }
}
