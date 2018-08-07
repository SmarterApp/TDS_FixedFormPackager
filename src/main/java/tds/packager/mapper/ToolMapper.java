package tds.packager.mapper;

import org.springframework.util.StringUtils;
import tds.packager.model.xlsx.TestPackageSheet;
import tds.packager.model.xlsx.TestPackageSheetNames;
import tds.packager.model.xlsx.TestPackageWorkbook;
import tds.testpackage.model.Dependency;
import tds.testpackage.model.Option;
import tds.testpackage.model.Tool;

import java.util.*;

public class ToolMapper {
    // Tools
    private static final String TOOL_NAME_PREFIX = "ToolName";
    private static final String TOOL_TYPE_PREFIX = "ToolType";
    private static final String TOOL_ART_FIELDNAME_PREFIX = "ToolStudentPackageFieldName";
    private static final String TOOL_SORT_ORDER_PREFIX = "ToolSortOrder";
    private static final String TOOL_REQUIRED_PREFIX = "ToolRequired";
    private static final String TOOL_DISABLE_ON_GUEST_PREFIX = "ToolDisableOnGuest";
    private static final String TOOL_ALLOW_MULTIPLE_PREFIX = "ToolAllowMultiple";
    private static final String TOOL_ALLOW_CHANGE_PREFIX = "ToolAllowChange";

    // Options
    private static final String OPTION_CODE_PREFIX = "ToolOptionCode";
    private static final String OPTION_SORT_ORDER_PREFIX = "ToolOptionSortOrder";
    private static final String OPTION_LABEL_PREFIX = "ToolOptionLabel";
    private static final String OPTION_DEFAULT_PREFIX = "ToolOptionDefault";

    // Dependencies
    private static final String DEPENDENCY_IF_TYPE_PREFIX = "ToolOptionDependencyIfType";
    private static final String DEPENDENCY_IF_CODE_PREFIX = "ToolOptionDependencyIfCode";
    private static final String DEPENDENCY_DEFAULT_PREFIX = "ToolOptionDependencyDefault";

    public static List<Tool> map(final TestPackageWorkbook workbook, final String assessmentOrSegmentId) {
        final TestPackageSheet sheet = workbook.getSheet(TestPackageSheetNames.TOOLS);
        Map<String, String> toolVars = new HashMap<>();

        for (int i = 0; i < sheet.getTotalNumberOfInputColumns(); i++) {
            if (sheet.getString("TestOrSegmentId", i).equals(assessmentOrSegmentId)) {
                toolVars = sheet.getInputVariableValuesMap(i);
            }
        }

        if (toolVars.isEmpty()) {
            return new ArrayList<>();
        }

        return mapTools(toolVars);
    }

    private static List<Tool> mapTools(final Map<String, String> toolVars) {
        final Map<String, Tool> defaults = Tool.TOOL_DEFAULTS_MAP;
        final List<Tool> tools = new ArrayList<>();

        for (int i = 1; ; i++) {
            final String name = getKey(TOOL_NAME_PREFIX, i);
            if (!toolVars.containsKey(name)) {
                break;
            }

            final String toolName = toolVars.get(name);
            tools.add(Tool.builder()
                    .setName(toolName)
                    .setType(!StringUtils.isEmpty(toolVars.get(getKey(TOOL_TYPE_PREFIX, i)))
                            ? Optional.of(toolVars.get(getKey(TOOL_TYPE_PREFIX, i)))
                            : Optional.empty())
                    .setStudentPackageFieldName(!StringUtils.isEmpty(toolVars.get(getKey(TOOL_ART_FIELDNAME_PREFIX, i)))
                            ? Optional.of(toolVars.get(getKey(TOOL_ART_FIELDNAME_PREFIX, i)))
                            : Optional.empty())
                    .setSortOrder(!StringUtils.isEmpty(toolVars.get(getKey(TOOL_SORT_ORDER_PREFIX, i)))
                            ? Integer.parseInt(toolVars.get(getKey(TOOL_SORT_ORDER_PREFIX, i)))
                            : 0)
                    .setRequired(!StringUtils.isEmpty(toolVars.get(getKey(TOOL_REQUIRED_PREFIX, i))) ?
                            Boolean.valueOf(toolVars.get(getKey(TOOL_REQUIRED_PREFIX, i)))
                            : defaults.get(toolName).required())
                    .setDisableOnGuest(!StringUtils.isEmpty(toolVars.get(getKey(TOOL_DISABLE_ON_GUEST_PREFIX, i)))
                            ? Boolean.valueOf(toolVars.get(getKey(TOOL_DISABLE_ON_GUEST_PREFIX, i)))
                            : defaults.get(toolName).disableOnGuest())
                    .setAllowMultipleOptions(!StringUtils.isEmpty(toolVars.containsKey(getKey(TOOL_ALLOW_MULTIPLE_PREFIX, i)))
                            ? Boolean.valueOf(toolVars.get(getKey(TOOL_ALLOW_MULTIPLE_PREFIX, i)))
                            : defaults.get(toolName).allowMultipleOptions())
                    .setAllowChange(!StringUtils.isEmpty(toolVars.containsKey(getKey(TOOL_ALLOW_CHANGE_PREFIX, i)))
                            ? Boolean.valueOf(toolVars.get(getKey(TOOL_ALLOW_CHANGE_PREFIX, i)))
                            : defaults.get(toolName).allowChange())
                    .setOptions(mapOptions(toolVars, i))
                    .build());
        }

        return tools;
    }

