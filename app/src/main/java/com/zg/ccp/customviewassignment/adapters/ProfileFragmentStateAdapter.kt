package com.zg.ccp.customviewassignment.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zg.ccp.customviewassignment.fragments.ProjectTaskFragment

class ProfileFragmentStateAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return ProjectTaskFragment.newInstance()
    }
}