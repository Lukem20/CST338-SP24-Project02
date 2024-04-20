package com.lumoore.bakeryapplication.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.lumoore.bakeryapplication.database.entities.BakeryOrder;
import com.lumoore.bakeryapplication.database.typeConverters.LocalDateTypeConverter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@TypeConverters(LocalDateTypeConverter.class)
@Database(entities = {BakeryOrder.class}, version = 1, exportSchema = false)
public abstract class BakeryOrderDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "Bakery_database";
    public static final String BAKERY_ORDER_TABLE = "bakeryOrder";
    private static volatile BakeryOrderDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService dbWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    static BakeryOrderDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BakeryOrderDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            BakeryOrderDatabase.class, DATABASE_NAME)
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
            // THIS IS WHERE WE WILL ADD DEFAULT USERS & ADMIN
        }
    };

    public abstract BakeryOrderDAO bakeryDAO();
}
