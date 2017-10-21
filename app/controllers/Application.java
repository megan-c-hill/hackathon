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
    private ArrayList<Food> inventory = new ArrayList<>();

    public static void index() {
        render();
    }

    public static void home(){
        render();
    }

    public static void addNew(String name, String date){
        int month, day, year;
        String sMonth, sDay, sYear;

        sYear = date.substring(0,4);
        sMonth = date.substring(5,7);
        sDay = date.substring(8);

        month = Integer.parseInt(sMonth);
        day = Integer.parseInt(sDay);
        year = Integer.parseInt(sYear);

        Food item = new Food(name, year, month, day);
        home();
    }
}