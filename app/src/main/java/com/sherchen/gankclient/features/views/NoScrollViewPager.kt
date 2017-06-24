package com.sherchen.gankclient.features.views

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent



/**
 * Created by sherchen on 2017/6/23
 */
class NoScrollViewPager : android.support.v4.view.ViewPager {

    private val isPagingEnabled = false

    constructor(context: android.content.Context) : super(context) {
    }

    constructor(context: android.content.Context, attrs: android.util.AttributeSet) : super(context, attrs) {
    }

    override fun onTouchEvent(event: android.view.MotionEvent): Boolean {
        return this.isPagingEnabled && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: android.view.MotionEvent): Boolean {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event)
    }

    override fun scrollTo(x: Int, y: Int) {
        super.scrollTo(x, y)
    }
}