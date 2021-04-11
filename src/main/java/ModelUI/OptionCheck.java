package ModelUI;

import Date.CurrentDate;
import ReadWriteFiles.ParsingFile.ParsOptionCheck;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class OptionCheck {
    public JFrame OptionCheck;
    private File file = new File("C:\\Taxi\\data\\check\\check.pr");
    ParsOptionCheck parsOptionCheck = new ParsOptionCheck();
    private String[] text_line = new String[7];


    public OptionCheck() {
        getText_line();
        OptionCheck = new JFrame("Настройки печати чека");
        OptionCheck.setBounds(100, 100, 250, 319);
        OptionCheck.setLayout(null);
        OptionCheck.setLocationRelativeTo(null);
        OptionCheck.setResizable(false);
        ImageIcon icon = new ImageIcon("C:\\Taxi\\data\\image\\icon.png");
        OptionCheck.setIconImage(icon.getImage());


        JLabel numbQueue = new JLabel("  XX");
        numbQueue.setFont(new Font("Tahoma", Font.PLAIN, 40));
        numbQueue.setBounds(68, 98, 101, 40);
        OptionCheck.getContentPane().add(numbQueue);


        JLabel label_data = new JLabel(new CurrentDate().CurrentDateDMYHHMMSS());
        label_data.setHorizontalAlignment(SwingConstants.CENTER);
        label_data.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_data.setBounds(5, 144, 219, 23);
        OptionCheck.getContentPane().add(label_data);

        JTextField text_first_line = new JTextField();
        text_first_line.setHorizontalAlignment(SwingConstants.CENTER);
        text_first_line.setFont(new Font("Tahoma", Font.PLAIN, 13));
        text_first_line.setBounds(30, 20, 186, 20);
        OptionCheck.getContentPane().add(text_first_line);

        JTextField text_second_line = new JTextField();
        text_second_line.setHorizontalAlignment(SwingConstants.CENTER);
        text_second_line.setFont(new Font("Tahoma", Font.PLAIN, 13));
        text_second_line.setColumns(10);
        text_second_line.setBounds(30, 46, 186, 20);
        OptionCheck.getContentPane().add(text_second_line);

        JTextField text_third_line = new JTextField();
        text_third_line.setHorizontalAlignment(SwingConstants.CENTER);
        text_third_line.setFont(new Font("Tahoma", Font.PLAIN, 13));
        text_third_line.setColumns(10);
        text_third_line.setBounds(30, 72, 186, 20);
        OptionCheck.getContentPane().add(text_third_line);

        JTextField text_fourth_line = new JTextField();
        text_fourth_line.setHorizontalAlignment(SwingConstants.CENTER);
        text_fourth_line.setFont(new Font("Tahoma", Font.PLAIN, 13));
        text_fourth_line.setColumns(10);
        text_fourth_line.setBounds(30, 170, 186, 20);
        OptionCheck.getContentPane().add(text_fourth_line);

        JTextField text_fifth_line = new JTextField();
        text_fifth_line.setHorizontalAlignment(SwingConstants.CENTER);
        text_fifth_line.setFont(new Font("Tahoma", Font.PLAIN, 13));
        text_fifth_line.setColumns(10);
        text_fifth_line.setBounds(30, 196, 186, 20);
        OptionCheck.getContentPane().add(text_fifth_line);

        JTextField text_sixth_line = new JTextField();
        text_sixth_line.setHorizontalAlignment(SwingConstants.CENTER);
        text_sixth_line.setFont(new Font("Tahoma", Font.PLAIN, 13));
        text_sixth_line.setColumns(10);
        text_sixth_line.setBounds(30, 222, 186, 20);
        OptionCheck.getContentPane().add(text_sixth_line);


        JCheckBox check_first_line = new JCheckBox();
        check_first_line.setBounds(5, 18, 23, 23);
        if (text_line[0] != null) {
            check_first_line.setSelected(true);
            text_first_line.setText(text_line[0]);
        }
        check_first_line.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    text_line[0] = text_first_line.getText();
                else
                    text_line[0] = " ";
            }
        });
        OptionCheck.getContentPane().add(check_first_line);


        JCheckBox check_second_line = new JCheckBox();
        check_second_line.setBounds(5, 44, 23, 23);
        if (text_line[1] != null) {
            check_second_line.setSelected(true);
            text_second_line.setText(text_line[1]);
        }
        check_second_line.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    text_line[1] = text_second_line.getText();
                else
                    text_line[1] =  " ";
            }
        });
        OptionCheck.getContentPane().add(check_second_line);


        JCheckBox check_third_line = new JCheckBox();
        check_third_line.setBounds(5, 70, 23, 23);
        if (text_line[2] != null) {
            check_third_line.setSelected(true);
            text_third_line.setText(text_line[2]);
        }
        check_third_line.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    text_line[2] = text_third_line.getText();
                else
                    text_line[2] =  " ";
            }
        });
        OptionCheck.getContentPane().add(check_third_line);


        JCheckBox check_fourth_line = new JCheckBox();
        check_fourth_line.setBounds(5, 142, 23, 23);
        if (text_line[3] != null) {
            check_fourth_line.setSelected(true);
        }
        check_fourth_line.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    text_line[3] = new CurrentDate().CurrentDateDMYHHMMSS();
                else
                    text_line[3] =  " ";
            }
        });
        OptionCheck.getContentPane().add(check_fourth_line);


        JCheckBox check_fifth_line = new JCheckBox();
        check_fifth_line.setBounds(5, 168, 23, 23);
        if (text_line[4] != null) {
            check_fifth_line.setSelected(true);
            text_fourth_line.setText(text_line[4]);
        }
        check_fifth_line.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    text_line[4] = text_fourth_line.getText();
                else
                    text_line[4] =  " ";
            }
        });
        OptionCheck.getContentPane().add(check_fifth_line);


        JCheckBox check_sixth_line = new JCheckBox();
        check_sixth_line.setBounds(5, 194, 23, 23);
        if (text_line[5] != null) {
            check_sixth_line.setSelected(true);
            text_fifth_line.setText(text_line[5]);
        }
        check_sixth_line.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    text_line[5] = text_fifth_line.getText();
                else
                    text_line[5] =  " ";
            }
        });
        OptionCheck.getContentPane().add(check_sixth_line);


        JCheckBox check_seventh_line = new JCheckBox();
        check_seventh_line.setBounds(5, 220, 23, 23);
        if (text_line[6] != null) {
            check_seventh_line.setSelected(true);
            text_sixth_line.setText(text_line[6]);
        }
        check_seventh_line.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    text_line[6] = text_sixth_line.getText();
                else
                    text_line[6] =  " ";
            }
        });
        OptionCheck.getContentPane().add(check_seventh_line);


        JButton button_save = new JButton("Сохранить");
        button_save.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("button_save");
                OptionCheck.setVisible(false);

                text_line[0] = text_first_line.getText();
                text_line[1] = text_second_line.getText();
                text_line[2] = text_third_line.getText();
                text_line[3] = new CurrentDate().CurrentDateDMYHHMMSS();
                text_line[4] = text_fourth_line.getText();
                text_line[5] = text_fifth_line.getText();
                text_line[6] = text_sixth_line.getText();
                parsOptionCheck.writeOptionCheck(file, text_line);

                text_line = parsOptionCheck.readOptionCheck(file, text_line);
            }
        });
        button_save.setBounds(62, 246, 100, 23);
        OptionCheck.getContentPane().add(button_save);
    }

    public String[] getText_line() {
        text_line = parsOptionCheck.readOptionCheck(file, text_line);
        return text_line;
    }


}
