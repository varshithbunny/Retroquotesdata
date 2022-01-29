package com.bunny.basic_retro

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_view_design.view.*


class MyAdapter(var context:Context,val userData: Quotelist):
    RecyclerView.Adapter<MyAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

       val quotes_id=itemView.ids
       val quotes_authors=itemView.authors
       val quotes_dateadd=itemView.Date_add
       val quotes_datemod=itemView.Date_mod
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val my_res=userData.results[position]
        with(holder) {
            quotes_id.setText("Id:"+my_res._id)
        }

        holder.quotes_authors.setText("Author:"+my_res.author)

        holder.quotes_dateadd.setText("Date added:"+my_res.dateAdded)
        holder.quotes_datemod.setText("Date Modified:"+my_res.dateModified)




    }

    override fun getItemCount(): Int {
        return userData.results.size
    }
}
