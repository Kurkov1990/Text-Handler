package app;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileHandler {

    public String createFolder(String newPath) {
        Path path = Paths.get(newPath);
        Path newDir;
        try {
            newDir = Files.createDirectory(path);
        } catch (FileAlreadyExistsException e) {
            return "Folder has been already created!";
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
        return "Folder " + newDir + " created!";
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
