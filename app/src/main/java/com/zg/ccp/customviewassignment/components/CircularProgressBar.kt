package com.zg.ccp.customviewassignment.components

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import com.zg.ccp.customviewassignment.R
import kotlin.math.roundToInt


class CircularProgressBar @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {
    private var mViewWidth = 0
    private var mViewHeight = 0
    private val mStartAngle = -90f // Always start from top (default is: "3 o'clock on a watch.")
    private var mSweepAngle = 0f // How long to sweep from mStartAngle
    private val mMaxSweepAngle = 360f // Max degrees to sweep = full circle
    private var mStrokeWidth = 20 // Width of outline
    private val mAnimationDuration = 400 // Animation duration for progress change
    private val mMaxProgress = 100 // Max progress to use
    private var mDrawText = true // Set to true if progress text should be drawn
    private var mRoundedCorners =
        true // Set to true if rounded corners should be applied to outline ends

    private var mProgressColor = Color.BLACK // Outline color
    private var mTextColor = Color.BLACK // Progress text color
    private val mPaint: Paint

    init {
        context?.let {
            val attributes = it.obtainStyledAttributes(attrs, R.styleable.CircularProgressBar)
            mTextColor = attributes.getColor(R.styleable.CircleImageView_border_color, Color.WHITE)
            mProgressColor =
                attributes.getColor(R.styleable.CircularProgressBar_progress_color, Color.BLUE)
            mSweepAngle = attributes.getDimension(R.styleable.CircularProgressBar_sweep_angle, 1.0f)
            mStrokeWidth =
                attributes.getDimension(R.styleable.CircularProgressBar_stroke_width, 1.0f)
                    .roundToInt()
        }
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        initMeasurments()
        drawOutlineArc(canvas)
        if (mDrawText) {
            drawText(canvas)
        }
    }

    private fun initMeasurments() {
        mViewWidth = width
        mViewHeight = height
    }

    private fun drawOutlineArc(canvas: Canvas) {
        val diameter = Math.min(mViewWidth, mViewHeight)
        val pad = mStrokeWidth / 2.0.toFloat()
        val outerOval = RectF(pad, pad, diameter - pad, diameter - pad)
        mPaint.color = mProgressColor
        mPaint.strokeWidth = mStrokeWidth.toFloat()
        mPaint.isAntiAlias = true
        mPaint.strokeCap = if (mRoundedCorners) Paint.Cap.ROUND else Paint.Cap.BUTT
        mPaint.style = Paint.Style.STROKE
        canvas.drawArc(outerOval, mStartAngle, mSweepAngle, false, mPaint)
    }

    private fun drawText(canvas: Canvas) {
        mPaint.textSize = Math.min(mViewWidth, mViewHeight) / 5f
        mPaint.textAlign = Paint.Align.CENTER
        mPaint.strokeWidth = 0f
        mPaint.color = mTextColor
        mPaint.textSize = 48f

        // Center text
        val xPos = canvas.width / 2
        val yPos =
            (canvas.height / 2 - (mPaint.descent() + mPaint.ascent()) / 2).toInt()

        canvas.drawText(
            calcProgressFromSweepAngle(mSweepAngle).toString() + "%",
            xPos.toFloat(),
            yPos.toFloat(),
            mPaint
        )
    }

    private fun calcSweepAngleFromProgress(progress: Int): Float {
        return mMaxSweepAngle / mMaxProgress * progress
    }

    private fun calcProgressFromSweepAngle(sweepAngle: Float): Int {
        return (sweepAngle * mMaxProgress / mMaxSweepAngle).toInt()
    }

    fun setProgress(progress: Int) {
        val animator =
            ValueAnimator.ofFloat(mSweepAngle, calcSweepAngleFromProgress(progress))
        animator.interpolator = DecelerateInterpolator()
        animator.duration = mAnimationDuration.toLong()
        animator.addUpdateListener { valueAnimator ->
            mSweepAngle = valueAnimator.animatedValue as Float
            invalidate()
        }
        animator.start()
    }

    fun setProgressColor(color: Int) {
        mProgressColor = color
        invalidate()
    }

    fun setProgressWidth(width: Int) {
        mStrokeWidth = width
        invalidate()
    }

    fun setTextColor(color: Int) {
        mTextColor = color
        invalidate()
    }

    fun showProgressText(show: Boolean) {
        mDrawText = show
        invalidate()
    }

    fun useRoundedCorners(roundedCorners: Boolean) {
        mRoundedCorners = roundedCorners
        invalidate()
    }

    init {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    }
}