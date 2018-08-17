package tds.packager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import tds.support.tool.testpackage.configuration.TestPackageObjectMapperConfiguration;

@SpringBootApplication
@Import(TestPackageObjectMapperConfiguration.class)
public class FixedFormPackagerConsoleApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(FixedFormPackagerConsoleApplication.class, args);
    }
}
