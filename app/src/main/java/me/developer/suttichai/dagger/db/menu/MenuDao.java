package me.developer.suttichai.dagger.db.menu;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import me.developer.suttichai.dagger.api.menu.response.Menu;
import me.developer.suttichai.dagger.api.menu.response.MenuGroup;

@Dao
public interface MenuDao {
    @Query("DELETE FROM tbl_menu_group")
    void clearAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<MenuGroup> menuGroups);

    @Query("SELECT * FROM tbl_menu_group")
    LiveData<List<MenuGroup>> queryAll();

    @Query("SELECT * FROM tbl_menu")
    LiveData<List<Menu>> getMenus();
}
