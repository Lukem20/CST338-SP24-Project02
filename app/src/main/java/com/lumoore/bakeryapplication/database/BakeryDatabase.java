package com.lumoore.bakeryapplication.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.lumoore.bakeryapplication.LoginActivity;
import com.lumoore.bakeryapplication.database.entities.Bakery;

import org.jetbrains.annotations.NonNls;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Bakery.class}, version = 1, exportSchema = false)
public abstract class BakeryDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "Bakery_database";
    public static final String BAKERTY_TABLE = "bakery";
    private static volatile BakeryDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService dbWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    static BakeryDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BakeryDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            BakeryDatabase.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .addCallback(addDefaultValues)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // TODO: add databaseWriteExecutor.execute(() -> { ... })
            // THIS IS WHERE WE WILL ADD DEFUALT USERS
        }
    };

    public abstract BakeryDAO bakeryDAO();
}
