package com.detectiveazul.codeclanstudentsimulator.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Gamelog.class}, version = 1)
public abstract class GamelogDatabase extends RoomDatabase {
    public abstract GamelogDao gamelogDao();
}



//    To create an instance of the database
//    GamelogDatabase db = Room.databaseBuilder(getApplicationContext(), GamelogDatabase.class, "gamelog-database").build();

