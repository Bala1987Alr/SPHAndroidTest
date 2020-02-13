package com.bala.sphandroidtest.contract

import androidx.annotation.UiThread

interface BaseContract {

    @UiThread
    interface View

    interface BasePresenter<V : View>
    {
        fun attachView(view : V)
        fun detachView()
    }
}