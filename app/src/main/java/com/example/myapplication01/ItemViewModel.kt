package com.example.myapplication01

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ItemViewModel(context: Context) : ViewModel() {

    val sharedPreferences = context.getSharedPreferences("newset",Context.MODE_PRIVATE)

    private val selectedItems = MutableStateFlow<Set<String>>(emptySet())
    val _selectedItems :StateFlow<Set<String>> = selectedItems



    init {
        val saveditems = sharedPreferences.getStringSet("newset",null)
        saveditems.let {
            if (it != null) {
                selectedItems.value =it
            }
        }
    }


     fun toggleItems(item:String){

        val currentitem = selectedItems.value.toMutableSet()

        if(currentitem.contains(item)){
            currentitem.remove(item)
        }else
        {
            currentitem.add(item)
        }

        selectedItems.value = currentitem

        savedItems(currentitem)
    }


    fun savedItems(item: MutableSet<String>){
        sharedPreferences.edit().putStringSet("newset",item).apply()
    }
}