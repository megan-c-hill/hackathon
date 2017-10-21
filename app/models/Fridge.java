package models;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Fridge{
    private ArrayList<Food> contents;

    public Fridge(ArrayList<Food> contents){
        this.contents = contents;
    }
    public Fridge(){
        contents = new ArrayList<>();
    }
    public Fridge(Food item){
        contents = new ArrayList<>();
        contents.add(item);
    }

    public void add(Food item){
        contents.add(item);
    }

    public ArrayList<Food> getContents(){
        return contents;
    }
}