package lab1.zad3;

import java.io.*;
import java.util.*;

public class zad3 {
    public static final String filePath = "C:\\qwe\\rty";

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File(filePath);

        if (!f.exists() || !f.isDirectory()) {
            throw new FileNotFoundException();
        }

        File[] files = f.listFiles();

        Arrays.stream(files).filter(file -> file.isFile() && file.length() > 50000).forEach(file -> System.out.println(file.getAbsolutePath()));
    }
}
