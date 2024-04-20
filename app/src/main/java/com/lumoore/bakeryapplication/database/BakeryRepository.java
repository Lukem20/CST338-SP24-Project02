package com.lumoore.bakeryapplication.database;

import android.app.Application;

import com.lumoore.bakeryapplication.database.entities.Bakery;

import java.util.ArrayList;

public class BakeryRepository {
    private BakeryDAO bakeryDAO;
    private ArrayList<Bakery> allOrders;

    public BakeryRepository(Application application) {
        BakeryDatabase db = BakeryDatabase.getDatabase(application);
        this.bakeryDAO = db.bakeryDAO();
    }
}
