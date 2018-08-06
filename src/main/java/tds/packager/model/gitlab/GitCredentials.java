package tds.packager.model.gitlab;

import javax.validation.constraints.NotEmpty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix = "gitlab")
@Validated
public class GitCredentials {
    @NotEmpty
    private String token;

    @NotEmpty
    private String group;

    @NotEmpty
    private String url;

    public GitCredentials() {}

    public GitCredentials(final String token, final String group, final String url) {
        this.token = token;
        this.group = group;
        this.url = url;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public void setGroup(final String group) {
        this.group = group;
    }

    public void setUrl(final String url) {
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
