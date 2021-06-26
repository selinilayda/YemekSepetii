package com.selin.yemeksepeti

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.selin.yemeksepeti.databinding.SepetCardTasarimBinding
import com.selin.yemeksepeti.entity.Yemekler
import com.selin.yemeksepeti.fragment.YemekDetayFragmentDirections
import com.selin.yemeksepeti.viewmodel.SepetFragmentViewModel
import com.squareup.picasso.Picasso

class SepetAdapter(var mContext: Context, var sepetListesi:List<Yemekler>, var viewModel: SepetFragmentViewModel)
    :RecyclerView.Adapter<SepetAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(cardTasarimBinding: SepetCardTasarimBinding) :
            RecyclerView.ViewHolder(cardTasarimBinding.root) {
        val cardTasarim: SepetCardTasarimBinding

        init {
            this.cardTasarim = cardTasarimBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = SepetCardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val sepet = sepetListesi.get(position)
        val t = holder.cardTasarim

        t.yemekNesnesi = sepet


        var url = "http://kasimadalan.pe.hu/yemekler/resimler/" + sepet.yemek_resim_adi
        var id=holder.cardTasarim.imageViewSepetResim
        Picasso.get().load(url).into(id)

        holder.cardTasarim.sepetCard.setOnClickListener {
            val gecis = YemekDetayFragmentDirections.sepeteGecis(sepet)
            Navigation.findNavController(it).navigate(gecis)
        }


    }

    override fun getItemCount(): Int {
        return sepetListesi.size
    }


}