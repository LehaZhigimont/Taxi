package ReadWriteFiles.Replace;

import java.io.File;

public class PanelTabel {

    private File pathFile;
    private int position;
    private int number = -1;
    private ColorTypes colorTypes;
    private String nameFile;
    private String pathFileGreen = "C:\\Taxi\\data\\image\\green\\";
    private String pathFileYelow = "C:\\Taxi\\data\\image\\yellow\\";
    private String pathFileRed = "C:\\Taxi\\data\\image\\red\\";


    PanelTabel(int position, int number, String[] nameFiles) {
        this.position = position;
        this.number = number;
        if (number > 0) {
            if (position == 0) {
                this.colorTypes = ColorTypes.GREEN;
                pathFile = new File(pathFileGreen + number + "g.png");
            } else if (position == 1) {
                this.colorTypes = ColorTypes.YELLOW;
                pathFile = new File(pathFileYelow + number + "y.png");
            } else {
                this.colorTypes = ColorTypes.RED;
                pathFile = new File(pathFileRed + number + "r.png");
            }
            this.nameFile = nameFiles[position];
        } else {
            this.colorTypes = ColorTypes.BLACK;
            pathFile = new File("C:\\Taxi\\data\\image\\no_image\\no_img.png");
            this.nameFile = nameFiles[position];
        }
    }

    public File getPathFile() {
        return pathFile;
    }

    public int getPosition() {
        return position;
    }

    public String getNameFile() {
        return nameFile;
    }

    public int getNumber() {
        return number;
    }

    public ColorTypes getColorTypes() {
        return colorTypes;
    }
}
