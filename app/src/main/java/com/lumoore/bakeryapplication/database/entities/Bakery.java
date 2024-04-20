package com.lumoore.bakeryapplication.database.entities;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.lumoore.bakeryapplication.database.BakeryDatabase;

import java.time.LocalDate;
import java.util.Objects;

@Entity(tableName = BakeryDatabase.BAKERTY_TABLE)
public class Bakery {
    @PrimaryKey(autoGenerate = true)
    private int orderID;
    private int customerID;
    private String foodName;
    private int foodCount;
    private String drinkName;
    private int drinkCount;
    private LocalDate orderDate;

    public Bakery(int customerID, String foodName, int foodCount, String drinkName, int drinkCount) {
        this.customerID = customerID;
        this.foodName = foodName;
        this.foodCount = foodCount;
        this.drinkName = drinkName;
        this.drinkCount = drinkCount;
        this.orderDate = LocalDate.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bakery bakery = (Bakery) o;
        return customerID == bakery.customerID && foodCount == bakery.foodCount && drinkCount == bakery.drinkCount && orderID == bakery.orderID && orderDate == bakery.orderDate && Objects.equals(foodName, bakery.foodName) && Objects.equals(drinkName, bakery.drinkName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, foodName, foodCount, drinkName, drinkCount, orderID, orderDate);
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public int getDrinkCount() {
        return drinkCount;
    }

    public void setDrinkCount(int drinkCount) {
        this.drinkCount = drinkCount;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
