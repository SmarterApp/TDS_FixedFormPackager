package tds.packager.mapper;

import org.apache.poi.ss.util.CellReference;
import tds.packager.model.xlsx.TestPackageSheet;
import tds.packager.model.xlsx.TestPackageSheetNames;
import tds.packager.model.xlsx.TestPackageWorkbook;
import tds.testpackage.model.TestPackage;

import java.util.*;

public class TestPackageMapper {
    public static TestPackage map(final TestPackageWorkbook workbook) {
        final TestPackageSheet sheet = workbook.getSheet(TestPackageSheetNames.PACKAGE);
        final Map<String, String> valuesMap = sheet.getInputVariableValuesMap(CellReference.convertColStringToIndex("E"));

        final TestPackage.Builder testPackageBuilder = TestPackage.builder()
                .setId(valuesMap.get("PackageId"))
                .setBankKey(Integer.parseInt(valuesMap.get("BankKey")))
                .setAcademicYear(valuesMap.get("AcademicYear"))
                .setVersion(valuesMap.get("Version"))
                .setPublisher(valuesMap.get("Publisher"))
                .setSubject(valuesMap.get("Subject"))
                .setType(valuesMap.get("AssessmentType"))
                .setSubType(valuesMap.containsKey("AssessmentSubType") ? Optional.of(valuesMap.get("AssessmentSubType")) : Optional.empty())
                .setBlueprint(BlueprintMapper.map(workbook, valuesMap))
                .setAssessments(AssessmentMapper.map(workbook, parseGrades(valuesMap.get("Grade"))));

        return testPackageBuilder.build();
    }

    private static List<String> parseGrades(final String grade) {
        if (grade.contains(",")) {
            return Arrays.asList(grade.split(","));
        }

        return Collections.singletonList(grade);
    }
}
