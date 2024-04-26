/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
    name = "gendiff",
    mixinStandardHelpOptions = true, 
    version = "0.3",
    description = "Compares two configuration files and shows a difference."
)
public class App implements Runnable{
    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]", paramLabel = "format")
    String format = "stylish";

    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    String filepath1;
    @Parameters(index = "1", description = "path to second file",paramLabel = "filepath2")
    String filepath2;

    @Override
    public void run() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
}
