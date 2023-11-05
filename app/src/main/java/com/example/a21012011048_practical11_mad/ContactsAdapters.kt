package com.example.a21012011048_practical11_mad

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.floatingactionbutton.FloatingActionButton

class contactsAdapter(private var context: Context, var items:ArrayList<Contact>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(context).inflate(R.layout.carp_post, parent, false)

        val id: TextView = view.findViewById(R.id.text_id)
        val name: TextView =view.findViewById(R.id.text_name)
        val num: TextView =view.findViewById(R.id.text_num)
        val address: TextView = view.findViewById(R.id.text_address)



        // contact first name
        // val txt_ltr:TextView=view.findViewById(R.id.text_ltr)
        val viewHolder = ViewHolder(view)

        // Set your TextViews' text here
        viewHolder.id.text = items[position].id
        viewHolder.latitude.text = items[position].lat
        viewHolder.longitude.text = items[position].long
        viewHolder.name.text = items[position].name
        viewHolder.num.text = items[position].phone
        viewHolder.address.text = items[position].address


        var strname = items[position].name
        var strlat = items[position].lat
        var strlong = items[position].long


        // Set an OnClickListener for the floating button
        viewHolder.floatingButton.setOnClickListener {
            // Handle the click event of the floating button




            // Create an Intent to start the LocationDetailActivity




        }

        return view
    }

    private class ViewHolder(view: View) {
        val id: TextView = view.findViewById(R.id.text_id)
        val latitude : TextView = view.findViewById(R.id.lat)
        val longitude : TextView = view.findViewById(R.id.longi)
        val name: TextView = view.findViewById(R.id.text_name)
        val num: TextView = view.findViewById(R.id.text_num)
        val address: TextView = view.findViewById(R.id.text_address)
        val floatingButton: FloatingActionButton = view.findViewById(R.id.floatingButton)

    }
}