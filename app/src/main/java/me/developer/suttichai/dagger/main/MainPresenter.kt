package me.developer.suttichai.dagger.main

import me.developer.suttichai.dagger.ApiService
import me.developer.suttichai.dagger.logD

class MainPresenter(private val view: MainContract.View, private val api: ApiService) : MainContract.Presenter {

    override fun printHello() {
        this.logD("Hello")
    }

    override fun start() {
        api.loadData()
    }

    override fun stop() {

    }
}