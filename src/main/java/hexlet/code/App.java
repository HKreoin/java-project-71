/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
    name = "gendiff",
    mixinStandardHelpOptions = true, 
    version = "0.3",
    description = "Compares two configuration files and shows a difference."
)
public class App implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
}
