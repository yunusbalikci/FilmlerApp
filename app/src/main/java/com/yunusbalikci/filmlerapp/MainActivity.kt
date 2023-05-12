package com.yunusbalikci.filmlerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.yunusbalikci.filmlerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var kategoriListe:ArrayList<Kategoriler>
    private lateinit var adapter:KategoriAdapter

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarKategori.title = "Kategoriler"
        setSupportActionBar(binding.toolbarKategori)

        binding.kategoriRv.setHasFixedSize(true)
        binding.kategoriRv.layoutManager = LinearLayoutManager(this)

        kategoriListe = ArrayList()
        val k1 = Kategoriler(1,"Komedi")
        val k2 = Kategoriler(2,"Aksiyon")
        val k3 = Kategoriler(3,"Bilim Kurgu")

        kategoriListe.add(k1)
        kategoriListe.add(k2)
        kategoriListe.add(k3)

        adapter = KategoriAdapter(this,kategoriListe)
        binding.kategoriRv.adapter = adapter
    }
}