package models;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import java.time.LocalDateTime;

public class Item {
    private String name;
    private LocalDateTime expiration;
    private boolean expired;

    public Item(String name, LocalDateTime expiration){
        this.name = name;
        this.expiration = expiration;
        setExpired();
    }

    private void setExpired(){
        LocalDateTime now = LocalDateTime.now();
        if (expiration.isBefore(now)){
            expired = false;
        }
        else{
            expired = true;
        }
    }
}