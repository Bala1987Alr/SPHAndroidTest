package com.bala.sphandroidtest.presenter

import android.util.Log
import com.bala.sphandroidtest.contract.MobileDataUsageContract
import com.bala.sphandroidtest.models.Resources
import com.bala.sphandroidtest.models.Result
import com.bala.sphandroidtest.networking.APIClient
import com.bala.sphandroidtest.networking.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.Exception

open class DataUsagePresenter : MobileDataUsageContract.DataUsagePresenter {

    var view: MobileDataUsageContract.View? = null
    private lateinit var retrofit: Retrofit
    private lateinit var apiClient: APIClient
    private lateinit var apiService: APIService


    override fun fetchMobileDataUsageFromServer()
    {
            apiClient = APIClient()
            retrofit = apiClient.getClient()
            apiService = retrofit.create(APIService::class.java)

            val call = apiService.getData(apiClient.APIKEY)
            call.enqueue(object : Callback<Resources>
            {
                override fun onFailure(call: Call<Resources>, t: Throwable) {

                   view?.responseFailed(t)

                }

                override fun onResponse(call: Call<Resources>, response: Response<Resources>) {

                    view?.responseReceived(response.body()!!)
                    Log.d("Response",response.body().toString())

                }

            })
    }

    override fun attachView(view: MobileDataUsageContract.View) {
        this.view = view
    }

    override fun detachView() {

        view = null
    }


}