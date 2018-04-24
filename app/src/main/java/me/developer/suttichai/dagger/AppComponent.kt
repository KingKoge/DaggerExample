package me.developer.suttichai.dagger

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

interface ComponentBuilder<out C> {
    fun build(): C
}

@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBinder::class])
interface AppComponent {

    fun inject(app: MainApplication)

    @Component.Builder
    interface Builder : ComponentBuilder<AppComponent> {

        @BindsInstance
        fun application(application: Application): Builder
    }
}