package com.selin.yemeksepeti.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.selin.yemeksepeti.R
import com.selin.yemeksepeti.YemeklerAdapter
import com.selin.yemeksepeti.databinding.FragmentAnasayfaBinding
import com.selin.yemeksepeti.entity.Yemekler
import com.selin.yemeksepeti.viewmodel.AnasayfaFragmentViewModel

class AnasayfaFragment : Fragment() {

    private lateinit var tasarim : FragmentAnasayfaBinding
    private lateinit var adapter: YemeklerAdapter
    private lateinit var yemeklerListesi: ArrayList<Yemekler>
    private lateinit var viewModel: AnasayfaFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)
        tasarim.anasayfaFragment = this

        viewModel.yemeklerListesi.observe(viewLifecycleOwner, { yemeklerListesi ->
            adapter = YemeklerAdapter(requireContext(), yemeklerListesi,viewModel)
            tasarim.yemeklerAdapter = adapter
        })

        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        //Fragment içinde viewModel tanımlaması
        val tempViewModel: AnasayfaFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }
}