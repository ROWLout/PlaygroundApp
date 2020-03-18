package de.rowl.playgroundapp

import retrofit2.Call
import retrofit2.http.*


interface SearchService {
    @Headers("Authorization: Basic bW9iaWxlLWFwcC1hbmRyb2lkOjJkMjMwNmQ0NDZjZTE3OTJiNDExZTM5NWQwMDAzOWY5")
    @GET("https://classified-search.a.autoscout24.com/classified-search/totalcount")

    fun getTotalCount (@Query("atype") serviceType: Char): Call<TotalCountResponse>
}
