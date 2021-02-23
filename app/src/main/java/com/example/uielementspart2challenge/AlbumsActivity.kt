package com.example.uielementspart2challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView

var albumSongs = ArrayList<String>()
var albumURI = String

class AlbumsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        val GridView = findViewById<GridView>(R.id.gridView) as GridView

        GridView.adapter = ImageAdapter(applicationContext)

        GridView.onItemClickListener = AdapterView.OnItemClickListener{parent, v, position, id ->
            val intent = Intent(this, AlbumDetailsActivity::class.java)
            var uri: String
            if (position == 0) {
                uri = "@drawable/franco_cover"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.Franco))
            }
            else if (position == 1) {
                uri = "@drawable/incubus_cover"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.Incubus))
            } else {
                uri = "@drawable/three_cover"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.ThreeEleven))
            }
            intent.putExtra("imageUri",  uri)
            startActivity(intent)


        }



    }




}



