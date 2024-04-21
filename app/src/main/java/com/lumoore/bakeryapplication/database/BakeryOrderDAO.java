package com.lumoore.bakeryapplication.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.lumoore.bakeryapplication.database.entities.BakeryOrder;

import java.util.List;

@Dao
public interface BakeryOrderDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(BakeryOrder orderRecordItem);

    @Query("SELECT * FROM " + BakeryOrderDatabase.BAKERY_ORDER_TABLE + " ORDER BY orderDate ASC")
    List<BakeryOrder> getAllRecords();

}