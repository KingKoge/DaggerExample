package me.developer.suttichai.dagger.repo.menu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;
import me.developer.suttichai.dagger.api.ApiManager;
import me.developer.suttichai.dagger.api.ApiResponse;
import me.developer.suttichai.dagger.api.Request;
import me.developer.suttichai.dagger.api.Resource;
import me.developer.suttichai.dagger.api.menu.MenuService;
import me.developer.suttichai.dagger.api.menu.request.MenuBody;
import me.developer.suttichai.dagger.api.menu.response.MenuResult;
import me.developer.suttichai.dagger.db.DatabaseManager;
import me.developer.suttichai.dagger.db.menu.MenuDao;
import me.developer.suttichai.dagger.repo.AppExecutors;
import me.developer.suttichai.dagger.repo.NetworkBoundResource;

public class MenuRepo {
    private static MenuRepo instance;

    public static MenuRepo getInstance() {
        if (instance == null)
            instance = new MenuRepo();

        return instance;
    }

    private MenuService menuService;
    private MenuDao menuDao;
    private AppExecutors appExecutors;

    private MenuRepo() {
        menuService = ApiManager.getMenuService();
        menuDao = DatabaseManager.getMenuDatabase().menuDao();
        appExecutors = AppExecutors.getInstance();
    }

    public LiveData<Resource<MenuResult>> getMenu(Request<MenuBody> request) {
        return new NetworkBoundResource<MenuResult, MenuResult>(appExecutors) {

            @Override
            protected void saveCallResult(@NonNull MenuResult result) {
                menuDao.insert(result.getMenuGroups());
            }

            @Override
            protected boolean shouldFetch(@Nullable MenuResult result) {
                return request.isForceFetch || result == null
                        || result.getMenuGroups() == null
                        || result.getMenuGroups().isEmpty();
            }

            @NonNull
            @Override
            protected LiveData<MenuResult> loadFromDb() {
                return Transformations.map(menuDao.queryAll(), menuGroups -> {
                    MenuResult result = new MenuResult();
                    result.setMenuGroups(menuGroups);
                    result.setSuccess("1");
                    return result;
                });
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<MenuResult>> createCall() {
                MenuBody body = request.data;
                return menuService.getMenu(body.getVersion(),
                        body.getMethod(),
                        body.getBranchId(),
                        body.getPackageId(),
                        body.getFlag());
            }
        }.asLiveData();
    }

    public void clearAllMenuInDatabase() {
        Completable.complete()
                .observeOn(Schedulers.io())
                .subscribe(() -> menuDao.clearAll());
    }
}
