package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.User
import com.example.myapplication.domain.data.network.Repo

class MainViewModel : ViewModel() {

    private val repo = Repo()



    fun fetchUserData(): LiveData<MutableList<User>>{
        val mutableData = MutableLiveData<MutableList<User>>()
        repo.getUserData().observeForever{
            userList ->
            mutableData.value = userList
        }

        return mutableData

    }

}