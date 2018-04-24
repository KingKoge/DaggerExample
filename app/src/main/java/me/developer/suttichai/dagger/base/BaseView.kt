package me.developer.suttichai.dagger.base

interface BaseView {
    fun showLoading()

    fun hideLoading()

    fun showDialog(message: String)
}