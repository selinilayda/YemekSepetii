package com.selin.yemeksepeti

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.selin.yemeksepeti.databinding.CardTasarimBinding
import com.selin.yemeksepeti.entity.Yemekler
import com.selin.yemeksepeti.fragment.AnasayfaFragmentDirections
import com.selin.yemeksepeti.viewmodel.AnasayfaFragmentViewModel
import com.squareup.picasso.Picasso

class YemeklerAdapter(var mContext: Context, var yemeklerListesi:List<Yemekler>,  var viewModel: AnasayfaFragmentViewModel)
    :RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(cardTasarimBinding: CardTasarimBinding) :
        RecyclerView.ViewHolder(cardTasarimBinding.root) {
        val cardTasarim: CardTasarimBinding

        init {
            this.cardTasarim = cardTasarimBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = yemeklerListesi.get(position)
        val t = holder.cardTasarim

        t.yemekNesnesi = yemek
        //holder.cardTasarim.yemekNesnesi=yemek

        var url = "http://kasimadalan.pe.hu/yemekler/resimler/" + yemek.yemek_resim_adi
        var id=holder.cardTasarim.imageViewCardResim
        Picasso.get().load(url).into(id)

        holder.cardTasarim.yemekCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayaGecis(yemek)
            Navigation.findNavController(it).navigate(gecis)
        }
       

    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }


}