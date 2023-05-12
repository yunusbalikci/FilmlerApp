package com.yunusbalikci.filmlerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.yunusbalikci.filmlerapp.databinding.ActivityDetayBinding
import com.yunusbalikci.filmlerapp.databinding.ActivityFilmlerBinding

class DetayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val film = intent.getSerializableExtra("filmNesne") as Filmler

        binding.textViewFilmAd1.text = film.film_adi
        binding.textViewFilmYL.text = (film.film_yil).toString()
        binding.textViewYonetmen.text = film.yonetmen.yonetmen_ad

            binding.imageViewResim.setImageResource(resources.getIdentifier(film.film_resim
            ,"drawable",packageName))
    }
}