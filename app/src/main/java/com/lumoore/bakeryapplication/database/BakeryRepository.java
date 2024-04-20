package com.lumoore.bakeryapplication.database;

import android.app.Application;
import android.util.Log;

import com.lumoore.bakeryapplication.database.entities.Bakery;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class BakeryRepository {
    private BakeryDAO bakeryDAO;
    private ArrayList<Bakery> allOrders;

    public BakeryRepository(Application application) {
        BakeryDatabase db = BakeryDatabase.getDatabase(application);
        this.bakeryDAO = db.bakeryDAO();
        this.allOrders = this.bakeryDAO.getAllRecrods();
    }

    public ArrayList<Bakery> getAllOrders() {
        Future<ArrayList<Bakery>> future = BakeryDatabase.dbWriteExecutor.submit(new Callable<ArrayList<Bakery>>() {
            @Override
            public ArrayList<Bakery> call() throws Exception {
                return bakeryDAO.getAllRecrods();
            }
        });

        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            Log.i("ACTIVITY", "Failed to get all records from bakeryDAO, problem with executor");
        }

        return null;
    }

    public void insertBakeryOrder (Bakery order) {
        BakeryDatabase.dbWriteExecutor.execute(() -> {
            bakeryDAO.insert(order);
        });
    }
}
