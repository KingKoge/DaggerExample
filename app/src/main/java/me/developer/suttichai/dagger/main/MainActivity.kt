package me.developer.suttichai.dagger.main

import android.os.Bundle
import dagger.android.AndroidInjection
import me.developer.suttichai.dagger.R
import me.developer.suttichai.dagger.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {
    @Inject
    lateinit var presenter: MainContract.Presenter


    override fun inject() {
        AndroidInjection.inject(this)
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_main
    }

    override fun bindView() {

    }

    override fun setupView() {

    }

    override fun restoreArgument(extras: Bundle) {

    }

    override fun initialize() {
        presenter.printHello()
    }

    override fun saveInstanceState(outState: Bundle) {

    }

    override fun restoreInstanceState(savedInstanceState: Bundle) {

    }

    override fun restoreView() {

    }

    override fun onStart() {
        super.onStart()

        presenter.start()
    }

    override fun onStop() {
        super.onStop()

        presenter.stop()
    }
}