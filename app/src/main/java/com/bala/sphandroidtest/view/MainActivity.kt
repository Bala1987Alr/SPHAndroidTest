package com.bala.sphandroidtest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bala.sph.view.adapter.MobileDataRecycleViewAdapter
import com.bala.sphandroidtest.R
import com.bala.sphandroidtest.contract.MobileDataUsageContractor
import com.bala.sphandroidtest.models.Resources
import com.bala.sphandroidtest.presenter.MobileDataUsagePresenter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(),MobileDataUsageContractor.DataUsageView {

    private val TAG = "MainActivity"
    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter : MobileDataUsagePresenter
    private lateinit var adapter : MobileDataRecycleViewAdapter


    override fun onResponseSuccess(data: Resources) {

        var previous_key : String
        var accumulation: Double  = 0.0
        var current_value: Double  = 0.0
        var isDecresed : Boolean
        var finalList =  TreeMap<String,Double>()
        var isDecresedList =  TreeMap<String,Boolean>()

        for(x in 0 until data.result.records.size)
        {
            if(finalList.containsKey(data.result.records.get(x).quarter.substring(0,4)))
            {
                previous_key = data.result.records.get(x).quarter.substring(0,4)
                current_value = data.result.records.get(x).volume_of_mobile_data.toDouble()
                accumulation = finalList.get(previous_key)!!.plus(current_value)
                finalList.put(previous_key,accumulation)

                if(data.result.records.get(x).volume_of_mobile_data.toDouble() < data.result.records.get(x-1).volume_of_mobile_data.toDouble())
                {
                    Log.d(TAG,isDecresedList.toString())
                    isDecresedList.put(previous_key,true)
                }
            }
            else
            {
                finalList.put(data.result.records.get(x).quarter.substring(0,4),data.result.records.get(x).volume_of_mobile_data.toDouble())
                isDecresedList.put(data.result.records.get(x).quarter.substring(0,4),false)
            }

        }


        adapter = MobileDataRecycleViewAdapter(this,records = ArrayList(finalList.keys),data = ArrayList(finalList.values),isDecresed =  ArrayList(isDecresedList.values))

        mobile_data_cycle.layoutManager = LinearLayoutManager(this)
        mobile_data_cycle.adapter = adapter
    }

    override fun onResponseFailure(throwable: Throwable) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        presenter = MobileDataUsagePresenter(this)
        presenter.getMobileDataUsage()

    }
}
