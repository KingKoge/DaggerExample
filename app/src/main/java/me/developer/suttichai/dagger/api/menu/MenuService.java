package me.developer.suttichai.dagger.api.menu;

import androidx.lifecycle.LiveData;
import me.developer.suttichai.dagger.api.ApiResponse;
import me.developer.suttichai.dagger.api.menu.response.MenuResult;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import static me.developer.suttichai.dagger.api.config.Url.V2;

public interface MenuService {

    @POST(V2)
    @FormUrlEncoded
    LiveData<ApiResponse<MenuResult>> getMenu(
            @Field("android_version") String version,
            @Field("method") String method,
            @Field("branch_id") String branchId,
            @Field("package_id") String packageId,
            @Field("mobile_order_flag") String flag);
}
