package com.yunusbalikci.filmlerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.yunusbalikci.filmlerapp.databinding.ActivityFilmlerBinding
import com.yunusbalikci.filmlerapp.databinding.ActivityMainBinding

class FilmlerActivity : AppCompatActivity() {
    private lateinit var filmListe:ArrayList<Filmler>
    private lateinit var adapter:FilmlerAdapter
    private lateinit var binding:ActivityFilmlerBinding
    private lateinit var vt:VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmlerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val kategori = intent.getSerializableExtra("kategoriNesne") as Kategoriler

        binding.toolbarFilmler.title = "Filmler : ${kategori.kategori_ad}"
        setSupportActionBar(binding.toolbarFilmler)

        binding.filmlerRv.setHasFixedSize(true)
        binding.filmlerRv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        vt = VeritabaniYardimcisi(this)

        filmListe = FilmlerDao().tumFilmlerByKategoriId(vt,kategori.kategori_id)
        adapter = FilmlerAdapter(this,filmListe)
        binding.filmlerRv.adapter = adapter


    }
}