package Clients;

import ModelUI.MainWindow;
import ModelUI.MovingQueue;
import ReadWriteFiles.ParsingFile.ParsQueues;
import ReadWriteFiles.Replace.ReplaceFile;


import java.util.ArrayList;
import java.util.Arrays;

public class Queues {
    private static ArrayList<Client> ClientsQueue = new ArrayList<>();
    private ParsQueues parsQueues = new ParsQueues();

    private int lastNumber;

    public void Queues() {
        Client client = new Client();
        lastNumber = client.getNumber();
        ClientsQueue.add(client);
        saveNewClientToFile(client);
        saveToFileTempQueue();
        updateTableButton();
    }

    public ArrayList<Client> getClientsQueue() {
        return ClientsQueue;
    }

    public void setClientsQueue(ArrayList<Client> clientsQueue) {
        ClientsQueue = clientsQueue;
    }

    public String[] listQueueForBox() {
        String[] listQueue = new String[ClientsQueue.size()];
        for (int i = 0; i < ClientsQueue.size(); i++) {
            listQueue[i] = ClientsQueue.get(i).getNumber() + "";
        }
        return listQueue;
    }


    public void movingClients() {
        int a = 0, b = 0;

        System.out.println("This queues class " + MovingQueue.moveA + "-" + MovingQueue.movedB);
        for (int i = 0; i < ClientsQueue.size(); i++) {
            if (MovingQueue.movedB.equals(ClientsQueue.get(i).getNumber() + "")) {
                b = i;
            }
            if (MovingQueue.moveA.equals(ClientsQueue.get(i).getNumber() + "")) {
                a = i;
            }
        }
        replaceClientQueue(a, b);
        updateTableButton();
    }

    private void replaceClientQueue(int a, int b) {
        ClientsQueue.add(ClientsQueue.get(a));
        ArrayList<Client> list = new ArrayList<>();
        list.addAll(ClientsQueue);

        if (a > b) {
            for (int i = 0; i < ClientsQueue.size(); i++) {
                if (i > b && i <= a) {
                    if (i == a) {
                        ClientsQueue.set(b, list.get(a));
                        updateClientToStatistic(ClientsQueue.get(b));
                    }
                    ClientsQueue.set(i, list.get(i - 1));
                }
            }
        } else if (b > a) {
            for (int i = 0; i < ClientsQueue.size(); i++) {
                if (i >= a && i < b) {
                    if (i + 1 == b) {
                        ClientsQueue.set(i, list.get(a));
                        updateClientToStatistic(ClientsQueue.get(i));
                    } else
                        ClientsQueue.set(i, list.get(i + 1));
                }
            }
        }
        ClientsQueue.remove(ClientsQueue.size() - 1);
        saveToFileTempQueue();
    }


    private void saveNewClientToFile(Client client) {
        parsQueues.saveToFile(client);
    }


    private void saveToFileTempQueue() {
        parsQueues.saveToFileTemp(getClientsQueue());
    }

    public void updateTableButton() {
        MainWindow.now_queue = new String[8][2];
        if (ClientsQueue.isEmpty()) {
            MainWindow.buttonText = "";
        }
        if (!ClientsQueue.isEmpty()) {
            MainWindow.buttonText = ClientsQueue.get(0).getNumber() + "";
            for (int i = 1; i < ClientsQueue.size(); i++) {
                if (i <= 8) {
                    MainWindow.now_queue[i - 1][0] = ClientsQueue.get(i).getNumber() + "";
                } else if (i >= 9 && i <= 16) {
                    MainWindow.now_queue[i - 9][1] = ClientsQueue.get(i).getNumber() + "";
                }
            }
        }


        new ReplaceFile().ReplaceFile(MainWindow.now_queue, MainWindow.buttonText);
    }


    public void shiftFirstForQueue() {
        for (int i = 0; i < ClientsQueue.size(); i++) {
            if ((i + 1) != ClientsQueue.size()) {
                ClientsQueue.set(i, ClientsQueue.get(i + 1));
                //System.out.println(ClientsQueue.get(i));
            }
            if (i == ClientsQueue.size() - 1) {
                ClientsQueue.remove((i));
            }
        }
        saveToFileTempQueue();
        updateTableButton();
    }

    private void updateClientToStatistic(Client client) {
        ArrayList<Client> statList;
        statList = parsQueues.readFile();
        /*
        сделать чтение файла даты вчерашнего клиента
        проверка на дату сделана
         */
        for (int i = 0; i < statList.size(); i++) {
            if (statList.get(i).getNumber() == client.getNumber()) {
                if (statList.get(i).getDate().equals(client.getDate())) {   // проверка даты
                    client.setMove(MoveToQueue.Y);
                    statList.set(i, client);
                }
            }
        }
        parsQueues.saveToFile(statList);
    }

    public int getLastNumber() {
        return lastNumber;
    }


}
