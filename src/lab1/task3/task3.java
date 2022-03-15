package lab1.task3;

import java.io.*;
import java.util.*;

public class task3 {
    public static void filterFiles(String filePath) throws FileNotFoundException {
        File f = new File(filePath);

        if (!f.exists() || !f.isDirectory()) {
            throw new FileNotFoundException();
        }

        Arrays
                .stream(f.listFiles())
                .filter(file -> file.isFile() && file.length() > 50000)
                .forEach(file -> System.out.println(file.getAbsolutePath()));
    }
}
