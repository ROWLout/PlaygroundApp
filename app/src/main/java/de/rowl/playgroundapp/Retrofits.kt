package de.rowl.playgroundapp

import retrofit2.Retrofit


class Retrofits {

    private val service = create()
    fun create(): SearchService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.autoscout24.de/")
            .build()

        return retrofit.create(SearchService::class.java)
    }
}