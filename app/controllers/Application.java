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
        //Remember to add item to the fridge
        home();
    }

    public static void results(){
        //This will pass in a fridge
        render();
    }
}