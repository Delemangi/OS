package lab1.task1;

import java.io.*;

public class task1 {
    public boolean deleteFile(String filePath) throws FileNotFoundException {
        File f = new File(filePath);

        if (!f.exists()) {
            throw new FileNotFoundException();
        }

        if (!f.isFile()) {
            throw new FileNotFoundException();
        }

        return f.delete();
    }
}
