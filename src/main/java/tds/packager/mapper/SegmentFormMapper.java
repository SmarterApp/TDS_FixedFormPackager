package tds.packager.mapper;

import tds.packager.model.gitlab.GitLabItemMetaData;
import tds.packager.model.xlsx.TestPackageWorkbook;
import tds.testpackage.model.Presentation;
import tds.testpackage.model.SegmentForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SegmentFormMapper {
    public static List<SegmentForm> map(final TestPackageWorkbook workbook, final String segmentId,
                                        final List<Presentation> presentations, final HashMap<String, GitLabItemMetaData> itemMetaData) {
        //TODO: Implement this
        return new ArrayList<>();
    }
}
