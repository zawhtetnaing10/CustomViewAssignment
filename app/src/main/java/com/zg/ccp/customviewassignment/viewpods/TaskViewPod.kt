package com.zg.ccp.customviewassignment.viewpods

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.zg.ccp.customviewassignment.delegates.TaskViewPodActionDelegate
import kotlinx.android.synthetic.main.view_pod_task.view.*

class TaskViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private var mDelegate : TaskViewPodActionDelegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()

        ivPerson.setOnClickListener {
            mDelegate?.let{
                it.onTapPersonInTask()
            }
        }
    }

    fun setDelegate(delegate  : TaskViewPodActionDelegate){
        mDelegate = delegate
    }
}