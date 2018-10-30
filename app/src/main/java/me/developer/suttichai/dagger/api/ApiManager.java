package me.developer.suttichai.dagger.api;

import me.developer.suttichai.dagger.api.config.Url;
import me.developer.suttichai.dagger.api.menu.MenuService;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    private static MenuService menuService;

    public static MenuService getMenuService() {
        if (menuService == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .addNetworkInterceptor(getDefaultHttpLoggingInterceptor())
                    .addInterceptor(chain -> {
                        Request originalRequest = chain.request();
                        HttpUrl originalUrl = originalRequest.url();
                        HttpUrl url = originalUrl.newBuilder().build();
                        Request newRequest = originalRequest.newBuilder()
                                .url(url)
                                .header("x-api-key", Url.APIKEY)
                                .build();

                        return chain.proceed(newRequest);
                    });

            menuService = new Retrofit.Builder()
                    .baseUrl(Url.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                    .client(builder.build())
                    .build()
                    .create(MenuService.class);
        }
        return menuService;
    }

    private static HttpLoggingInterceptor getDefaultHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor(new PrettyHttpLogger()).setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
