package com.dsm.miniplayerg2.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsm.miniplayerg2.data.model.Artist
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import kotlin.toString

class HomeViewModel:  ViewModel(){
    private var db: FirebaseFirestore= Firebase.firestore
    private val _artist= MutableStateFlow<List<Artist>>(emptyList())
    val artist : StateFlow<List<Artist>> = _artist

    init {
        //repeat(5){loadData()} // con fines de realizar data semilla o data simulada
        getArtists()
    }
    //ejemplo para carga de data semilla
    private fun loadData(){
        val random=(1..100).random()
        val artist= Artist(
            name= "Artista $random",
            description="Excelente Artista $random",
            image="https://www.banderasnews.com/0705/images/shakiramex.jpg"
        )
        db.collection("artists").add(artist)
        Log.i("loadData", artist.toString())
    }

    private fun getArtists(){
        viewModelScope.launch {
            val result: List<Artist> = withContext(Dispatchers.IO){
                getAllArtists()
            }
            _artist.value = result
        }
    }

    private suspend fun getAllArtists(): List<Artist>{
        return try{
            db.collection("artists").get().await().documents.mapNotNull {
                    snapshot-> snapshot.toObject(Artist::class.java)
            }

        }catch (e: Exception){
            Log.i("getAllArtists()", e.toString())
            emptyList()
        }

    }

}