package com.example.divya.savethepassword.Database;

/**
 * Created by divya on 12/4/2017.
 */
import android.arch.persistence.room.*;
import android.support.annotation.NonNull;


@Entity
public class Password {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PrimaryKey @NonNull
    public String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ColumnInfo
    public String username;

    @ColumnInfo
    public String password;

    public Password(String name, String username, String password)
    {
        this.name = name;
        this.username = username;
        this.password = password;
    }


}
