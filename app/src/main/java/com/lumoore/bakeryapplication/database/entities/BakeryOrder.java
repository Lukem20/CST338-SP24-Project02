package com.lumoore.bakeryapplication.database.entities;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.lumoore.bakeryapplication.database.BakeryOrderDatabase;
import com.lumoore.bakeryapplication.database.BakeryOrderDatabase;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(tableName = BakeryOrderDatabase.BAKERY_ORDER_TABLE)
public class BakeryOrder {
    @PrimaryKey(autoGenerate = true)
    private int orderID;
    private int customerID;
    private String foodName;
    private int foodCount;
    private String drinkName;
    private int drinkCount;
    private LocalDateTime orderDate;

    public BakeryOrder(int customerID, String foodName, int foodCount, String drinkName, int drinkCount) {
        this.customerID = customerID;
        this.foodName = foodName;
        this.foodCount = foodCount;
        this.drinkName = drinkName;
        this.drinkCount = drinkCount;
        this.orderDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Bakery{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", foodName='" + foodName + '\'' +
                ", foodCount=" + foodCount +
                ", drinkName='" + drinkName + '\'' +
                ", drinkCount=" + drinkCount +
                ", orderDate=" + orderDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BakeryOrder bakery = (BakeryOrder) o;
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

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
