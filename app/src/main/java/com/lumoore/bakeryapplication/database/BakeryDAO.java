package com.lumoore.bakeryapplication.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.lumoore.bakeryapplication.database.entities.Bakery;

import java.util.ArrayList;

@Dao
public interface BakeryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Bakery orderRecordItem);

    @Query("Select * from " + BakeryDatabase.BAKERTY_TABLE)
    ArrayList<Bakery> getAllRecrods();


}
