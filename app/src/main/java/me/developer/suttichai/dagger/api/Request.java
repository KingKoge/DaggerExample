package me.developer.suttichai.dagger.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Request<T> {

    @NonNull
    public final boolean isForceFetch;

    @Nullable
    public final T data;

    public Request(@Nullable T data, @Nullable boolean isForceFetch) {
        this.data = data;
        this.isForceFetch = isForceFetch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request<?> request = (Request<?>) o;

        if (isForceFetch != request.isForceFetch) return false;
        return data != null ? data.equals(request.data) : request.data == null;
    }

    @Override
    public int hashCode() {
        int result = (isForceFetch ? 1 : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Request{" +
                "isForceFetch=" + isForceFetch +
                ", data=" + data +
                '}';
    }
}