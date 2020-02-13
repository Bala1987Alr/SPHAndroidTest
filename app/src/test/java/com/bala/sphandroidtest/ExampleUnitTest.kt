package com.bala.sphandroidtest

import com.bala.sphandroidtest.contract.MobileDataUsageContractor
import com.bala.sphandroidtest.presenter.MobileDataUsagePresenter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

    @Mock
    lateinit var dataUsageView: MobileDataUsageContractor.DataUsageView

    @Mock
    lateinit var resources: com.bala.sphandroidtest.models.Resources

    @Mock
    lateinit var throwable: Throwable

    lateinit var mobileDataUsagePresenter: MobileDataUsagePresenter
    
    @Before
    fun setUp()
    {
        MockitoAnnotations.initMocks(this)
        mobileDataUsagePresenter = MobileDataUsagePresenter(dataUsageView)

    }

    @Test
    fun testWithResource()
    {
        mobileDataUsagePresenter.getMobileDataUsage()
        dataUsageView.onResponseSuccess(resources)
        Mockito.verify(dataUsageView).onResponseSuccess(resources)
        Mockito.verify(dataUsageView,Mockito.times(1)).onResponseSuccess(resources)

    }

    @Test
    fun testWithError()
    {
        mobileDataUsagePresenter.getMobileDataUsage()
        dataUsageView.onResponseFailure(throwable)
        Mockito.verify(dataUsageView).onResponseFailure(throwable)

    }

}
