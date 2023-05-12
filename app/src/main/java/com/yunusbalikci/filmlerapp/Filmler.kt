package com.yunusbalikci.filmlerapp

data class Filmler(var film_id:Int,var film_adi:String,var film_yil:Int,var film_resim:String,
var kategori:Kategoriler,var yonetmen:Yonetmenler):java.io.Serializable{

}
