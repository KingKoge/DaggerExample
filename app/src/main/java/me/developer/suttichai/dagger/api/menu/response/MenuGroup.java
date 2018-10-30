package me.developer.suttichai.dagger.api.menu.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_menu_group")
public class MenuGroup {
    @PrimaryKey
    @SerializedName("menu_group_id")
    @ColumnInfo(name = "col_menu_group_id")
    @NonNull
    private String groupId;
    @SerializedName("menu_group_name")
    @ColumnInfo(name = "col_menu_group_name")
    private String groupName;

    @Ignore
    @SerializedName("template_list")
    private List<Menu> menus;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "MenuGroup{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", menus=" + menus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuGroup)) return false;
        MenuGroup menuGroup = (MenuGroup) o;
        return Objects.equals(getGroupId(), menuGroup.getGroupId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGroupId());
    }
}
