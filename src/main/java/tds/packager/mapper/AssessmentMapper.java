package tds.packager.mapper;

import tds.packager.model.gitlab.GitLabItemMetaData;
import tds.packager.model.xlsx.TestPackageSheet;
import tds.packager.model.xlsx.TestPackageSheetNames;
import tds.packager.model.xlsx.TestPackageWorkbook;
import tds.testpackage.model.Assessment;
import tds.testpackage.model.Grade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AssessmentMapper {
    public static List<Assessment> map(final TestPackageWorkbook workbook, final List<String> grades,
                                       final Map<String, GitLabItemMetaData> itemMetaData) {
        final List<Assessment> assessments = new ArrayList<>();
        final TestPackageSheet sheet = workbook.getSheet(TestPackageSheetNames.TESTS);

        for (int i = 0; i < sheet.getTotalNumberOfInputColumns(); i++) {
            final Map<String, String> testInputValuesMap = sheet.getInputVariableValuesMap(i);
            final String assessmentId = testInputValuesMap.get("TestId");
            assessments.add(Assessment.builder()
                    .setId(assessmentId)
                    .setLabel(testInputValuesMap.get("TestLabel"))
                    .setGrades(grades.stream()
                            .map(gradeString -> Grade.builder()
                                    .setValue(gradeString)
                                    .build())
                            .collect(Collectors.toList()))
                    .setSegments(SegmentMapper.map(workbook, assessmentId, itemMetaData))
                    .setTools(ToolMapper.map(workbook, assessmentId))
                    .build());
        }

        return assessments;
    }
}
