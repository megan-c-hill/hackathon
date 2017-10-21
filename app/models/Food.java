package models;

import java.time.LocalDate;
import java.time.format.*;

public class Food {


    public String foodName;
    public LocalDate ExpirationDate;
    public boolean expired;

    public Food(String foodname, int year, int month, int day) {

        this.foodName = foodname;
        this.ExpirationDate = LocalDate.of(year, month, day);
        this.expired = true;

    }

    public Food(String foodName, LocalDate expirationDate){
        this.foodName = foodName;
        this.ExpirationDate = expirationDate;
    }

    public String getFoodName() {
        return foodName;
    }

    public LocalDate getExpirationDate() {

        return ExpirationDate;

    }

    public void setExpirationDate(LocalDate newDate) {

        this.ExpirationDate = newDate;

    }

    public boolean isExpired() {
        LocalDate currentDate = LocalDate.now();
        if (currentDate.isAfter(ExpirationDate)){
            expired = false;
        }
        return expired;

    }
}