package lab1.task5;

import java.io.*;

public class task5 {
    public void writeToStdOutput(String inputFilePath) throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath)));
            writer = new BufferedWriter(new OutputStreamWriter(System.out));

            String line = null;

            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }

            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
}
