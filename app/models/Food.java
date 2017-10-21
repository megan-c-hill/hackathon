package models;

import java.time.LocalDate;
import java.time.format.*;

public class Food {


    public String foodName;
    public LocalDate ExpirationDate;
    public boolean expired;
    private LocalDate currentDate;

    public Food(String foodname, int year, int month, int day) {

        this.foodName = foodname;
        this.ExpirationDate = LocalDate.of(year, month, day);
        this.expired = false;
        currentDate = LocalDate.now();

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

        if (currentDate.isAfter(ExpirationDate)){
            expired = true;
        }
        return expired;

    }
}