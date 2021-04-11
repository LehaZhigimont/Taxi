package ReadWriteFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {

    public void createFile(File pathFile){
        try(FileWriter fw = new FileWriter(pathFile)) {

        } catch (IOException e) {
            System.out.println("Can not created this file!" + "\n");
            System.out.println(pathFile);
        }
    }
}
