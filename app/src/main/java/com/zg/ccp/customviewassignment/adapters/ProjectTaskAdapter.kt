package com.zg.ccp.customviewassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zg.ccp.customviewassignment.R
import com.zg.ccp.customviewassignment.data.vos.TaskVO
import com.zg.ccp.customviewassignment.viewholders.ProjectTaskViewHolder

class ProjectTaskAdapter : BaseRecyclerAdapter<ProjectTaskViewHolder, TaskVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectTaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_project_task,parent,false)
        return ProjectTaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProjectTaskViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }
}