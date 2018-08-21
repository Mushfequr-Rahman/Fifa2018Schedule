package com.bashundhara.mushfequr.fifa2018schedule;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface UserDao {

    @Query("Select * From INFO")
    List<User> getAllUsers();

    @Query("Select * From INFO Limit 1 ")
    Flowable<User> getUser();

    @Query("Select * From INFO Where Game Like :Game")
        User findbyGame(String Game);



    //Insert Data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
        void InsertUser(User user);

    @Query("Delete From INFO")
        void deleteAllUser();




}
