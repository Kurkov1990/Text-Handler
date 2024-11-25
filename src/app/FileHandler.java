package app;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileHandler {

    public void createFolder(String path) {
        File folder = new File(path);
        boolean isCreated= folder.mkdir();
        if (isCreated) {
                System.out.println("New folder created...");
            } else if (folder.exists()) {
                System.out.println("Folder is already created");
            } else {
            System.out.println("Something went wrong :(");
        }
       }

    public String createFile(String path) {
        Path newFile;
        try {
            newFile = Files.createFile(Path.of(path));
        } catch (FileAlreadyExistsException e) {
            return "File already exists! " + e.getMessage();
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
        return "Created " + newFile;
    }

    public String writeToFile(Path path, String content) {
        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            return e.getMessage();
        }
        return "Recorded in " + path;
    }

    public String readFromFile(String path) {
        Path filePath = Path.of(path);
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
    }
}
