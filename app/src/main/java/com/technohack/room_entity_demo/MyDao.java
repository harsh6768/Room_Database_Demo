package com.technohack.room_entity_demo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    void addUser(Users user);

    @Query("select *from users")
    List<Users> getUsers();

    @Delete
    void deleteUser(Users users);

    @Update
    void updateUser(Users users);

}
