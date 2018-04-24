package me.developer.suttichai.dagger.main

import me.developer.suttichai.dagger.base.BasePresenter

interface MainContract {

    interface View {

    }

    interface Presenter : BasePresenter {

        fun printHello()
    }
}