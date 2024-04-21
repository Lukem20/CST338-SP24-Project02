package com.lumoore.bakeryapplication.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.lumoore.bakeryapplication.database.entities.BakeryOrder;
import com.lumoore.bakeryapplication.database.entities.User;
import com.lumoore.bakeryapplication.database.typeConverters.LocalDateTypeConverter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@TypeConverters(LocalDateTypeConverter.class)
@Database(entities = {BakeryOrder.class, User.class}, version = 3, exportSchema = false)
public abstract class BakeryOrderDatabase extends RoomDatabase {
    public static final String USER_TABLE = "user_table";
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
            dbWriteExecutor.execute(() -> {
                UserDAO dao = INSTANCE.userDAO();
                dao.deleteAll();
                User admin1 = new User("admin1", "admin1");
                admin1.setAdmin(true);
                dao.insert(admin1);

                User testUser1 = new User("testuser1", "testuser1");
                dao.insert(testUser1);
            });
        }
    };

    public abstract BakeryOrderDAO bakeryDAO();
    public abstract UserDAO userDAO();
}
