package me.developer.suttichai.dagger.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import me.developer.suttichai.dagger.R
import me.developer.suttichai.dagger.api.Request
import me.developer.suttichai.dagger.api.Resource
import me.developer.suttichai.dagger.api.Status
import me.developer.suttichai.dagger.api.menu.request.MenuBody
import me.developer.suttichai.dagger.api.menu.response.MenuResult
import me.developer.suttichai.dagger.databinding.ActivityMainBinding
import me.developer.suttichai.dagger.main.adapter.MenuGroupAdapter

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var adapter: MenuGroupAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupView()
        initViewModel()
    }

    private fun setupView() {
        val layout = LinearLayoutManager(this)
        binding.rvMenuGroupList.layoutManager = layout
        binding.srMenuGroupList.setOnRefreshListener {
            val request = Request(MenuBody("1", "getMenuByBranch3", "2443", "1", "1"), false)
            viewModel.getMenu(request)
        }

        binding.srMenuGroupList.isRefreshing = false
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.menuResult.observe(this, Observer { resources -> onMenuResult(resources) })
        val request: Request<MenuBody> = Request(MenuBody("1", "getMenuByBranch3", "2443", "1", "1"), false)
        viewModel.getMenu(request)
    }

    private fun onMenuResult(resource: Resource<MenuResult>?) {
        val status = resource?.status

        when (status) {
            Status.SUCCESS -> {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                adapter = MenuGroupAdapter(resource.data?.menuGroups) { onStartMenuPage() }
                binding.rvMenuGroupList.adapter = adapter
            }
            Status.ERROR -> {

            }
            Status.LOADING -> {
                binding.srMenuGroupList.isRefreshing = false
            }
        }
    }

    private fun onStartMenuPage() {

    }
}