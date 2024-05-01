package com.lumoore.bakeryapplication.database;

import android.app.Application;
import android.util.Log;

import com.lumoore.bakeryapplication.MainActivity;
import com.lumoore.bakeryapplication.database.entities.BakeryOrder;
import com.lumoore.bakeryapplication.database.entities.User;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class BakeryOrderRepository {
    private BakeryOrderDAO bakeryOrderDAO;
    private UserDAO userDAO;
    private ArrayList<BakeryOrder> allOrders;
    // Singleton repository
    private static BakeryOrderRepository repository;

    private BakeryOrderRepository(Application application) {
        BakeryOrderDatabase db = BakeryOrderDatabase.getDatabase(application);
        this.bakeryOrderDAO = db.bakeryDAO();
        this.userDAO = db.userDAO();
        this.allOrders = (ArrayList<BakeryOrder>) this.bakeryOrderDAO.getAllRecords();
    }

    public static BakeryOrderRepository getRepository(Application application) {
        // Singleton pattern for repository to ensure there is only ever one instance.
        if (repository != null) {
            return repository;
        }

        Future<BakeryOrderRepository> future = BakeryOrderDatabase.dbWriteExecutor.submit(
                new Callable<BakeryOrderRepository>() {
                    @Override
                    public BakeryOrderRepository call() throws Exception {
                        return new BakeryOrderRepository(application);
                    }
                }
        );

        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.d("BakeryRepository", "Problem getting Bakery repository thread error.");
        }

        return null;
    }



    // An abstraction to get all records from the DB.
    public ArrayList<BakeryOrder> getAllOrders() {
        // A promise that accesses the DB, and when finished, execute the callback below (Callable).
        Future<ArrayList<BakeryOrder>> future = BakeryOrderDatabase.dbWriteExecutor.submit(new Callable<ArrayList<BakeryOrder>>() {
            @Override
            public ArrayList<BakeryOrder> call() throws Exception {
                return (ArrayList<BakeryOrder>) bakeryOrderDAO.getAllRecords();
            }
        });

        // Wrap the db call in a try catch for safety.
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            Log.i("ACTIVITY", "Failed to get all records from bakeryDAO, problem with executor");
        }

        // Better idea to return an empty Bakery object, but good for now.
        return null;
    }

    public void insertBakeryOrder (BakeryOrder order) {
        BakeryOrderDatabase.dbWriteExecutor.execute(() -> {
            bakeryOrderDAO.insert(order);
        });
    }

    public void insertUser (User... user) {
        BakeryOrderDatabase.dbWriteExecutor.execute(() -> {
            userDAO.insert(user);
        });
    }

    public User getUserbyUserName(String username) {
        Future<User> future = BakeryOrderDatabase.dbWriteExecutor.submit(
            new Callable<User>() {
                @Override
                public User call() throws Exception {
                    return userDAO.getUserByUsername(username);
                }
            });
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            Log.i(MainActivity.TAG, "Failed to get all records from bakeryDAO, problem with executor");
        }

        // Better idea to return an empty Bakery object, but good for now.
        return null;
    }
}

