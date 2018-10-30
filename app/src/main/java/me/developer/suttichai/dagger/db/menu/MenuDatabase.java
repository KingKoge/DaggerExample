package me.developer.suttichai.dagger.db.menu;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import me.developer.suttichai.dagger.api.menu.response.Menu;
import me.developer.suttichai.dagger.api.menu.response.MenuGroup;

@Database(entities = {MenuGroup.class, Menu.class}, version = 1)
public abstract class MenuDatabase extends RoomDatabase {

    abstract public MenuDao menuDao();
}
