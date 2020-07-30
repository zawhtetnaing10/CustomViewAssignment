package com.zg.ccp.customviewassignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zg.ccp.customviewassignment.R
import com.zg.ccp.customviewassignment.adapters.ProjectTaskAdapter
import kotlinx.android.synthetic.main.fragment_project_task.*

class ProjectTaskFragment : Fragment() {

    companion object{
        const val PROJECT_TASK_FRAGMENT_TAG = "PROJECT_TASK_FRAGMENT_TAG"

        fun newInstance(): ProjectTaskFragment {
            return ProjectTaskFragment()
        }
    }

    var mAdapter : ProjectTaskAdapter = ProjectTaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_project_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        with(rvProjectTask){
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }


}