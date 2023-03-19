package com.example.bincheker.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bincheker.R
import com.example.bincheker.model.FullData

class BinRecyclerAdapter :
    RecyclerView.Adapter<BinRecyclerAdapter.BinViewHolder>() { //RecyclerView.Adapter<BinRecyclerAdapter.BinViewHolder>()
    private var scrapsList = emptyList<FullData?>()


    inner class BinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemDelete: Button = itemView.findViewById(R.id.item_delete)

        val itemCardScheme: TextView = itemView.findViewById(R.id.item_scheme)
        val itemCardBrand: TextView = itemView.findViewById(R.id.item_brand)
        val itemCardLength: TextView = itemView.findViewById(R.id.item_card_length)
        val itemCardLuhn: TextView = itemView.findViewById(R.id.item_card_luhn)
        val itemCardType: TextView = itemView.findViewById(R.id.item_type)
        val itemCardPrepaid: TextView = itemView.findViewById(R.id.item_prepaid)
        val itemCardCountry: TextView = itemView.findViewById(R.id.item_country)
        val itemCardBank: TextView = itemView.findViewById(R.id.item_bank)
        val itemCardBankUrl: TextView = itemView.findViewById(R.id.item_url)
        val itemCardBankPhone: TextView = itemView.findViewById(R.id.item_phone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return BinViewHolder(view)
    }

    override fun getItemCount(): Int {
        return scrapsList.size
    }

    override fun onBindViewHolder(holder: BinViewHolder, position: Int) {

        val currentItem = scrapsList[position]
        holder.itemView.apply {
            holder.itemCardScheme.text = currentItem?.scheme
            holder.itemCardBrand.text = currentItem?.brand
            holder.itemCardType.text = currentItem?.type
            holder.itemCardLength.text = currentItem?.number?.length.toString()
            holder.itemCardLuhn.text = currentItem?.number?.luhn.toString()
            holder.itemCardPrepaid.text = currentItem?.prepaid.toString()
            holder.itemCardCountry.text = currentItem?.country?.name
            holder.itemCardBank.text = currentItem?.bank?.name
            holder.itemCardBankUrl.text = currentItem?.bank?.url
            holder.itemCardBankPhone.text = currentItem?.bank?.phone

            holder.itemView.setOnClickListener {
                val unit = scrapsList.get(position)
                //clickListener.onClicked(unit)
                //notifyDataSetChanged()
            }

            holder.itemDelete.setOnClickListener {

                var unit = scrapsList.get(position)
                //deleteInterface.onDelete(unit)
                //notifyDataSetChanged()
            }
        }
    }

    fun setData(unit: List<FullData?>) {
        this.scrapsList = unit

        notifyDataSetChanged()
    }
}