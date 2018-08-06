package tds.packager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tds.packager.model.gitlab.GitCredentials;
import tds.packager.service.FixedFormPackagerService;

import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FixedFormPackagerCommandLineRunnerTest {
    @Mock
    private FixedFormPackagerService mockPackagerService;

    private FixedFormPackagerCommandLineRunner runner;

    @Before
    public void setup() {
        runner = new FixedFormPackagerCommandLineRunner(mockPackagerService, new GitCredentials("token", "group", "url"));
        runner.init();
    }

    @Test
    public void shouldCreateFixedFormPackageSuccessfullyNoOutputPath() {
        runner.run("/path/to/spreadsheet.xlsx");

        verify(mockPackagerService).generateFixedFormPackage(eq("/path/to/spreadsheet.xlsx"), eq("."), isA(GitCredentials.class));
    }

    @Test
    public void shouldCreateFixedFormPackageSuccessfullyWithOutputPath() {
        runner.run("/path/to/spreadsheet.xlsx",
                "-o", "/output/path/");

        verify(mockPackagerService).generateFixedFormPackage(eq("/path/to/spreadsheet.xlsx"), eq("/output/path/"), isA(GitCredentials.class));
    }
}
