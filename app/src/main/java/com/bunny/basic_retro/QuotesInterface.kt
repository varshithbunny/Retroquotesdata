package com.bunny.basic_retro

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET

interface QuotesInterface {
    //we need to endpoint of url in get value down below
    @GET("/quotes")
   fun getData():Call<Quotelist>
}