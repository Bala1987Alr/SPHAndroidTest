package com.bala.sphandroidtest.contract

import com.bala.sphandroidtest.models.Resources


interface MobileDataUsageContractor {

    interface DataUsageView
    {
        fun onResponseSuccess(data: Resources)
        fun onResponseFailure(throwable : Throwable)

    }

    interface DataUsagePresenter
    {
        fun getMobileDataUsage()
    }

    interface DataUsageModel
    {
        interface OnFinishedListener
        {
            fun onFinished(resources: Resources)
            fun onFailure(throwable : Throwable)
        }
        fun getMobileDataUsage(onFinishedListener: OnFinishedListener)
    }
}