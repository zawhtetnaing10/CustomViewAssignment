package com.zg.ccp.customviewassignment.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zg.ccp.customviewassignment.R
import com.zg.ccp.customviewassignment.viewpods.PeopleAndProgressViewPod
import kotlinx.android.synthetic.main.activity_create_new_task.*

class CreateNewTaskActivity : AppCompatActivity() {

    private lateinit var mViewPodPeopleAndProgress : PeopleAndProgressViewPod

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CreateNewTaskActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_task)

        setUpViewPod()
        setUpActionListeners()
    }

    private fun setUpActionListeners(){
        btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun setUpViewPod(){
        mViewPodPeopleAndProgress = vpPeopleAndProgressCreateNewTask as PeopleAndProgressViewPod
        mViewPodPeopleAndProgress.hideProgress()
    }
}