package ModelUI;

import Clients.Client;
import ReadWriteFiles.ParsingFile.ParsStatistics;


import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Statistics {
    public JFrame frame;
    private JTable table;
    DefaultComboBoxModel listFile = new DefaultComboBoxModel(new ParsStatistics().fileList());
    private String[][] statisticList;
    private Object[] columnsHeader = new String[]{"#", "Время", "Перемещ."};
    private ArrayList<Client> table_list;
    private JLabel label;


    public Statistics() {
        frame = new JFrame("Статистика");
        frame.setBounds(100, 100, 325, 410);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        ImageIcon icon = new ImageIcon("C:\\Taxi\\data\\image\\icon.png");
        frame.setIconImage(icon.getImage());


        label = new JLabel("Дата:");
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setBounds(10, 11, 48, 14);
        frame.getContentPane().add(label);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(listFile);
        comboBox.setBounds(54, 9, 113, 22);
        frame.getContentPane().add(comboBox);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 289, 318);
        frame.getContentPane().add(scrollPane);

        table = new JTable(statisticList, columnsHeader);
        scrollPane.setViewportView(table);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        table.setOpaque(false);
        table.setModel(new DefaultTableModel(
                statisticList, columnsHeader
        ) {
            boolean[] columnEditables = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(0).setMinWidth(30);
        table.getColumnModel().getColumn(0).setMaxWidth(30);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(170);
        table.getColumnModel().getColumn(1).setMinWidth(170);
        table.getColumnModel().getColumn(1).setMaxWidth(170);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(2).setPreferredWidth(70);
        table.getColumnModel().getColumn(2).setMinWidth(70);
        table.getColumnModel().getColumn(2).setMaxWidth(70);
        table.setBounds(10, 40, 264, 318);


        JButton button_ok = new JButton("OK");
        button_ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table_list = new ParsStatistics().reParsFileNameToReadFile(new ParsStatistics().fileList()[comboBox.getSelectedIndex()]);
                parsingListStatisticForTable(table_list);
                table.setModel(new DefaultTableModel(statisticList, columnsHeader));
                table.getColumnModel().getColumn(0).setResizable(false);
                table.getColumnModel().getColumn(0).setPreferredWidth(30);
                table.getColumnModel().getColumn(0).setMinWidth(30);
                table.getColumnModel().getColumn(0).setMaxWidth(30);
                table.getColumnModel().getColumn(1).setResizable(false);
                table.getColumnModel().getColumn(1).setPreferredWidth(170);
                table.getColumnModel().getColumn(1).setMinWidth(170);
                table.getColumnModel().getColumn(1).setMaxWidth(170);
                table.getColumnModel().getColumn(2).setResizable(false);
                table.getColumnModel().getColumn(2).setPreferredWidth(70);
                table.getColumnModel().getColumn(2).setMinWidth(70);
                table.getColumnModel().getColumn(2).setMaxWidth(70);
                table.setBounds(10, 40, 264, 318);


                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

            }
        });
        button_ok.setBounds(177, 9, 95, 23);
        frame.getContentPane().add(button_ok);

    }

    private void parsingListStatisticForTable(ArrayList<Client> table_list) {

        statisticList = new String[table_list.size()][3];

        for (int i = 0; i < statisticList.length; i++) {
            statisticList[i][0] = table_list.get(i).getNumber() + "";
            statisticList[i][1] = CurrentDateDMYHHMMSS(table_list.get(i).getDate());
            statisticList[i][2] = table_list.get(i).getMove().toString();
        }
    }

    public String CurrentDateDMYHHMMSS (Date dataNow){
        Date date = dataNow;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return dateFormat.format(date);
    }

}

