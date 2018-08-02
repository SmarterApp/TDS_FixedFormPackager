package tds.packager;

import org.apache.commons.cli.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tds.packager.model.gitlab.GitCredentials;
import tds.packager.service.FixedFormPackagerService;

import javax.annotation.PostConstruct;

@Component
public class FixedFormPackagerCommandLineRunner implements CommandLineRunner {
    private static final String DEFAULT_OUTPUT_PATH = ".";
    private static final String GIT_USERNAME = "u";
    private static final String GIT_PASSWORD = "p";
    private static final String GIT_GROUP = "g";
    private static final String GIT_URL = "z";
    private static final String OUTPUT_PATH = "o";
    private static final String VERBOSE_FLAG = "v";

    private Options options;
    private CommandLineParser parser;
    private CommandLine cmd;
    private HelpFormatter formatter;

    private final FixedFormPackagerService service;

    @Autowired
    public FixedFormPackagerCommandLineRunner(final FixedFormPackagerService service) {
        this.service = service;
    }

    /**
     * Initiates the sub-command
     */
    @PostConstruct
    public void init () {
        options = new Options();
        parser = new DefaultParser();
        formatter = new HelpFormatter();

        final Option usernameOption = Option.builder(GIT_USERNAME)
                .argName("username")
                .hasArgs()
                .longOpt("username")
                .desc("*REQUIRED* GitLab Username")
                .optionalArg(false)
                .required(true)
                .build();

        final Option passwordOption = Option.builder(GIT_PASSWORD)
                .argName("password")
                .longOpt("password")
                .hasArg()
                .desc("*REQUIRED* GitLab Password")
                .optionalArg(false)
                .required(true)
                .build();

        final Option groupOption = Option.builder(GIT_GROUP)
                .argName("group")
                .longOpt("group")
                .hasArg()
                .desc("*REQUIRED* GitLab Group")
                .optionalArg(false)
                .required(true)
                .build();

        final Option urlOption = Option.builder(GIT_URL)
                .argName("url")
                .longOpt("url")
                .hasArg()
                .desc("*REQUIRED* GitLab URL")
                .optionalArg(false)
                .required(true)
                .build();

        final Option outputPathOption = Option.builder(OUTPUT_PATH)
                .argName("output")
                .longOpt("output")
                .hasArg()
                .desc("Output path of the generated test package file (current directory by default)")
                .optionalArg(true)
                .required(false)
                .build();

        final Option verboseOption = Option.builder(VERBOSE_FLAG)
                .argName("verbose")
                .longOpt("verbose")
                .hasArg(false)
                .desc("Prints more verbose output in case of errors")
                .required(false)
                .build();

        options.addOption(usernameOption);
        options.addOption(passwordOption);
        options.addOption(groupOption);
        options.addOption(urlOption);
        options.addOption(outputPathOption);
        options.addOption(verboseOption);
    }

    @Override
    public void run(final String... args) {
        if (args.length < 1) {
            System.out.println("No arguments were provided to the fixed form packager. Aborting...");
            printHelpAndExit();
            return;
        }

        try {
            cmd = parser.parse(options, args);

            if (cmd.getArgList().size() < 1) {
                printHelpAndExit();
            }

            // Get the input filename (first arg)
            final String inputFilePath = cmd.getArgList().get(0);

            if (!inputFilePath.endsWith(".xlsx")) {
                System.out.println("No arguments were provided to the fixed form packager. Aborting...");
                return;
            }

            final GitCredentials credentials = new GitCredentials(
                    cmd.getOptionValue(GIT_USERNAME),
                    cmd.getOptionValue(GIT_PASSWORD),
                    cmd.getOptionValue(GIT_GROUP),
                    cmd.getOptionValue(GIT_URL)
            );

            // If no -o/--output is provided, just default to the current directory
            service.generateFixedFormPackage(inputFilePath,
                    cmd.hasOption(OUTPUT_PATH) ? cmd.getOptionValue(OUTPUT_PATH) : DEFAULT_OUTPUT_PATH,
                    credentials);

        } catch (Throwable e) {
            if (cmd != null && cmd.hasOption(VERBOSE_FLAG)) {
                e.printStackTrace();
            }

            System.out.println(String.format("The fixed-form test package was not successfully created"));
            System.out.println(String.format("Error message: %s", e.getMessage()));
            if (e.getCause() != null) {
                System.out.println(String.format("Cause: %s", e.getCause().getMessage()));
            }
            printHelpAndExit();
        }
    }

    private void printHelpAndExit() {
        formatter.printHelp("Sample usage: <INPUT XLSX> [OPTIONS] ", options);
        System.exit(-1);
    }
}
