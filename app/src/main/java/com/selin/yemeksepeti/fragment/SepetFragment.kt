package com.selin.yemeksepeti.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.selin.yemeksepeti.MainActivity
import com.selin.yemeksepeti.R
import com.selin.yemeksepeti.SepetAdapter
import com.selin.yemeksepeti.databinding.FragmentSepetBinding
import com.selin.yemeksepeti.entity.Yemekler
import com.selin.yemeksepeti.viewmodel.SepetFragmentViewModel
import kotlinx.android.synthetic.main.sepet_card_tasarim.*

class SepetFragment : Fragment() {

    private lateinit var viewModel: SepetFragmentViewModel
    private lateinit var tasarim : FragmentSepetBinding
    private lateinit var adapter: SepetAdapter
    private lateinit var sepetListesi: ArrayList<Yemekler>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet, container, false)

        tasarim.sepetFragment = this

        val sepet_array = ((activity as MainActivity)).getArray()

        adapter = SepetAdapter(requireContext(), sepet_array,viewModel)
        tasarim.sepetAdapter = adapter


        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        //Fragment içinde viewModel tanımlaması
        val tempViewModel: SepetFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }
}