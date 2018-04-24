package me.developer.suttichai.dagger.main.module

import dagger.Module
import dagger.Provides
import me.developer.suttichai.dagger.ApiService
import me.developer.suttichai.dagger.main.MainActivity
import me.developer.suttichai.dagger.main.MainContract
import me.developer.suttichai.dagger.main.MainPresenter

@Module
class MainModule {

    @Provides
    fun provideMainView(mainActivity: MainActivity): MainContract.View = mainActivity

    @Provides
    fun provideMainPresenter(view: MainContract.View, api: ApiService): MainContract.Presenter {
        return MainPresenter(view, api)
    }
}