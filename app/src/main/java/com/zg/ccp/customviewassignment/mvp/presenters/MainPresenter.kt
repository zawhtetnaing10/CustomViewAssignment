package com.zg.ccp.customviewassignment.mvp.presenters

import com.zg.ccp.customviewassignment.delegates.PeopleAndProgressViewPodActionDelegate
import com.zg.ccp.customviewassignment.delegates.TaskViewHolderActionDelegate
import com.zg.ccp.customviewassignment.delegates.TaskViewPodActionDelegate
import com.zg.ccp.customviewassignment.mvp.views.MainView

interface MainPresenter : TaskViewHolderActionDelegate, TaskViewPodActionDelegate, PeopleAndProgressViewPodActionDelegate,
    BasePresenter<MainView>