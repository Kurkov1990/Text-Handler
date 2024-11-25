package app;

import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    private static final String BASE_PATH = "files/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileHandler handler = new FileHandler();
        handler.createFolder(BASE_PATH);
        System.out.print("Enter file name: ");
        String newFileName = scanner.nextLine();
        System.out.print("Enter text for adding to the file: ");
        String content = scanner.nextLine();
        String path = BASE_PATH + newFileName + ".txt";

        getOutput(handler.createFile(path));
        getOutput(handler.writeToFile(Paths.get(path), content));
        getOutput("CONTENT: " + handler.readFromFile(path));
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
