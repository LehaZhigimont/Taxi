package ReadWriteFiles.ParsingFile;

import ReadWriteFiles.ReadFile;
import ReadWriteFiles.WriteFile;

import java.io.File;

public class ParsOptionCheck {

    public String[] readOptionCheck(File file, String[] text_line){
        ReadFile read = new ReadFile();
        text_line = read.ReadWithFile(file, text_line);
        return text_line;
    }

    public void writeOptionCheck (File pathFile, String[] endText){
        WriteFile write = new WriteFile();
        write.WriteForFile(pathFile, endText);
    }
}

