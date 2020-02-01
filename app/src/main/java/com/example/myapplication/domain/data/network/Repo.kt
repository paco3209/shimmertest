package com.example.myapplication.domain.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.User
import com.google.firebase.firestore.FirebaseFirestore

class Repo {

    fun getUserData(): LiveData<MutableList<User>>{
        val mutableData = MutableLiveData<MutableList<User>>()
        FirebaseFirestore.getInstance().collection("Users").get().addOnSuccessListener { result ->
            val listData: MutableList<User> = mutableListOf<User>()
            for(document in result ){
                val imageUrl: String? = document.getString("imageUrl")
                val nombre: String? = document.getString("nombre")
                val descripcion: String? = document.getString("descripcion")
                val usuario = User(imageUrl!!,nombre!!, descripcion!!)
                listData.add(usuario)
            }

            mutableData.value = listData
        }

        return mutableData
    }

}