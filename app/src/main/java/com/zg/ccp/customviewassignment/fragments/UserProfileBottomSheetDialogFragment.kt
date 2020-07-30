package com.zg.ccp.customviewassignment.fragments

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.zg.ccp.customviewassignment.R
import com.zg.ccp.customviewassignment.adapters.ProfileFragmentStateAdapter
import kotlinx.android.synthetic.main.bottom_sheet_dialog_fragment_user_profile.*
import kotlinx.android.synthetic.main.view_holder_tasks.*

class UserProfileBottomSheetDialogFragment : BottomSheetDialogFragment() {

    companion object {
        const val USER_PROFILE_BOTTOM_SHEET_TAG = "USER_PROFILE_BOTTOM_SHEET_TAG"

        fun newInstance(): UserProfileBottomSheetDialogFragment {
            return UserProfileBottomSheetDialogFragment()
        }
    }

    private lateinit var mProfileFragmentStateAdapter : ProfileFragmentStateAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            inflater.inflate(R.layout.bottom_sheet_dialog_fragment_user_profile, container, false)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnDismiss.setOnClickListener {
            this.dismiss()
        }

        setUpViewPager()
    }

    private fun setUpViewPager() {
        mProfileFragmentStateAdapter = ProfileFragmentStateAdapter(this)
        viewPagerProfile.adapter = mProfileFragmentStateAdapter

        TabLayoutMediator(tabLayoutProfile, viewPagerProfile){ tab, position ->
            when(position){
                0 -> tab.text = getString(R.string.project_tasks)
                1 -> tab.text = getString(R.string.contacts)
                2 -> tab.text = getString(R.string.about_you)
            }
        }.attach()
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = super.onCreateDialog(savedInstanceState)

        dialog.setOnShowListener { dialogInterface ->
            val bottomSheetDialog = dialogInterface as BottomSheetDialog
            setupFullHeight(bottomSheetDialog)
        }
        return dialog
    }

    private fun setupFullHeight(bottomSheetDialog: BottomSheetDialog) {
        val bottomSheet =
            bottomSheetDialog.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
        val behavior: BottomSheetBehavior<*> = BottomSheetBehavior.from<FrameLayout?>(bottomSheet!!)
        val layoutParams = bottomSheet.layoutParams
        val windowHeight = getWindowHeight()
        if (layoutParams != null) {
            layoutParams.height = windowHeight
        }
        bottomSheet.layoutParams = layoutParams
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun getWindowHeight(): Int {
        // Calculate window height for fullscreen use
        val displayMetrics = DisplayMetrics()
        (context as Activity?)!!.windowManager.defaultDisplay
            .getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }
}