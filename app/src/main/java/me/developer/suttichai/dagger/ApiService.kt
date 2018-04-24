package me.developer.suttichai.dagger

interface ApiService {
    fun loadData()
}


class ApiServiceImpl : ApiService {

    override fun loadData() {
        logD("Load Data")
    }
}