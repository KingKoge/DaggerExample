package me.developer.suttichai.dagger.main;

import java.util.Objects;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import me.developer.suttichai.dagger.api.Request;
import me.developer.suttichai.dagger.api.Resource;
import me.developer.suttichai.dagger.api.menu.request.MenuBody;
import me.developer.suttichai.dagger.api.menu.response.MenuResult;
import me.developer.suttichai.dagger.repo.menu.MenuRepo;
import me.developer.suttichai.dagger.util.AbsentLiveData;

public class MainViewModel extends ViewModel {
    private final MenuRepo menuRepo;
    private LiveData<Resource<MenuResult>> menuResult;
    private final MutableLiveData<Request<MenuBody>> fetchMenu = new MutableLiveData<>();

    public MainViewModel() {
        this.menuRepo = MenuRepo.getInstance();
        this.menuResult = Transformations.switchMap(fetchMenu, body -> {
            if (body == null)
                return AbsentLiveData.create();
            return menuRepo.getMenu(body);
        });
    }

    public void getMenu(Request<MenuBody> request) {
        if (request.isForceFetch) {
            fetchMenu.setValue(null);
            menuRepo.clearAllMenuInDatabase();
        }

        if (fetchMenu.getValue() != null
                && isShouldBeSkip(fetchMenu.getValue().isForceFetch, request.isForceFetch)) {
            return;
        }

        fetchMenu.setValue(request);
    }

    public LiveData<Resource<MenuResult>> getMenuResult() {
        return menuResult;
    }

    private boolean isShouldBeSkip(boolean newForceFetch, boolean oldForceFetch) {
        return Objects.equals(newForceFetch, oldForceFetch) || (newForceFetch && !oldForceFetch);
    }
}