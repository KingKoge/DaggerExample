package me.developer.suttichai.dagger.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseView {

    public override fun onCreate(savedInstanceState: Bundle?) {
        inject()

        super.onCreate(savedInstanceState)
        setContentView(getLayoutView())
        bindView()
        setupView()

        if (savedInstanceState == null) {
            val intent = intent
            if (intent != null && intent.extras != null) {
                restoreArgument(intent.extras)
            }
            initialize()
        }
    }

    protected abstract fun inject()

    protected abstract fun getLayoutView(): Int

    protected abstract fun bindView()

    protected abstract fun setupView()

    protected abstract fun restoreArgument(extras: Bundle)

    protected abstract fun initialize()

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveInstanceState(outState)
    }

    protected abstract fun saveInstanceState(outState: Bundle)

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        restoreInstanceState(savedInstanceState)
        restoreView()
    }

    protected abstract fun restoreInstanceState(savedInstanceState: Bundle)

    protected abstract fun restoreView()

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showDialog(message: String) {

    }
}