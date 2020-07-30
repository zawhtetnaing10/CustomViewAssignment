package com.zg.ccp.customviewassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zg.ccp.customviewassignment.R
import com.zg.ccp.customviewassignment.data.vos.TaskVO
import com.zg.ccp.customviewassignment.delegates.TaskViewHolderActionDelegate
import com.zg.ccp.customviewassignment.delegates.TaskViewPodActionDelegate
import com.zg.ccp.customviewassignment.viewholders.TaskAndDataViewHolder

class TaskAndDataAdapter(private val mDelegate : TaskViewHolderActionDelegate,
                        private val mTaskViewPodDelegate : TaskViewPodActionDelegate) : BaseRecyclerAdapter<TaskAndDataViewHolder, TaskVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAndDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_tasks,parent,false)
        return TaskAndDataViewHolder(view, mDelegate, mTaskViewPodDelegate)
    }

    override fun onBindViewHolder(holder: TaskAndDataViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}