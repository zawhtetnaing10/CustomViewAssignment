package com.zg.ccp.customviewassignment.mvp.presenters

import com.zg.ccp.customviewassignment.mvp.presenters.MainPresenter
import com.zg.ccp.customviewassignment.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {
    override fun onTapPerson() {
        // Show Bottom Sheet
        mView?.showProfileBottomSheet()
    }

    override fun onTapPersonInTask() {
        // Show Bottom Sheet
        mView?.showProfileBottomSheet()
    }

    override fun onTapPlus() {
        mView?.navigateToCreateNewTaskScreen()
    }
}