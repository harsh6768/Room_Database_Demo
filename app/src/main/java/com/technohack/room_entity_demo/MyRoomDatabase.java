package com.technohack.room_entity_demo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = {Users.class},version = 1)
public abstract class MyRoomDatabase extends RoomDatabase {

    public abstract MyDao myDao();        //it returns should be the Data Acesss Object class

}
