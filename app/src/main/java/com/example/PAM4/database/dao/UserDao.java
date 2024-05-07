package com.example.PAM4.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import com.example.PAM4.database.entitas.User;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("INSERT INTO user (name,nim) VALUES(:name,:nim)")
    void insertAll(String name, String nim);
}
