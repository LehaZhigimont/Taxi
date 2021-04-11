package ModelUI;

import Clients.Queues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class MovingQueue {

    public JFrame moveQueue;
    private Queues queues = new Queues();
    private String[] Combo_move = queues.listQueueForBox();
    private String[] Combo_move1 = queues.listQueueForBox();
    DefaultComboBoxModel combo_move = new DefaultComboBoxModel(Combo_move);
    public static String moveA;
    public static String movedB;



    public MovingQueue() {
        moveQueue = new JFrame("Перемещение");
        moveQueue.setBounds(100, 100, 265, 150);
        moveQueue.setLocationRelativeTo(null);
        moveQueue.setResizable(false);
        moveQueue.setLayout(null);
        ImageIcon icon = new ImageIcon("C:\\Taxi\\data\\image\\icon.png");
        moveQueue.setIconImage(icon.getImage());

        moveQueue.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (!new MainWindow().winTaxiQ.isVisible()) {
                    new MainWindow().winTaxiQ.setVisible(true);

                }
            }
        });


        JLabel label_moving = new JLabel("Переместить:");
        label_moving.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_moving.setBounds(40, 11, 90, 20);
        moveQueue.getContentPane().add(label_moving);

        JLabel label_before = new JLabel("Перед №:");
        label_before.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_before.setBounds(40, 42, 90, 20);
        moveQueue.getContentPane().add(label_before);

        JComboBox comboBox_moving = new JComboBox();
        JComboBox comboBox_befor = new JComboBox();
        comboBox_moving.setBounds(150, 11, 60, 22);
        comboBox_moving.setModel(combo_move);
        comboBox_moving.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox_befor.setModel(new DefaultComboBoxModel(Combo_move1));
                comboBox_befor.setSelectedIndex(1);
            }
        });
        moveQueue.getContentPane().add(comboBox_moving);


        comboBox_befor.setBounds(150, 42, 60, 22);
        moveQueue.getContentPane().add(comboBox_befor);

        JButton button_ok = new JButton("OK");
        button_ok.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {


                button_ok.setEnabled(false);
                int a, b;
                a = comboBox_moving.getSelectedIndex();
                moveA = Combo_move[a];
                b = comboBox_befor.getSelectedIndex();
                movedB = Combo_move1[b];
                System.out.println("move - " + moveA + " moved - " + movedB);
                queues.movingClients();
                queues.updateTableButton();
                moveQueue.setVisible(false);
                new MainWindow().sendFile(2);
                new MainWindow().winTaxiQ.setVisible(true);
                if (new MainWindow().winTaxiQ.isVisible()) {

                }

            }
        });
        button_ok.setBounds(35, 81, 80, 23);
        moveQueue.getContentPane().add(button_ok);

        JButton button_cancel = new JButton("Отмена");
        button_cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                moveQueue.setVisible(false);
                new MainWindow().winTaxiQ.setVisible(true);
                if (new MainWindow().winTaxiQ.isVisible()) {

                }
            }
        });
        button_cancel.setBounds(135, 81, 80, 23);
        moveQueue.getContentPane().add(button_cancel);
    }
}
