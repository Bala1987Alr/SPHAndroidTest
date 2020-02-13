package com.bala.sphandroidtest

import com.bala.sphandroidtest.contract.MobileDataUsageContract
import com.bala.sphandroidtest.contract.MobileDataUsageContractor
import com.bala.sphandroidtest.models.Records
import com.bala.sphandroidtest.models.Resources
import com.bala.sphandroidtest.models.Result
import com.bala.sphandroidtest.presenter.DataUsagePresenter
import com.bala.sphandroidtest.presenter.MobileDataUsagePresenter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TestUsageView  {

    @Mock
    lateinit var view : MobileDataUsageContract.View

    @Mock
    lateinit var resources: Resources


    lateinit var dataUsagePresenter : DataUsagePresenter



    @Before
    fun initMocks()
    {
        MockitoAnnotations.initMocks(this)
        dataUsagePresenter = DataUsagePresenter()
        dataUsagePresenter.attachView(view)


    }

    @Test
    fun presenterTest()
    {
        dataUsagePresenter.fetchMobileDataUsageFromServer()
        view.responseReceived(resources)
        Mockito.verify(view).responseReceived(resources)

    }


}