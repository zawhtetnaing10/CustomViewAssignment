package com.zg.ccp.customviewassignment.mvp.presenters

import com.zg.ccp.customviewassignment.mvp.views.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T> {
    protected var mView : T? = null

    override fun setUpPresenter(view : T){
        mView = view
    }
}