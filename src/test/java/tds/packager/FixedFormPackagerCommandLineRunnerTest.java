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
        runner = new FixedFormPackagerCommandLineRunner(mockPackagerService);
        runner.init();
    }

    @Test
    public void shouldCreateFixedFormPackageSuccessfullyNoOutputPath() {
        runner.run("/path/to/spreadsheet.xlsx",
                "-t", "myToken",
                "-g", "myGroup",
                "-u", "myUrl");

        verify(mockPackagerService).generateFixedFormPackage(eq("/path/to/spreadsheet.xlsx"), eq("."), isA(GitCredentials.class), eq(false));
    }

    @Test
    public void shouldCreateFixedFormPackageSuccessfullyWithOutputPath() {
        runner.run("/path/to/spreadsheet.xlsx",
                "-t", "myToken",
                "-g", "myGroup",
                "-u", "myUrl",
                "-o", "/output/path/");

        verify(mockPackagerService).generateFixedFormPackage(eq("/path/to/spreadsheet.xlsx"), eq("/output/path/"), isA(GitCredentials.class), eq(false));
    }
}
