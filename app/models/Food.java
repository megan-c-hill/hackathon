package models;

import java.time.LocalDateTime;
import java.time.format.*;

public class Food {


    public String foodName;
    public LocalDateTime ExpirationDate;
    public boolean expired;
    private LocalDateTime currentDate;

    public void Food(String foodname, LocalDateTime date) {

        this.foodName = foodname;
        this.ExpirationDate = date;
        this.expired = false;
        currentDate = LocalDateTime.now();

    }

    public String getFoodName() {
        return foodName;
    }

    public LocalDateTime getExpirationDate() {

        return ExpirationDate;

    }

    public void setExpirationDate(LocalDateTime newDate) {

        this.ExpirationDate = newDate;

    }

    public boolean isExpired() {

        if (currentDate.isAfter(ExpirationDate)){
            expired = true;
        }
        return expired;

    }
}