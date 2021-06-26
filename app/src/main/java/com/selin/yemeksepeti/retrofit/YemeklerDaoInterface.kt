package com.selin.yemeksepeti.retrofit

import com.selin.yemeksepeti.entity.CRUDCevap
import com.selin.yemeksepeti.entity.YemekCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemeklerDaoInterface {
    @GET("yemekler/tum_yemekler.php")
    fun tumYemekler(): Call<YemekCevap>


    @GET("yemekler/tum_sepet_yemekler.php")
    fun tumSepetYemekler(): Call<YemekCevap>
    @POST("yemekler/insert_sepet_yemek.php")
    @FormUrlEncoded
    fun sepeteEkle (@Field("yemek_id") yemek_id:Int,
                    @Field("yemek_adi") yemek_adi:String,
                    @Field("yemek_resim_adi") yemek_resim_adi:String,
                    @Field("yemek_fiyat") yemek_fiyat:Int) : Call<YemekCevap>

    @POST("yemekler/delete_sepet_yemek.php")
    @FormUrlEncoded
    fun yemekSil(@Field("yemek_id") yemek_id:Int): Call<CRUDCevap>


    @POST("yemekler/tum_yemekler_arama.php")
    @FormUrlEncoded
    fun yemekAra(@Field("yemek_adi") yemek_adi:String): Call<YemekCevap>

}