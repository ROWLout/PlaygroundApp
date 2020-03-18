package de.rowl.playgroundapp

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class Retrofits {

    fun create(): SearchService {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.autoscout24.de/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        return retrofit.create(SearchService::class.java)
    }
}