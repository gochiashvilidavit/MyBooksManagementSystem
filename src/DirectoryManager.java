import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class DirectoryManager {

    // Task 1
    public static void listFilesAndDirectories(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("The directory is empty or does not exist: " + directoryPath);
        } else {
            System.out.println("List of books available in " + directoryPath + " directory:");
            for (File file : files) {
                System.out.println("Title: " + file.getName());
            }
        }
    }

    // Task 2
    public static void createDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created successfully: " + directoryPath);
            } else {
                System.out.println("Failed to create directory.");
            }
        } else {
            System.out.println("Directory already exists: " + directoryPath);
        }
    }

    // Task 3
    public static void renameDirectory(String currentDirectory, String newDirectory) {
        File oldDir = new File(currentDirectory);
        File newDir = new File(newDirectory);

        if (newDir.exists()) {
            System.out.println("Error: The new directory already exists.");
            return;
        }

        if (!oldDir.renameTo(newDir)) {
            System.out.println("Failed to rename directory.");
        } else {
            System.out.println("Directory has been renamed successfully.");
        }
    }

    // Task 4
    public static void copyFiles(String sourceDir, String destDir) {
        Path sourcePath = Paths.get(sourceDir);
        Path destPath = Paths.get(destDir);

        try {
            if (!Files.exists(destPath)) {
                Files.createDirectories(destPath);
            }

            File sourceDirectory = new File(sourceDir);
            File[] files = sourceDirectory.listFiles();

            if (files != null) {
                for (File file : files) {
                    Path destFile = destPath.resolve(file.getName());
                    Files.copy(file.toPath(), destFile, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Copied: " + file.getName());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Task 5
    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println(fileName + " has been deleted.");
        } else {
            System.out.println("Failed to delete " + fileName);
        }
    }
}
