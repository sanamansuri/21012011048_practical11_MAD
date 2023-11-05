package com.example.a21012011048_practical11_mad

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import org.json.JSONArray
import java.net.URL
class MainActivity : AppCompatActivity() {
    val listitems = Contact.contactArray as ArrayList<Contact>
    val adapter = contactsAdapter(this, listitems)
    lateinit var list: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()




        list = findViewById(R.id.listView)
        val arr = listitems
        list.setOnItemClickListener { parent, view, position, id ->
            val name: String = arr[position].name.toString()
            val num: String = arr[position].phone.toString()
            val addr: String = arr[position].address
            val id:String = arr[position].id.toString()
            val lat:String= arr[position].lat.toString()
            val log:String= arr[position].long.toString()



        }
        contacts().execute()


    }

    inner class contacts() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()

        }

        override fun doInBackground(vararg params: String?): String? {
            var response: String?
            try {
                response =
                    URL("https://api.json-generator.com/templates/WNvhsrmIpuhF/data?access_token=gvc3xf9htcw98fxwr5xvu80lqamyx4fxotdjtpm8").readText(
                        Charsets.UTF_8
                    )

            } catch (e: Exception) {
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {

                /* Extracting JSON returns from the API */
                val jsonarr = JSONArray(result)

                for (i in 0..12) {

                    val jsonObj_0 = jsonarr.getJSONObject(i)
                    val id_jason = "Person ID : " + jsonObj_0.getString("id")
                    val name_json = "Name : " + jsonObj_0.getString("name")
                    val num_json = "Phone No : " + jsonObj_0.getString("phone")
                    val add_json = "Address : " + jsonObj_0.getString("address")
                    val add_lat = "lat : " + jsonObj_0.getString("lat")
                    val add_long = "long : " + jsonObj_0.getString("long")
                    listitems.add(Contact(id_jason,add_lat, add_long, name_json, num_json, add_json))
                    list.adapter = adapter
                }


            } catch (e: Exception) {


            }

        }
    }

}