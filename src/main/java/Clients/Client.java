package Clients;

import java.io.Serializable;
import java.util.Date;

public class Client implements Serializable {
    private int number;
    private Priority priority;
    private MoveToQueue move;
    private Date date;


    Client(){
        this.number = new RegistrClientNumber().RegistrClientNumber();
        this.move = MoveToQueue.N;
        this.date = new Date();
    }


    public void setMove(MoveToQueue move) {
        this.move = move;
    }

    public int getNumber() {
        return number;
    }

    public Priority getPriority() {
        return priority;
    }

    public MoveToQueue getMove() {
        return move;
    }

    public Date getDate() {
        return date;
    }


    @Override
    public String toString() {
        return "Numb - " + getNumber() + " Prior - " + getPriority() + " Move - " + getMove() + " Date - " + getDate();
    }
}
