package lab1.task4;

import java.io.*;

public class task4 {
    public static void main(String[] args) throws FileNotFoundException {
        File folder = new File(args[0]);

        if (!folder.exists() || !folder.isDirectory()) {
            throw new FileNotFoundException();
        }

        filterFiles(folder);
    }

    public static void filterFiles(File directory) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                filterFiles(file);
            } else if (checkFile(file)) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    public static boolean checkFile(File file) {
        String name = file.getName();
        long length = file.length();

        return file.isFile() && length > 1000 && length < 100000 && (name.endsWith(".txt") || name.endsWith(".out"));
    }
}
