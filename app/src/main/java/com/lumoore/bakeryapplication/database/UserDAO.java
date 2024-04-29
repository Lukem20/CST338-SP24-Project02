package com.lumoore.bakeryapplication.database;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.lumoore.bakeryapplication.database.entities.User;

import java.util.List;

public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User... user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM " + BakeryOrderDatabase.USER_TABLE + " ORDER BY username")
    List<User> getAllUsers();

    @Query("DELETE from " + BakeryOrderDatabase.USER_TABLE)
    void deleteAll();
}