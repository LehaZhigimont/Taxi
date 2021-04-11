package ModelUI;

import Audio.PlaySound;
import Clients.Queues;
import PrintCheck.SendToPrint;
import ReadWriteFiles.ParsingFile.ParsQueues;
import ReadWriteFiles.WriteFile;


import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class MainWindow {
    public JFrame winTaxiQ;
    private JTable table_queues;
    private JButton button_number_queue_taxi;
    public static String buttonText = new String();
    private static String[] columnsQueue = new String[]{"Column1-8", "Column9-16"};
    public static String[][] now_queue = new String[8][2];
    private ParsQueues parsQueues = new ParsQueues();
    private Queues queues = new Queues();

    public MainWindow() {
        winTaxiQ = new JFrame("Очередь");
        winTaxiQ.setBounds(100, 100, 275, 360);
        winTaxiQ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winTaxiQ.setLocationRelativeTo(null);
        winTaxiQ.setResizable(false);
        winTaxiQ.getContentPane().setLayout(null);


        parsQueues.UpdateQueueOfFile();
        queues.updateTableButton();
        ImageIcon icon = new ImageIcon("C:\\Taxi\\data\\image\\icon.png");
        winTaxiQ.setIconImage(icon.getImage());

        /*
         *********************************MENU********************************
         */


        JMenuBar menuBar = new JMenuBar();
        winTaxiQ.setJMenuBar(menuBar);

        JMenu FileMenu = new JMenu("Файл");
        menuBar.add(FileMenu);

        JMenu menu_options = new JMenu("Настройки");
        menu_options.setEnabled(true);
        FileMenu.add(menu_options);


        JMenuItem menuItem_options_check = new JMenuItem("Чек");
        menu_options.add(menuItem_options_check);
        menuItem_options_check.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                OptionCheck optionCheck = new OptionCheck();
                optionCheck.OptionCheck.setVisible(true);
            }
        });

        JMenuItem menuItem_exit_programm = new JMenuItem("Выход");
        menuItem_exit_programm.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        FileMenu.add(menuItem_exit_programm);

        JMenu AboutMenu = new JMenu("О программе");
        menuBar.add(AboutMenu);


        JMenuItem menuItem_about = new JMenuItem("О программе");
        menuItem_about.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new About().about.setVisible(true);
            }
        });
        AboutMenu.add(menuItem_about);

        /*
         ******************************END MENU*****************************
         */



        /*
        +++++++++++++++++++++++ RETURN VOICE QUEUE ++++++++++++++++++++++++++++
         */

        button_number_queue_taxi = new JButton(buttonText);
        if (buttonText == "") {
            button_number_queue_taxi.setEnabled(false);
        } else {
            button_number_queue_taxi.setEnabled(true);
        }
        button_number_queue_taxi.setFont(new Font("Tahoma", Font.BOLD, 20));
        button_number_queue_taxi.setBounds(125, 30, 80, 23);
        button_number_queue_taxi.addActionListener(e -> {
            if (!button_number_queue_taxi.getText().isEmpty()) {
                if (buttonText != "") {
                    new PlaySound(new File("c:\\Taxi\\audio\\" + buttonText + ".wav")).play();
                }
            }
        });
        winTaxiQ.getContentPane().add(button_number_queue_taxi);

        /*
        ----------------------- RETURN VOICE QUEUE ------------------------------
         */



        /*
        +++++++++++++++++++++++++++++TABLE+++++++++++++++++++++++++++++++++
         */

        JLabel label_on_drive = new JLabel("На выезд");
        label_on_drive.setHorizontalAlignment(SwingConstants.CENTER);
        label_on_drive.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label_on_drive.setBounds(10, 0, 240, 30);
        winTaxiQ.getContentPane().add(label_on_drive);

        JLabel label_ticket_numb = new JLabel("билет №: ");
        label_ticket_numb.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label_ticket_numb.setBounds(40, 26, 100, 30);
        winTaxiQ.getContentPane().add(label_ticket_numb);

        JLabel label = new JLabel("В очереди");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label.setBounds(10, 60, 240, 30);
        winTaxiQ.getContentPane().add(label);

        table_queues = new JTable();
        table_queues.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table_queues.setEnabled(false);
        table_queues.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        table_queues.setModel(new DefaultTableModel(now_queue, columnsQueue));
        table_queues.getColumnModel().getColumn(0).setResizable(false);
        table_queues.getColumnModel().getColumn(0).setMinWidth(25);
        table_queues.getColumnModel().getColumn(0).setMaxWidth(120);
        table_queues.getColumnModel().getColumn(1).setResizable(false);
        table_queues.getColumnModel().getColumn(1).setMinWidth(25);
        table_queues.getColumnModel().getColumn(1).setMaxWidth(120);
        table_queues.setBounds(10, 90, 240, 128);
        winTaxiQ.getContentPane().add(table_queues);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table_queues.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table_queues.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);




        /*
        -----------------------------TABLE---------------------------------
         */


        /*
         ***************************** BUTTONS*******************************
         */


        JButton button_registration = new JButton("Регистрация");
        JButton button_next = new JButton("Следующий");
        JButton button_move_queue = new JButton("Премещение");
        JButton button_statistics = new JButton("Статистика");

        //                  BUTTON REGISTRATION

        button_registration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queues.Queues();

                sendFile(0);

                table_queues.setModel(new DefaultTableModel(now_queue, columnsQueue));
                button_number_queue_taxi.setText(buttonText);


                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_queues.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_queues.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);


                int numberXX = queues.getClientsQueue().get(queues.getClientsQueue().size() - 1).getNumber();
                new SendToPrint(new OptionCheck().getText_line(), numberXX).simplePrint();

                if (buttonText == "") {
                    button_next.setEnabled(false);
                } else {
                    button_next.setEnabled(true);
                    button_number_queue_taxi.setEnabled(true);
                    if (now_queue[1][0] != null)
                        button_move_queue.setEnabled(true);
                    else
                        button_move_queue.setEnabled(false);
                }
            }

        });
        button_registration.setBounds(10, 230, 112, 23);
        winTaxiQ.getContentPane().add(button_registration);


        //                 END BUTTON REGISTRATION


        //                      BUTTON NEXT

        button_next.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (button_next.isEnabled()) {
                    System.out.println("button_next");
                    queues.shiftFirstForQueue();


                    if (!button_number_queue_taxi.getText().isEmpty()) {
                        if (buttonText != "") {
                            new PlaySound(new File("c:\\Taxi\\audio\\" + buttonText + ".wav")).play();
                        }
                    }

                    button_number_queue_taxi.setText(buttonText);
                    table_queues.setModel(new DefaultTableModel(now_queue, columnsQueue));

                    sendFile(1);

                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                    table_queues.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                    table_queues.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

                }
                if (buttonText == "") {
                    button_next.setEnabled(false);
                    button_number_queue_taxi.setEnabled(false);
                } else {
                    button_next.setEnabled(true);
                    button_number_queue_taxi.setEnabled(true);
                }
                if (now_queue[1][0] != null)
                    button_move_queue.setEnabled(true);
                else
                    button_move_queue.setEnabled(false);
            }
        });
        button_next.setBounds(132, 230, 118, 23);
        if (buttonText == "")
            button_next.setEnabled(false);
        else
            button_next.setEnabled(true);
        winTaxiQ.getContentPane().add(button_next);
        //                  END BUTTON NEXT

        //                  BUTTON MOVING QUEUE

        button_move_queue.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (button_move_queue.isEnabled()) {
                    System.out.println("button_move_queue");
                    MovingQueue movingQueue = new MovingQueue();
                    movingQueue.moveQueue.setVisible(true);

                    //sendFile(2);
                    winTaxiQ.setVisible(false);
                    button_number_queue_taxi.setText(buttonText);
                }
            }
        });
        button_move_queue.setBounds(10, 265, 112, 23);
        if (now_queue[1][0] != null)
            button_move_queue.setEnabled(true);
        else
            button_move_queue.setEnabled(false);
        winTaxiQ.getContentPane().add(button_move_queue);
        //                  END BUTTON MOVING QUEUE

        //                  BUTTON STATISTICS

        button_statistics.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button_statistics");
                Statistics statistics = new Statistics();
                statistics.frame.setVisible(true);
            }
        });
        button_statistics.setBounds(132, 265, 118, 23);
        winTaxiQ.getContentPane().add(button_statistics);
        //                 END BUTTON STATISTICS


        /*
         *************************END BUTTONS********************************
         */


    }

    public void sendFile(int who) {
        String s = "";
        if (who == 1)
            s = "0";
        if (who == 0)
            s = "2";
        if (who == 2)
            s = "0";
        new WriteFile().WriteForFile(new File("temp_api.dat"), s);
    }

    private class gThread extends Thread {
        public void run() {
            try {
                sleep(10000);
            } catch (InterruptedException e) {


            }
        }
    }


}
