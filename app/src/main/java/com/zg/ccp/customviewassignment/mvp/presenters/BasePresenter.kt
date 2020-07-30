package com.zg.ccp.customviewassignment.mvp.presenters

import com.zg.ccp.customviewassignment.mvp.views.BaseView

interface BasePresenter<T : BaseView> {
    fun setUpPresenter(view : T)
}