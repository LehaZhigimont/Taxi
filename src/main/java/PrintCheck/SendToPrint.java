package PrintCheck;

import Date.CurrentDate;

import java.awt.*;

public class SendToPrint extends Frame {
    private static String[] printCheck;
    private static int numberXX;

    public SendToPrint(String[] s, int number) {
        super("");
        printCheck = new String[s.length];
        for (int i = 0; i < printCheck.length; i++) {
            printCheck[i] = s[i];
            if (i==3){
                printCheck[i] = new CurrentDate().CurrentDateDMYHHMMSS();
            }
        }
        numberXX = number;
        setSize(0, 0);
        setLocation(2000,2000);
        setVisible(true);
    }

    public void simplePrint() {
        PrintJob pj = getToolkit().getPrintJob(this, "Check", null);
        if (pj != null) {
            Graphics pg = pj.getGraphics();
            if (pg != null) {
                print(pg);
                pg.dispose();
            } else System.err.println("Graphics's null");
            pj.end();
        } else System.err.println("Job's null");

        setVisible(false);
    }

    public void paint(Graphics g) {
        Font fontPrint = new Font("Tahoma", Font.PLAIN, 15);
        g.setFont(fontPrint);
        g.setColor(Color.black);


        drawCenteredString(g, printCheck[0], new Rectangle(20, 50, 186, 20), fontPrint);
        drawCenteredString(g, printCheck[1], new Rectangle(20, 70, 186, 20), fontPrint);
        drawCenteredString(g, printCheck[2], new Rectangle(20, 90, 186, 20), fontPrint);
        drawCenteredString(g, printCheck[3], new Rectangle(20, 190, 186, 20), fontPrint);
        drawCenteredString(g, printCheck[4], new Rectangle(20, 210, 186, 20), fontPrint);
        drawCenteredString(g, printCheck[5], new Rectangle(20, 230, 186, 20), fontPrint);
        drawCenteredString(g, printCheck[6], new Rectangle(20, 250, 186, 20), fontPrint);
        g.setFont(new Font("Tahoma", Font.BOLD, 82));
        //g.drawString(numberXX+"", 20, 160);
        drawCenteredString(g, numberXX + "", new Rectangle(20, 130, 186, 40), new Font("Tahoma", Font.BOLD, 82));
    }


    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        // Draw the String
        g.drawString(text, x, y);
    }
}