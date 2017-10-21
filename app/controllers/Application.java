package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import java.util.ArrayList;


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

        home();
    }
}