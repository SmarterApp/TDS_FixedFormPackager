package tds.packager.service;

import tds.packager.model.gitlab.GitCredentials;

public interface FixedFormPackagerService {
    /**
     * Generates a new {@link tds.testpackage.model.TestPackage} in the file system
     *
     * @param inputSpreadsheetPath The path of the input spreadsheet
     * @param outputFilePath       The path to output the generated test package file
     * @param credentials          The gitlab credentials for the fetching the item content
     */
    void generateFixedFormPackage(final String inputSpreadsheetPath, final String outputFilePath, final GitCredentials credentials,
                                  final boolean debug);
}
