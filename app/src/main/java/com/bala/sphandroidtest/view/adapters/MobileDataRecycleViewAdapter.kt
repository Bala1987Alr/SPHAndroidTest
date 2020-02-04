package com.bala.sph.view.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bala.sphandroidtest.R

import kotlinx.android.synthetic.main.mobile_data_usage_cell.view.*


class MobileDataRecycleViewAdapter(val context : Context,val records: List<String>, val data : List<Double>,val isDecresed : List<Boolean>) : RecyclerView.Adapter<DataViewHolder>() {

    private val listener: ItemImageClickListener? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DataViewHolder {

        return DataViewHolder(LayoutInflater.from(context).inflate(R.layout.mobile_data_usage_cell,p0,false))
    }

    override fun getItemCount(): Int {

        return records.size
    }

    override fun onBindViewHolder(dataViewHolder: DataViewHolder, position: Int) {

        dataViewHolder.view_holder_item1.text = records.get(position)
        dataViewHolder.view_holder_item2.text = data.get(position).toString()


        if(isDecresed.get(position))
        {
            dataViewHolder.view_holder_item3.visibility = View.VISIBLE

        }


    }

}

class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), OnClickListener
{
    var view_holder_item3: ImageView
    val view_holder_item1: TextView
    val view_holder_item2: TextView

        init {
             view_holder_item1 = itemView.textView5
             view_holder_item2 = itemView.textView6
             view_holder_item3 = itemView.findViewById(R.id.imageView) as ImageView
             view_holder_item3.setOnClickListener(this)
        }



    override fun onClick(v: View?)
    {
        Toast.makeText(v?.getContext(), "Value Decreased in some of the quarter", Toast.LENGTH_SHORT).show();
    }


}