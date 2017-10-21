package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import models.Food;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Application extends Controller {
    private ArrayList<Food> inventory = new ArrayList<>();

    public static void index() {
        render();
    }

    public static void home(){
        render();
    }

    public static void addNew(String name, String date){
        //Initialize a food item and add it to the inventory
        DateTimeFormatter format = DateTimeFormatter.ofPattern("mm/dd/yyyy");
        LocalDateTime expiration = LocalDateTime.parse(date, format);

        //Food item = new Food(name, expiration);
        //inventory.add(thisFood);

        home();
    }
}