package com.selin.yemeksepeti.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.selin.yemeksepeti.entity.Yemekler

class YemekDetayFragmentViewModel : ViewModel(){

    var sepetListesi = MutableLiveData<List<Yemekler>>()
}