    private static List<Option> mapOptions(final Map<String, String> toolVars, final int toolIndex) {
        final List<Option> options = new ArrayList<>();

        for (int i = 1; ; i++) {
            final String codeKey = getKey(OPTION_CODE_PREFIX, toolIndex, i);
            if (!toolVars.containsKey(codeKey)) {
                break;
            }

            final String code = toolVars.get(codeKey);

            if (!StringUtils.isEmpty(code)) {
                options.add(Option.builder()
                        .setCode(code)
                        .setSortOrder(!StringUtils.isEmpty(toolVars.get(getKey(OPTION_CODE_PREFIX, toolIndex, i)))
                                ? Integer.parseInt(toolVars.get(getKey(OPTION_SORT_ORDER_PREFIX, toolIndex, i)))
                                : 0)
                        .setLabel(!StringUtils.isEmpty(toolVars.get(getKey(OPTION_LABEL_PREFIX, toolIndex, i)))
                                ? Optional.of(toolVars.get(getKey(OPTION_LABEL_PREFIX, toolIndex, i)))
                                : Optional.empty())
                        .setDefault(!StringUtils.isEmpty(toolVars.get(getKey(OPTION_DEFAULT_PREFIX, toolIndex, i)))
                                ? Boolean.valueOf(toolVars.get(getKey(OPTION_DEFAULT_PREFIX, toolIndex, i)))
                                : false)
                        .setDependencies(mapDependencies(toolVars, toolIndex, i))
                        .build());
            }
        }

        return options;
    }

    private static List<Dependency> mapDependencies(final Map<String, String> toolVars, final int toolIndex, final int optionIndex) {
        final List<Dependency> dependencies = new ArrayList<>();

        for (int i = 1; ; i++) {
            final String codeKey = getKey(DEPENDENCY_IF_CODE_PREFIX, toolIndex, optionIndex, i);

            if (!toolVars.containsKey(codeKey)) {
                break;
            }

            final String code = toolVars.get(codeKey);

            if (!StringUtils.isEmpty(code)) {
                dependencies.add(Dependency.builder()
                        .setIfToolType(toolVars.get(getKey(DEPENDENCY_IF_TYPE_PREFIX, toolIndex, optionIndex, i)))
                        .setIfToolCode(code)
                        .setDefault(!StringUtils.isEmpty(toolVars.get(getKey(DEPENDENCY_DEFAULT_PREFIX, toolIndex, optionIndex, i)))
                                ? Boolean.valueOf(toolVars.get(getKey(DEPENDENCY_DEFAULT_PREFIX, toolIndex, optionIndex, i)))
                                : false)
                        .build());
            }
        }

        return dependencies;
    }

    private static String getKey(final String prefix, final int... indices) {
        final StringBuilder sb = new StringBuilder(prefix).append("_");

        for (int i = 0; i < indices.length; i++) {
            sb.append(indices[i]);

            if (i != indices.length - 1) {
                sb.append("_");
            }

        }
        return sb.toString();
    }
}
