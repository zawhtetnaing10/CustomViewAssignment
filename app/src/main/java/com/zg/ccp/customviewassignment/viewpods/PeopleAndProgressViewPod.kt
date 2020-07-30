package com.zg.ccp.customviewassignment.viewpods

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.zg.ccp.customviewassignment.delegates.PeopleAndProgressViewPodActionDelegate
import kotlinx.android.synthetic.main.view_pod_people_and_progress.view.*

class PeopleAndProgressViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    var mDelegate : PeopleAndProgressViewPodActionDelegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()

        btnPlus.setOnClickListener {
            mDelegate?.let {
                it.onTapPlus()
            }
        }
    }

    fun setDelegate(delegate : PeopleAndProgressViewPodActionDelegate){
        mDelegate = delegate
    }

    fun hideProgress(){
        circularProgressBar.visibility = View.GONE
    }

    fun showProgress(){
        circularProgressBar.visibility = View.VISIBLE
    }
}