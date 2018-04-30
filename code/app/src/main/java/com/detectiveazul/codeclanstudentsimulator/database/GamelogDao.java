package com.detectiveazul.codeclanstudentsimulator.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface GamelogDao {
    @Query("SELECT * FROM gamelog ORDER BY score")
    List<Gamelog> getAll();

    @Insert
    void insertAll(Gamelog... gamelogs);

    @Delete
    void delete(Gamelog gamelog);


}
