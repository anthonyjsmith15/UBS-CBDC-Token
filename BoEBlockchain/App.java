package BoEBlockchain;

import org.apache.commons.cli.*;

import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        Options options = new Options();
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        String usageSyntax = "<test-to-run> ";
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp(usageSyntax, options);
            System.exit(1);
        }

        List<String> testsToRun = cmd.getArgList();
        for (String test : testsToRun) {
            System.out.println("Run " + test);
            switch (test) {
                case "uktctinitial":
                    UKTCTInitial.main();
                    break;
                case "uktctv2":
                    UKTCTv2.main();
                    break;
            }
        }
    }
}
