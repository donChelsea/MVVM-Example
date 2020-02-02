package com.katsidzira.mvvmexample.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.katsidzira.mvvmexample.R
import com.katsidzira.mvvmexample.model.Zodiac
import com.katsidzira.mvvmexample.model.ZodiacList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.zodiac_item_view.view.*

class ZodiacAdapter(zodiacList: List<Zodiac>) : RecyclerView.Adapter<ZodiacAdapter.ZodiacViewHolder>() {
    private val zodiacs = zodiacList

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
        ZodiacViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.zodiac_item_view, p0, false))

    override fun getItemCount() = zodiacs.size

    override fun onBindViewHolder(p0: ZodiacViewHolder, p1: Int) = p0.onBind(zodiacs[p1])

    class ZodiacViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTv = view.name_textview
        private val numberTv = view.number_textview
        private val imageIv = view.image

        fun onBind(zodiac: Zodiac) {
            nameTv.text = zodiac.name
            numberTv.text = zodiac.number
            Picasso.get().load(zodiac.image).into(imageIv)
        }

    }

}
