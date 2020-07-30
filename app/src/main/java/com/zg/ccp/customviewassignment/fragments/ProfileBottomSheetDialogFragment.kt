package com.zg.ccp.customviewassignment.fragments

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.zg.ccp.customviewassignment.R

//class ProfileBottomSheetDialogFragment : BottomSheetDialogFragment() {
//
//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val dialog: Dialog = super.onCreateDialog(savedInstanceState)
//        dialog.setOnShowListener { dialogInterface ->
//            val bottomSheetDialog = dialogInterface as BottomSheetDialog
//            setupFullHeight(bottomSheetDialog)
//        }
//        return dialog
//    }
//
//
//    private fun setupFullHeight(bottomSheetDialog: BottomSheetDialog) {
//        val bottomSheet =
//            bottomSheetDialog.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
//        val behavior: BottomSheetBehavior<*> = BottomSheetBehavior.from<FrameLayout?>(bottomSheet!!)
//        val layoutParams = bottomSheet.layoutParams
//        val windowHeight = getWindowHeight()
//        if (layoutParams != null) {
//            layoutParams.height = windowHeight
//        }
//        bottomSheet.layoutParams = layoutParams
//        behavior.state = BottomSheetBehavior.STATE_EXPANDED
//    }
//
//    private fun getWindowHeight(): Int {
//        // Calculate window height for fullscreen use
//        val displayMetrics = DisplayMetrics()
//        (context as Activity?)!!.windowManager.defaultDisplay
//            .getMetrics(displayMetrics)
//        return displayMetrics.heightPixels
//    }
//}