package tds.packager.mapper;

import tds.packager.model.gitlab.GitLabItemMetaData;
import tds.packager.model.xlsx.TestPackageSheet;
import tds.packager.model.xlsx.TestPackageSheetNames;
import tds.packager.model.xlsx.TestPackageWorkbook;
import tds.testpackage.model.TestPackage;

import java.time.Instant;
import java.util.*;

public class TestPackageMapper {
    public static TestPackage map(final TestPackageWorkbook workbook, final Map<String, GitLabItemMetaData> itemMetaData) {
        final TestPackageSheet sheet = workbook.getSheet(TestPackageSheetNames.PACKAGE);
        final Map<String, String> valuesMap = sheet.getInputVariableValuesMap(0);
        final String testPackageId = valuesMap.get("PackageId");

        final TestPackage.Builder testPackageBuilder = TestPackage.builder()
                .setId(testPackageId)
                .setBankKey(Integer.parseInt(valuesMap.get("BankKey")))
                .setAcademicYear(valuesMap.get("AcademicYear"))
                .setVersion(valuesMap.get("Version"))
                .setPublisher(valuesMap.get("Publisher"))
                .setPublishDate(Instant.now().toString())
                .setSubject(valuesMap.get("Subject"))
                .setType(valuesMap.get("AssessmentType"))
                .setSubType(valuesMap.containsKey("AssessmentSubType") ? Optional.of(valuesMap.get("AssessmentSubType")) : Optional.empty())
                .setBlueprint(BlueprintMapper.map(testPackageId, workbook, valuesMap, itemMetaData))
                .setAssessments(AssessmentMapper.map(workbook, parseGrades(valuesMap.get("Grade")), itemMetaData));

        return testPackageBuilder.build();
    }

    private static List<String> parseGrades(final String grade) {
        if (grade.contains(",")) {
            return Arrays.asList(grade.split(","));
        }

        return Collections.singletonList(grade);
    }
}
