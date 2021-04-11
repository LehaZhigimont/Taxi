package ModelUI;

import javax.swing.*;
import java.awt.*;

public class About {
    public JFrame about;



    public About() {
        about = new JFrame("О программе");
        about.setBounds(100, 100, 265, 130);
        about.setLocationRelativeTo(null);
        about.getContentPane().setLayout(null);
        about.setResizable(false);
        ImageIcon icon = new ImageIcon("C:\\Taxi\\data\\image\\icon.png");
        about.setIconImage(icon.getImage());


        JLabel lblNtcn = new JLabel("По всем вопросам обращаться:");
        lblNtcn.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNtcn.setBounds(30, 10, 200, 20);
        about.getContentPane().add(lblNtcn);

        JLabel label_1 = new JLabel("Тел.: +375 (29) 390 58 54");
        label_1.setBounds(60, 35, 172, 20);
        about.getContentPane().add(label_1);

        JLabel label_2 = new JLabel("E-mail: 3905854@gmail.com");
        label_2.setBounds(60, 55, 172, 20);
        about.getContentPane().add(label_2);
    }
}
