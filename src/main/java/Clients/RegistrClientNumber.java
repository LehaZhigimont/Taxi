package Clients;

import Date.CurrentDate;
import ReadWriteFiles.ParsingFile.ParsQueues;


import java.util.ArrayList;

public class RegistrClientNumber {
    private static int currentNumber = 0;

    int RegistrClientNumber() {
        if (currentNumber == 0) {
            if (ValidCrashProgramm() > 0) {
                if (currentNumber >= 99) {
                    currentNumber = 1;
                    return currentNumber;
                } else {
                    currentNumber++;
                    return currentNumber;
                }
            }
        }
        if (DateNow() && currentNumber < 99) {
            currentNumber++;
            return currentNumber;
        } else if (!DateNow() || currentNumber >= 99) {
            currentNumber = 1;
            return currentNumber;
        }
        System.out.println(currentNumber);
        return currentNumber;
    }

    private boolean DateNow() {
        CurrentDate currentDate = new CurrentDate();
        if (currentDate.CurrentHours() <= 23 && currentDate.CurrentMinutes() <= 59 && currentDate.CurrentSeconds() <= 59) {
            return true;
        }
        return false;
    }

    private int ValidCrashProgramm() {
        ArrayList<Client> array = new ParsQueues().readFile();
        if (!array.isEmpty()) {
            currentNumber = array.get(array.size() - 1).getNumber();
        }else {
            return 0;
        }
        return currentNumber;
    }
}
