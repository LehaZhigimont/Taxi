package ReadWriteFiles.ParsingFile;

import ReadWriteFiles.CreateFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ParsReplaceFile {

    /*
    TODO
    @pathFile - считать директорию из файла!
     */
    private File pathFile = new File("c:\\Users\\tehnobars\\AppData\\Local\\HDPlayer\\HDPlayer\\outputpath\\Image\\");
    //private File pathFile = new File("c:\\Users\\admin\\AppData\\Local\\HDPlayer\\HDPlayer\\outputpath\\Image\\");
    private String[] parsListFile;
    private static String[] pathImg;// = new String[17];


    public File[] fileList() {
        File[] listOfFiles = pathFile.listFiles();
        if (listOfFiles!=null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                System.out.println(listOfFiles[i].getName());
            }

            System.out.println("Я тут");
            parsListFile = new String[listOfFiles.length];
            for (int i = 0; i < parsListFile.length; i++) {
                parsListFile[i] = listOfFiles[i].getName();
            }
        }
        return listOfFiles;
    }


    public BufferedImage readImageFromFile(File file) throws IOException {
        return ImageIO.read(file);
    }

    public void writeImageToJPG(File file, BufferedImage bufferedImage) throws IOException {
        ImageIO.write(bufferedImage, "png", file);
    }


    public void WriteToFileFitop() {
        File pathFF = new File("C:\\Taxi\\stream.dll");
        if (!pathFF.isFile()) {
            try (PrintWriter write = new PrintWriter(pathFF)) {
                for (String s : parsListFile) {
                    write.println(s);
                }
            } catch (FileNotFoundException ex) {
                System.out.println(pathFF + "File not found!");
                CreateFile createFile = new CreateFile();
                createFile.createFile(pathFF);
                System.out.println(pathFF + "Created!");
            }
        }
        pathFF = new File("C:\\Taxi\\data\\image\\stream_img.dll");
        if (!pathFF.isFile()) {
            try (PrintWriter writes = new PrintWriter(pathFF)) {

                for (String s : parsListFile) {
                    System.out.println("Write to stream_img - " + s);
                    writes.println(s);
                }
            } catch (FileNotFoundException e) {
                System.out.println(pathFF + "File not found!");
                CreateFile createFile = new CreateFile();
                createFile.createFile(pathFF);
                System.out.println(pathFF + "Created!");
            }
        }
        pathImg = getPathImg();
    }


    public String[] ReadPathIMGFile() {
        String[] tempList = new String[17];
        File path = new File("C:\\Taxi\\data\\image\\stream_img.dll");
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            for (int i = 0; i < tempList.length; i++) {
                line = br.readLine();
                if (!line.equals("") && !line.equals(null))
                    tempList[i] = line;
                else {
                    //System.out.println("пусто - " + line);
                }
            }
        } catch (FileNotFoundException ex) {
            //System.out.println("Can`t read file " + pathFile);
            /*
            TODO
            write file log
             */
        } catch (IOException exception) {

        }
        return tempList;
    }

    public String[] getPathImg() {
        if (pathImg != null) {
            return pathImg;
        }
        return ReadPathIMGFile();
    }
}
