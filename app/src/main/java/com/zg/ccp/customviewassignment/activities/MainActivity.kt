package com.zg.ccp.customviewassignment.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.zg.ccp.customviewassignment.R
import com.zg.ccp.customviewassignment.adapters.TaskAndDataAdapter
import com.zg.ccp.customviewassignment.fragments.UserProfileBottomSheetDialogFragment
import com.zg.ccp.customviewassignment.mvp.presenters.MainPresenter
import com.zg.ccp.customviewassignment.mvp.presenters.MainPresenterImpl
import com.zg.ccp.customviewassignment.mvp.views.MainView
import com.zg.ccp.customviewassignment.viewpods.PeopleAndProgressViewPod
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mPresenter : MainPresenter
    private lateinit var mAdapter : TaskAndDataAdapter

    private lateinit var viewPodPeopleAndProgress : PeopleAndProgressViewPod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpPresenter()
        setUpViewPod()
        setUpRecyclerView()
    }


    private fun setUpPresenter() {
        mPresenter = MainPresenterImpl()
        mPresenter.setUpPresenter(this)
    }

    private fun setUpViewPod() {
        viewPodPeopleAndProgress = vpPeopleAndProgress as PeopleAndProgressViewPod
        viewPodPeopleAndProgress.setDelegate(mPresenter)
    }


    private fun setUpRecyclerView() {
        mAdapter = TaskAndDataAdapter(mPresenter, mPresenter)
        with(rvTasks){
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showProfileBottomSheet() {
        val userProfileBottomSheetDialogFragment =
            UserProfileBottomSheetDialogFragment.newInstance()
        userProfileBottomSheetDialogFragment.show(supportFragmentManager, UserProfileBottomSheetDialogFragment.USER_PROFILE_BOTTOM_SHEET_TAG)
    }

    override fun navigateToCreateNewTaskScreen() {
        startActivity(CreateNewTaskActivity.newIntent(this))
    }
}