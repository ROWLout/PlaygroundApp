package de.rowl.playgroundapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface SearchService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String):
            Call<SearchResponse>
}