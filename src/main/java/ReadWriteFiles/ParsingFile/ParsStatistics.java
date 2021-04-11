package ReadWriteFiles.ParsingFile;

import Clients.Client;

import java.io.*;
import java.util.ArrayList;

public class ParsStatistics {
    private static String[] parsListFile;
    private static String[] listFile;
    private File pathFile = new File("C:\\Taxi\\stat\\");

    public String[] fileList() {
        File[] listOfFiles = pathFile.listFiles();
        parsListFile = new String[listOfFiles.length];
        listFile = new String [listOfFiles.length];
        for (int i = 0; i < listOfFiles.length; i++) {
            parsListFile[i] = parsFileName(listOfFiles[i].getName());
            listFile[i] = listOfFiles[i].getName();
        }
        return parsListFile;
    }

    private String parsFileName(String line) {
        String date, month, year;
        date = line.substring(0, 2) + ".";
        month = line.substring(2, 4) + ".";
        year = line.substring(4, 6);
        line = date + month + year;
        return line;
    }

    public ArrayList reParsFileNameToReadFile(String line){
        System.out.println(line);
        System.out.println(line.replace(".","")+"q.dat");
        line = line.replace(".","")+"q.dat";
        File pathReadFile = new File(pathFile+"\\"+line);
        ArrayList<Client> list = new ArrayList<>();
        list = readFile(list, pathReadFile);
        return list;
    }


    public ArrayList readFile(ArrayList<Client> list, File file) {
        System.out.println(file);
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            list = (ArrayList<Client>) ois.readObject();

        } catch (FileNotFoundException ex) {
            System.out.println("readFileDat - нет файла!");
        } catch (Exception ex) {
            System.out.println("readFileDat - что-то пошло не так");
        }
        return list;
    }

}
