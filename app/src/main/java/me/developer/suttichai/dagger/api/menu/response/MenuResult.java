package me.developer.suttichai.dagger.api.menu.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.annotation.NonNull;

public class MenuResult {
    @SerializedName("success")
    private String success;
    @SerializedName("requestID")
    private String requestID;
    @NonNull
    @SerializedName("error")
    private String error = "";

    @SerializedName("menu_group_list")
    private List<MenuGroup> menuGroups;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    @NonNull
    public String getError() {
        return error;
    }

    public void setError(@NonNull String error) {
        this.error = error;
    }

    public List<MenuGroup> getMenuGroups() {
        return menuGroups;
    }

    public void setMenuGroups(List<MenuGroup> menuGroups) {
        this.menuGroups = menuGroups;
    }
}