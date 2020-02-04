package com.bala.sphandroidtest.presenter

import com.bala.sphandroidtest.contract.MobileDataUsageContractor
import com.bala.sphandroidtest.models.MobileFragmentDataUsageModel
import com.bala.sphandroidtest.models.Resources


open class MobileDataUsagePresenter(_view: MobileDataUsageContractor.DataUsageView): MobileDataUsageContractor.DataUsagePresenter,MobileDataUsageContractor.DataUsageModel.OnFinishedListener {

    var dataUsageView : MobileDataUsageContractor.DataUsageView = _view
    var dataUsageModel = MobileFragmentDataUsageModel()

    override fun onFinished(resources: Resources)
    {
        dataUsageView.onResponseSuccess(resources)
    }

    override fun onFailure(throwable: Throwable)
    {
        dataUsageView.onResponseFailure(throwable)

    }

    override fun getMobileDataUsage() {

        dataUsageModel.getMobileDataUsage(this)

    }


}