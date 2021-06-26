package com.selin.yemeksepeti.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.selin.yemeksepeti.MainActivity
import com.selin.yemeksepeti.R
import com.selin.yemeksepeti.databinding.FragmentYemekDetayBinding
import com.selin.yemeksepeti.viewmodel.YemekDetayFragmentViewModel
import com.squareup.picasso.Picasso

class YemekDetayFragment : Fragment() {

    private lateinit var viewModel: YemekDetayFragmentViewModel
    private lateinit var tasarim : FragmentYemekDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yemek_detay, container, false)



        val bundle : YemekDetayFragmentArgs by navArgs()
        var gelenYemek = bundle.nesneYemek

        var yemek_adi = bundle.nesneYemek.yemek_resim_adi
        var url = "http://kasimadalan.pe.hu/yemekler/resimler/" + yemek_adi
        var id=tasarim.imageViewDetay
        Picasso.get().load(url).into(id)

        tasarim.yemekNesnesi=gelenYemek

        tasarim.buttonSepeteEkle.setOnClickListener {
            Snackbar.make(it,"${gelenYemek.yemek_adi} sepete eklendi!",Snackbar.LENGTH_SHORT).show()
            ((activity as MainActivity)).getArray().add(bundle.nesneYemek)
        }



        return tasarim.root
    }

}