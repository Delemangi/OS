package lab1.zad2;

import java.io.*;

public class Lab {
    public static final String filePath = "D:\\Data\\OS\\tmp";

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File(filePath);

        if (!f.isDirectory()) {
            throw new FileNotFoundException();
        }

        File[] files = f.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                continue;
            }

            if (file.isFile() && file.getName().endsWith(".dat")) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
