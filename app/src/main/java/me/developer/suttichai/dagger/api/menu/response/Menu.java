package me.developer.suttichai.dagger.api.menu.response;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "tbl_menu",
        foreignKeys = @ForeignKey(entity = MenuGroup.class,
                parentColumns = "col_menu_group_id",
                childColumns = "col_menu_group_id",
                onDelete = CASCADE,
                onUpdate = CASCADE
        )
)
public class Menu {
    @PrimaryKey
    @SerializedName("menu_id")
    @ColumnInfo(name = "col_menu_id")
    @NonNull
    private String menuId;
    @ColumnInfo(name = "col_menu_group_id")
    private String groupId;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
