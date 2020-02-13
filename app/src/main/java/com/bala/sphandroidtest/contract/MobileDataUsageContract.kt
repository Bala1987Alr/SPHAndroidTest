package com.bala.sphandroidtest.contract

import com.bala.sphandroidtest.models.Resources

interface MobileDataUsageContract : BaseContract {

    interface View : BaseContract.View
    {
        fun responseReceived(resources: Resources)
        fun responseFailed(throwable: Throwable)
    }

    interface DataUsagePresenter : BaseContract.BasePresenter<View>
    {
        fun fetchMobileDataUsageFromServer()
    }
}