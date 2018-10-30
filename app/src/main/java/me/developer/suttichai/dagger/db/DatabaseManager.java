package me.developer.suttichai.dagger.db;

import android.app.Application;

import androidx.room.Room;
import me.developer.suttichai.dagger.db.menu.MenuDatabase;

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

public class DatabaseManager {
    private static MenuDatabase menuDatabase;

    public static void init(Application app) {
        menuDatabase = Room.databaseBuilder(app, MenuDatabase.class, "menu.db").build();
    }

    public static MenuDatabase getMenuDatabase() {
        return menuDatabase;
    }
}
