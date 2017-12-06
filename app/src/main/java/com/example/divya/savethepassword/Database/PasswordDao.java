package com.example.divya.savethepassword.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by divya on 12/5/2017.
 */

@Dao
public interface PasswordDao {

    @Insert
    void InsertPassword(Password password);

    @Query("SELECT * FROM Password")
    List<Password> getAll();

}
