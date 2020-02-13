package com.bala.sphandroidtest.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bala.sphandroidtest.R
import com.bala.sphandroidtest.contract.MobileDataUsageContract
import com.bala.sphandroidtest.models.Resources
import com.bala.sphandroidtest.presenter.DataUsagePresenter
import kotlinx.android.synthetic.main.activity_data_usage.*


class DataUsageActivity : AppCompatActivity(), MobileDataUsageContract.View{

    lateinit var dataUsagePresenter: DataUsagePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_usage)

        dataUsagePresenter = DataUsagePresenter()
        dataUsagePresenter.attachView(this)
        dataUsagePresenter.fetchMobileDataUsageFromServer()
    }

    override fun responseReceived(resources: Resources)
    {

        response.text = resources.toString()
        Log.d("Response", resources.success)
        print(resources)
    }

    override fun responseFailed(throwable: Throwable)
    {
        print("Failed")
    }

    override fun onDestroy() {
        super.onDestroy()
        dataUsagePresenter.detachView()
    }


}
