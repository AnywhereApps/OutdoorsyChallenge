package com.anywhereapps.outdoorsy.test.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anywhereapps.outdoorsy.test.R
import com.anywhereapps.outdoorsy.test.data.model.Data
import com.anywhereapps.outdoorsy.test.data.model.Result
import com.anywhereapps.outdoorsy.test.ui.main.adapter.ResultAdapter.ResultViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class ResultAdapter(private var result: Result?) : RecyclerView.Adapter<ResultViewHolder>() {

    var list : ArrayList<Data> = ArrayList()
    class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(name: String , image : String) {
            itemView.apply {
                businessName.text = name
                Glide.with(imageViewAvatar.context)
                    .load(image)
                    .override(100, 100)
                    .into(imageViewAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder =
        ResultViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val item = list[position]

        var name  = item?.attributes?.name
        var imageId  = item?.relationships?.primary_image?.data?.id
        holder.bind(name, getImageUrl(imageId))
    }

    fun addData(response: Result) {
        response.apply {
            result = this
            list.clear()
            list.addAll(response.data)
            notifyDataSetChanged()
        }

    }

    fun getImageUrl(sid : String) : String
    {
//        val index = result?.included?.indexOfFirst{
//            it.id == sid
//        }

        val item = result?.included?.find { it.id == sid }
        return item?.attributes?.url  ?: ""
      //  return index?.let { result?.included?.get(it)?.attributes?.url } ?: ""
    }

}