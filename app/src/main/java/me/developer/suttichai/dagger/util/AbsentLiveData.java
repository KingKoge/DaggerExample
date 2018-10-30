package me.developer.suttichai.dagger.util;

import androidx.lifecycle.LiveData;

@SuppressWarnings("unchecked")
public class AbsentLiveData extends LiveData {
    private AbsentLiveData() {
        postValue(null);
    }

    public static <T> LiveData<T> create() {
        return new AbsentLiveData();
    }
}