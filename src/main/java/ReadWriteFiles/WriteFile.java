package ReadWriteFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteFile {

    public void WriteForFile(File pathFile, String[] endFile) {
        try (PrintWriter write = new PrintWriter(pathFile)) {
            for (String s : endFile) {
                write.println(s);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(pathFile + "File not found!");
            CreateFile createFile = new CreateFile();
            createFile.createFile(pathFile);
        }
    }

    public void WriteForFile(File pathFile, String s) {
        try (PrintWriter write = new PrintWriter(pathFile)) {
            write.print(s);
        } catch (FileNotFoundException ex) {
            System.out.println(pathFile + "File not found!");
            CreateFile createFile = new CreateFile();
            createFile.createFile(pathFile);
        }
    }
}
