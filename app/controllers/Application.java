package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import models.Food;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;

public class Application extends Controller {
    private static Fridge thisFridge = new Fridge();

    public static void index() {
        render();
    }

    public static void home(){
        render();
    }

    public static void addNew(String name, String date){
        int month, day, year;

        year = Integer.parseInt(date.substring(0,4));
        month = Integer.parseInt(date.substring(5,7));
        day = Integer.parseInt(date.substring(8));

        System.out.println(month + " " + day + " " + year);

        Food item = new Food(name, year, month, day);
        thisFridge.add(item);
        home();
    }

    public static void results(){
        ArrayList<Food> fridgeRes = thisFridge.getContents();
        for(int i = 0; i<fridgeRes.size(); i++){
            Food thisFood = fridgeRes.get(i);
            System.out.println(thisFood.getFoodName());
        }
        render(thisFridge);
    }
}