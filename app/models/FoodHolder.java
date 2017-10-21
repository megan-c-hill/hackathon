package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class FoodHolder {

    private ArrayList<Food> foodHolder = new ArrayList<Food>();
    private ArrayList<Food> expired = new ArrayList<Food>();
    private ArrayList<Food> good = new ArrayList<Food>();

    private int numItems;

    public FoodHolder() {
        this.numItems = 0;
    }

    /**
     * @param foodName   - name of food to add
     * @param year       - year of expiration
     * @param month      - month of expiration
     * @param dayOfMonth - day of month of expiration
     */
    public void addFood(String foodName, int year, int month, int dayOfMonth) {
        LocalDate expireDate = LocalDate.of(year, month, dayOfMonth);

        foodHolder.add(new Food(foodName.toLowerCase(), expireDate));
        numItems++;

        updateInventory();

    }

    public void add (Food thisFood){
        foodHolder.add(thisFood);
        numItems++;

        updateInventory();
    }

    /**
     * Removes food from inventory
     *
     * @param toRemove Name of food to remove
     */
    public void removeFood(String toRemove) {

        int removeIndex = findFood(toRemove);

        if (removeIndex != -1) {

            foodHolder.remove(removeIndex);
            numItems--;

        }

        updateInventory();

    }

    /**
     * returns full inventory list
     *
     * @return foodHolder
     */
    public ArrayList<Food> getInventory() {


        return foodHolder;

    }

    /**
     * Returns number of items in Inventory
     *
     * @return numItems
     */
    public int getInventoryCount() {
        return numItems;
    }

    /**
     * Returns ArrayList of expired food
     *
     * @return expired
     */
    public ArrayList<Food> getExpiredFood() {
        updateInventory();
        return expired;
    }

    /**
     * Returns Arraylist of non expired food
     *
     * @return good
     */
    public ArrayList<Food> getGoodFood() {
        updateInventory();
        return good;
    }

    /**
     * Updates expired and good food inventory lists
     */

    private void updateInventory() {

        expired.clear();
        good.clear();

        for (int i = 0; i < foodHolder.size(); i++) {
            Food item = foodHolder.get(i);

            if (item.isExpired()) {
                expired.add(item);
            } else {
                good.add(item);
            }
        }

    }

    /**
     * Finds food in inventory; used in removeFood
     *
     * @param toFind - name of food item to find
     * @return Returns index of food item
     */
    private int findFood(String toFind) {
        int index = -1;

        for (int i = 0; i < foodHolder.size(); i++) {
            if (foodHolder.get(i).getFoodName().equalsIgnoreCase(toFind)) {
                index = i;
            }
        }

        return index;
    }

    public void sortInventoryByDate() {

        this.foodHolder = mergeSort(this.foodHolder, 1);


    }

    public void sortExpiredByDate(ArrayList<Food> toSort) {

        this.expired = mergeSort(this.expired, 1);


    }

    public void sortByDate(ArrayList<Food> toSort) {

        this.good = mergeSort(this.good, 1);


    }

    /**
     * Sorts specified list by alphabet
     *
     * @param listToSort
     * @return
     */
    public void sortInventoryByName() {

        this.foodHolder = mergeSort(this.foodHolder, 2);

    }

    public void sortExpiredByName() {

        this.expired = mergeSort(this.expired, 2);

    }

    public void sortGoodByName() {

        this.good = mergeSort(this.good, 2);

    }

    /**
     * @param toSort
     * @param method
     * @return
     */
    private ArrayList<Food> mergeSort(ArrayList<Food> toSort, int method) {

        ArrayList<Food> left = new ArrayList<Food>();
        ArrayList<Food> right = new ArrayList<Food>();
        int middle;

        if (toSort.size() == 1) {
            return toSort;
        } else {
            middle = toSort.size() / 2;

            for (int i = 0; i < middle; i++) {
                left.add(toSort.get(i));
            }
            for (int i = middle; i < toSort.size(); i++) {
                right.add(toSort.get(i));
            }

            left = mergeSort(left, method);
            right = mergeSort(right, method);
            if (method == 1)
                return merge(left, right, toSort);
            else
                return name(left, right, toSort);
        }

    }

    /**
     * @param left
     * @param right
     * @param toSort
     * @return
     */
    private ArrayList<Food> merge(ArrayList<Food> left, ArrayList<Food> right, ArrayList<Food> toSort) {
        int lIndex = 0;
        int rIndex = 0;

        ArrayList<Food> temp = new ArrayList<Food>();

        while (lIndex < left.size() && rIndex < right.size()) {
            if (left.get(lIndex).getExpirationDate().isBefore(right.get(rIndex).getExpirationDate()))
                temp.add(left.get(lIndex++));
            else
                temp.add(right.get(rIndex++));

        }

        while (lIndex < left.size()) {
            temp.add(left.get(lIndex++));
        }
        while (rIndex < right.size()) {
            temp.add(right.get(rIndex++));
        }

        return temp;

    }

    /**
     * @param left
     * @param right
     * @param toSort
     * @return
     */
    private ArrayList<Food> name(ArrayList<Food> left, ArrayList<Food> right, ArrayList<Food> toSort) {
        int lIndex = 0;
        int rIndex = 0;

        ArrayList<Food> temp = new ArrayList<Food>();

        while (lIndex < left.size() && rIndex < right.size()) {
            if (left.get(lIndex).getFoodName().compareToIgnoreCase(right.get(rIndex).getFoodName()) < 0)
                temp.add(left.get(lIndex++));
            else
                temp.add(right.get(rIndex++));
        }

        while (lIndex < left.size()) {
            temp.add(left.get(lIndex++));
        }
        while (rIndex < right.size()) {
            temp.add(right.get(rIndex++));
        }

        return temp;

    }
}