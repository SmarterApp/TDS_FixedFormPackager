package tds.packager.mapper;

import tds.packager.model.xlsx.TestPackageWorkbook;
import tds.testpackage.model.BlueprintElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BlueprintMapper {
    public static List<BlueprintElement> map(final TestPackageWorkbook workbook, Map<String, String> testPackageValues) {
        // TODO: Map the blueprint. The testPackageValues map contains the scoring/performance level data defined in the Package sheet
        return new ArrayList<>();
    }
}
