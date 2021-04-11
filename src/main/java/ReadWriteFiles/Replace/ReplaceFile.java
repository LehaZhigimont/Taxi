package ReadWriteFiles.Replace;


import ReadWriteFiles.ParsingFile.ParsReplaceFile;
import ReadWriteFiles.ReadFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ReplaceFile {
    private ParsReplaceFile parsReplaceFile;
    private Panel panel;
    private File[] fileList;
    private File fileToSave = new File("C:\\Users\\tehnobars\\AppData\\Local\\HDPlayer\\HDPlayer\\outputpath\\Image");


    public void ReplaceFile(String[][] queue, String firstNumber) {
        parsReplaceFile = new ParsReplaceFile();
        if (fileList == null) {
            fileList = parsReplaceFile.fileList();
        }
        parsReplaceFile.WriteToFileFitop();
        panel = new Panel(queue, firstNumber, parsReplaceFile.getPathImg());
        replace(panel);
    }

    private void replace(Panel panel) {
        ArrayList<PanelTabel> panelQueue = panel.getPanelTabels();
        for (PanelTabel p : panelQueue) {
            try {
                //System.out.println(fileToSave + "\\" + p.getNameFile());
                parsReplaceFile.writeImageToJPG(new File(fileToSave + "\\" + p.getNameFile()), parsReplaceFile.readImageFromFile(p.getPathFile()));
            } catch (IOException e) {
                //System.out.println("Не прочитали png файл!");
            }
        }

    }


    private String pathReplace() {
        String[] s = new String[2];
        File file = new File("c:\\Taxi\\option.ini");
        ReadFile readFile = new ReadFile();
        s = readFile.ReadWithFile(file, s);
        return s[1];
    }


}
