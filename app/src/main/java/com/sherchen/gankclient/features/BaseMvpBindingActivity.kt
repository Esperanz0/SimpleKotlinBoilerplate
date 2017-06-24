package com.sherchen.gankclient.features

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.PersistableBundle
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

/**
 * The description of use:
 * <br />
 * Created time:2017/6/10 11:02
 * Created by Dave
 */
abstract class BaseMvpBindingActivity<B: ViewDataBinding, V:MvpView, P:MvpPresenter<V>> : MvpActivity<V, P> (){
    lateinit var mBinding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = createDataBinding(savedInstanceState)
        initView()
    }

    abstract fun createDataBinding(savedInstanceState: Bundle?) : B

    abstract fun initView()
}