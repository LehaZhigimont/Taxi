package ReadWriteFiles;

import java.io.*;

public class ReadFile {

    public String[] ReadWithFile(File pathFile, String[] endFile) {
        try (FileReader reader = new FileReader(pathFile)) {
            BufferedReader br = new BufferedReader(reader);
            String line;
            for (int i = 0; i < endFile.length; i++) {
                line = br.readLine();
                System.out.println(line);
                if (!line.equals("") && !line.equals(null))
                    endFile[i] = line;
                else
                    System.out.println("пусто - " + line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Can`t read file " + pathFile);
            /*
            TODO
            write file log
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
        return endFile;
    }
}
