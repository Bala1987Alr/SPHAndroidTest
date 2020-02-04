package com.bala.sphandroidtest

import com.bala.sphandroidtest.contract.MobileDataUsageContractor
import com.bala.sphandroidtest.models.Resources

class TestUsageView : MobileDataUsageContractor.DataUsageView {

    var resources: Resources? = null

    override fun onResponseSuccess(data: Resources) {

        this.resources = resources
    }

    override fun onResponseFailure(throwable: Throwable) {

    }


}