package lab1.zad6;

import java.io.*;
import java.util.stream.*;

public class zad6 {
    public static void main(String[] args) throws IOException {
        File input = new File("./src/lab1/zad6/izvor.txt");
        File output = new File("./src/lab1/zad6/destinacija.txt");

        if (!input.exists() || !output.exists()) {
            throw new FileNotFoundException();
        }

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));

            StringBuilder sb = new StringBuilder(br.lines().collect(Collectors.joining("\n")));
            bw.write(sb.reverse().toString());
        } finally {
            if (br != null) {
                br.close();
            }

            if (bw != null) {
                bw.flush();
                bw.close();
            }
        }
    }
}
