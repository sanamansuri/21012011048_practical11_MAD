package com.example.a21012011048_practical11_mad
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    // Define your database name and version
    companion object {
        const val DATABASE_NAME = "User"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Create the table to store data about persons
        db.execSQL(
            "CREATE TABLE IF NOT EXISTS person (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "phone TEXT," +
                    "address TEXT," +
                    "latitude TEXT," +
                    "longitude TEXT" +
                    ")"
        )

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // If you need to upgrade your database, handle it here
        // You can drop the existing table and recreate it
        db.execSQL("DROP TABLE IF EXISTS person")
        onCreate(db)
    }

    fun insertPerson(person: Person) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("name", person.name)
            put("phone", person.phone)
            put("address", person.address)
            put("latitude", person.latitude)
            put("longitude", person.longitude)
        }
        db.insert("person", null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getAllPersons(): ArrayList<Person> {
        val persons = ArrayList<Person>()
        val db = this.readableDatabase
        val cursor: Cursor = db.query(
            "person", null, null, null, null, null, null
        )

        while (cursor.moveToNext()) {
            val person = Person(
                cursor.getInt(cursor.getColumnIndex("id")),
                cursor.getString(cursor.getColumnIndex("name")),
                cursor.getString(cursor.getColumnIndex("phone")),
                cursor.getString(cursor.getColumnIndex("address")),
                cursor.getString(cursor.getColumnIndex("latitude")),
                cursor.getString(cursor.getColumnIndex("longitude"))
            )
            persons.add(person)
        }
        

        cursor.close()
        db.close()
        return persons
    }
}