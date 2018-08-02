package tds.packager.model.gitlab;

public class GitLabItemMetaData {
    private final String metadata;
    private final String itemMetadata;

    public GitLabItemMetaData(final String metadata, final String itemMetadata) {
        this.metadata = metadata;
        this.itemMetadata = itemMetadata;
    }

    public String getMetadata() { return metadata; }

    public String getItemMetadata() { return itemMetadata; }

}
