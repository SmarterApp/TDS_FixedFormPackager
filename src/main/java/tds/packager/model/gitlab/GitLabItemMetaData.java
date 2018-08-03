package tds.packager.model.gitlab;

public class GitLabItemMetaData {
    private final String itemMetadata;
    private final String itemReleaseMetadata;

    public GitLabItemMetaData(final String itemMetadata, final String itemReleaseMetadata) {
        this.itemMetadata = itemMetadata;
        this.itemReleaseMetadata = itemReleaseMetadata;
    }

    public String getItemMetadata() { return itemMetadata; }

    public String getItemReleaseMetadata() { return itemReleaseMetadata; }

}
