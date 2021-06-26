package com.selin.yemeksepeti.repo

import androidx.lifecycle.MutableLiveData
import com.selin.yemeksepeti.entity.YemekCevap
import com.selin.yemeksepeti.entity.Yemekler
import com.selin.yemeksepeti.retrofit.ApiUtils
import com.selin.yemeksepeti.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaoRepository {

    private val yemeklerListesi: MutableLiveData<List<Yemekler>>
    private val yemeklerdaoInterface: YemeklerDaoInterface

    init {
        yemeklerdaoInterface = ApiUtils.getYemeklerDaoInterface()
        yemeklerListesi = MutableLiveData()
    }

    fun yemekleriGetir(): MutableLiveData<List<Yemekler>> {
        return yemeklerListesi
    }

    fun tumYemekleriAl() {
        yemeklerdaoInterface.tumYemekler().enqueue(object : Callback<YemekCevap> {
            override fun onResponse(call: Call<YemekCevap>, response: Response<YemekCevap>) {
                val liste = response.body().yemekler
                yemeklerListesi.value = liste
            }
            override fun onFailure(call: Call<YemekCevap>, t: Throwable) {}
        })
    }

    fun yemekAra(aramaKelimesi:String) {
        yemeklerdaoInterface.yemekAra(aramaKelimesi).enqueue(object : Callback<YemekCevap> {
            override fun onResponse(call: Call<YemekCevap>, response: Response<YemekCevap>) {
                val liste = response.body().yemekler
                yemeklerListesi.value = liste
            }
            override fun onFailure(call: Call<YemekCevap>, t: Throwable) {}
        })
    }
}


