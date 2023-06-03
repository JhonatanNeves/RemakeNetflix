package com.example.remakenetflix

import android.graphics.drawable.LayerDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.remakenetflix.model.Movie

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val txtTitle: TextView = findViewById(R.id.movie_txt_title)
        val txtDesc: TextView = findViewById(R.id.movie_txt_desc)
        val txtCast: TextView = findViewById(R.id.movie_txt_cast)
        val rv : RecyclerView = findViewById(R.id.movie_rv_similar)

        txtTitle.text = "Velozes & Furiosos 10 (2023)"
        txtDesc.text = "Over many missions and against impossible odds, Dom Toretto and his family have outsmarted, out-nerved and outdriven every foe in their path. Now, they confront the most lethal opponent they've ever faced: A terrifying threat emerging from the shadows of the past who's fueled by blood revenge, and who is determined to shatter this family and destroy everything—and everyone—that Dom loves, forever."
        txtCast.text = getString(R.string.cast, "Vin Diesel (Dominic 'Dom' Toretto), Michelle Rodrigues (Letty Ortiz), Tyrese Gibson (Roman Pearce), Ludacris (Tej Parker), John Cena (Jakob Toretto), Nathalie Emmanuel (Ramsey), Jordana Brewster(Mia Toretto), Sung Kang (Han Lue), Jason Momoa (Dante Reyes)")

        val movies = mutableListOf<Movie>()

        rv.layoutManager = GridLayoutManager(this, 3)
        rv.adapter = MovieAdapter(movies, R.layout.movie_item_similar)

        val toolbar: Toolbar = findViewById(R.id.movie_toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null

        val layerDrawable: LayerDrawable = ContextCompat.getDrawable(this, R.drawable.shadows) as LayerDrawable
        val movieCover = ContextCompat.getDrawable(this, R.drawable.img_header)
        layerDrawable.setDrawableByLayerId(R.id.cover_drawable, movieCover)
        val coverImg: ImageView = findViewById(R.id.movie_img_header)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}