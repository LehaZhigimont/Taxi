package ReadWriteFiles.Replace;

import java.util.ArrayList;

public class Panel {
    private ArrayList<PanelTabel> panelTabels = new ArrayList<>();
    private String[] arr;


    public Panel(String[][] table, String firstNumber, String[] nameFiles) {
        PanelTabel tabelClient;
        arr = converterArrayString(table, firstNumber);
        int parsInt;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].length()>0) {
                parsInt = Integer.parseInt(arr[i]);
                tabelClient = new PanelTabel(i, parsInt, nameFiles);
                panelTabels.add(tabelClient);
            } else {
                tabelClient = new PanelTabel(i, -1, nameFiles);
                panelTabels.add(tabelClient);
            }
        }
    }


    public ArrayList<PanelTabel> getPanelTabels() {
        return panelTabels;
    }


    public String[] converterArrayString(String[][] array, String first) {
        arr = new String[17];
        arr[0] = first;
        System.out.println(arr[0]);
        for (int i = 0; i < array.length; i++) {
            arr[i + 1] = array[i][0];
            arr[9 + i] = array[i][1];
            //System.out.println(arr[i + 1]);
        }
        /*for (int i = 0; i < array.length; i++) {
            arr[9 + i] = array[i][1];
            //System.out.println(arr[9 + i]);
        }*/
        return arr;
    }


}
