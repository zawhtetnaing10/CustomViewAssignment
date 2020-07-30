package com.zg.ccp.customviewassignment.viewholders

import android.view.View
import com.zg.ccp.customviewassignment.data.vos.TaskVO
import com.zg.ccp.customviewassignment.delegates.TaskViewHolderActionDelegate
import com.zg.ccp.customviewassignment.delegates.TaskViewPodActionDelegate
import com.zg.ccp.customviewassignment.viewpods.TaskViewPod
import kotlinx.android.synthetic.main.view_holder_tasks.view.*

class TaskAndDataViewHolder(itemView: View,
                            val mDelegate : TaskViewHolderActionDelegate,
                            private val mTaskViewPodDelegate : TaskViewPodActionDelegate) : BaseViewHolder<TaskVO>(itemView) {

    var mViewPodTask : TaskViewPod = itemView.vpTask as TaskViewPod

    init {
        setUpViewPod()
    }

    override fun bindData(data: TaskVO) {

    }

    private fun setUpViewPod(){
        mViewPodTask.setDelegate(mTaskViewPodDelegate)
    }
}