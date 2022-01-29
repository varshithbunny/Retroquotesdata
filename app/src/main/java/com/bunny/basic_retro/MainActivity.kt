package com.bunny.basic_retro

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
const val BASE_URL = "https://quotable.io/"
class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager=LinearLayoutManager(this)

        val retrofitBuilder=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(QuotesInterface::class.java)


        val retrofitData=retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<Quotelist?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<Quotelist?>, response: Response<Quotelist?>) {
                val responseBody=response.body()

                myAdapter= responseBody?.let { MyAdapter(baseContext, it) }!!
                myAdapter.notifyDataSetChanged()
                recyclerview.adapter=myAdapter





            }

            override fun onFailure(call: Call<Quotelist?>, t: Throwable) {
                d("Bunny","Failes"+t.message)
            }

        })

    }




}