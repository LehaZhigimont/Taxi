package ReadWriteFiles.ParsingFile;

import Clients.Client;
import Clients.Queues;
import Date.CurrentDate;
import ReadWriteFiles.CreateFile;

import java.io.*;
import java.util.ArrayList;


public class ParsQueues {
    private File pathFile;
    private String saveDateToDay;
    private CurrentDate date;
    private ArrayList<Client> list = new ArrayList<>();

    private File savePathFile() {
        date = new CurrentDate();
        if (Integer.parseInt(date.CurrentDate() + "") < 10) {
            saveDateToDay = "0" + date.CurrentDate();
        } else
            saveDateToDay = date.CurrentDate() + "";
        if (Integer.parseInt(date.CurrentMonth() + "") < 10) {
            saveDateToDay += "0" + date.CurrentMonth() + date.CurrentYear() + "q.dat";
        } else
            saveDateToDay += date.CurrentMonth() + "" + date.CurrentYear() + "q.dat";

        pathFile = new File("C:\\Taxi\\stat\\" + saveDateToDay);
        return pathFile;
    }

    public void saveToFile(Client client) {
        list = readFile();
        list.add(client);
        try {
            final FileOutputStream fos = new FileOutputStream(savePathFile());
            final ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
        } catch (FileNotFoundException ex) {
            new CreateFile().createFile(savePathFile());
        } catch (IOException ex) {
            System.out.println("что-то пошло не так");
        }
    }


    public void saveToFile(ArrayList<Client> list) {
        try {final ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(savePathFile()));
            oos.writeObject(list);
            oos.close();
        } catch (FileNotFoundException ex) {
            new CreateFile().createFile(savePathFile());
        } catch (IOException ex) {
            System.out.println("что-то пошло не так");
        }
    }



    public  ArrayList readFile() {
        //ArrayList<Client> list = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savePathFile()));
            list = (ArrayList<Client>) ois.readObject();
        } catch (FileNotFoundException ex) {
            return list;
        } catch (Exception ex) {
            System.out.println("readFileDat - что-то пошло не так");
        }
        return list;
    }

    public void saveToFileTemp(ArrayList<Client> list) {
        pathFile = new File("C:\\Taxi\\data\\queue\\temp.dat");
        try {
            final FileOutputStream fos = new FileOutputStream(pathFile);
            final ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("нет файла!");
            new CreateFile().createFile(pathFile);
        } catch (IOException ex) {
            System.out.println("что-то пошло не так");
        }
    }

    public ArrayList<Client> readTempFile() {
        pathFile = new File("C:\\Taxi\\data\\queue\\temp.dat");
        try (FileInputStream fin = new FileInputStream(pathFile)) {
            ObjectInputStream ois = new ObjectInputStream(fin);
            list = (ArrayList<Client>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Statistics - нет файла!");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Statistics - что-то пошло не так");
        }
        return list;
    }


    public void UpdateQueueOfFile() {
        list = readTempFile();
        new Queues().setClientsQueue(list);
    }
}

