package me.developer.suttichai.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.developer.suttichai.dagger.main.MainActivity
import me.developer.suttichai.dagger.main.module.MainModule

@Module
abstract class ActivityBinder {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity
}