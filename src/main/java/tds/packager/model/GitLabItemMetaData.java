package tds.packager.model;

public class GitLabItemMetaData {

    private final String metadata;
    private final String itemMetadata;

    public String getMetadata() {
        return metadata;
    }

    public String getItemMetadata() {
        return itemMetadata;
    }

    public GitLabItemMetaData(String metadata, String itemMetadata) {
        this.metadata = metadata;
        this.itemMetadata = itemMetadata;
    }
}
