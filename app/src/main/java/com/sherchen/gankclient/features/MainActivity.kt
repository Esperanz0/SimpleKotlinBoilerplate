package com.sherchen.gankclient.features

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.sherchen.gankclient.R
import com.sherchen.gankclient.bean.FuckGoods
import com.sherchen.gankclient.databinding.ActivityMainBinding
import com.sherchen.gankclient.router.GankClientUri
import com.sherchen.gankclient.router.GankRouter
import com.sherchen.gankclient.toast
import com.sherchen.gankclient.features.android.AndroidFragment
import com.sherchen.gankclient.features.about.AboutFragment
import com.sherchen.gankclient.features.girl.GirlFragment
import com.sherchen.gankclient.features.ios.IOSFragment
import com.sherchen.gankclient.mvp.RandomPresenter
import com.sherchen.gankclient.mvp.RandomView
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URLEncoder
import java.util.*
import javax.inject.Inject

/**
 * Created by sherchen on 2017/6/23
 */
class MainActivity : BaseMvpBindingActivity<ActivityMainBinding, RandomView, RandomPresenter>(), RandomView, HasSupportFragmentInjector {
  override fun createPresenter(): RandomPresenter {
    return mPresenter
  }

  @Inject
  lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

  override fun supportFragmentInjector(): AndroidInjector<Fragment> {
    return dispatchingAndroidInjector
  }

  lateinit var mFragments: MutableList<Fragment>
  @Inject lateinit var mPresenter : RandomPresenter

  override fun createDataBinding(savedInstanceState: Bundle?): ActivityMainBinding {
    return DataBindingUtil.setContentView(this, R.layout.activity_main)
  }

  override fun initView() {
    initFragments()

    viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
      override fun getItem(p0: Int): Fragment {
        return mFragments[p0]
      }

      override fun getCount(): Int {
        return mFragments?.size
      }

    }

    viewPager.offscreenPageLimit = 4
    navigationView.setOnNavigationItemSelectedListener { item ->
      var tab = 0
      when (item.itemId) {
        R.id.menu_android -> tab = 0
        R.id.menu_ios -> tab = 1
        R.id.menu_girl -> tab = 2
        else -> tab = 3
      }
      viewPager.currentItem = tab
      false
    }

    floatingButton.setOnClickListener {
      mPresenter.getRandom("Android")
    }
  }


  override fun showRandomLuck(goods : FuckGoods) {

    val url = URLEncoder.encode(goods.url)
    toast("手气不错～")
    GankRouter.router(this, GankClientUri.DETAIL + url)
  }

  private fun initFragments() {
    mFragments = ArrayList()
    mFragments.add(AndroidFragment.newInstance())
    mFragments.add(IOSFragment.newInstance())
    mFragments.add(GirlFragment.newInstance())
    mFragments.add(AboutFragment())
  }

}
