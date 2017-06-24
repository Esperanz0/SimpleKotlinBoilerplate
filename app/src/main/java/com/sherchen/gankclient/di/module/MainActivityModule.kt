package com.sherchen.gankclient.di.module

import com.sherchen.gankclient.features.MainActivity
import com.sherchen.gankclient.features.about.AboutFragment
import com.sherchen.gankclient.features.android.AndroidFragment
import com.sherchen.gankclient.features.girl.GirlFragment
import com.sherchen.gankclient.features.ios.IOSFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * The description of use:
 * <br />
 * Created time:2017/6/24 10:45
 * Created by sherchen
 */
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = arrayOf(FragmentBuildModule::class))
    abstract fun contributeMainActivity(): MainActivity
}

@Module abstract class FragmentBuildModule {
    @ContributesAndroidInjector
    abstract fun contributeAndroidFragment() : AndroidFragment
    @ContributesAndroidInjector
    abstract fun contributeIOSFragment() : IOSFragment
    @ContributesAndroidInjector
    abstract fun contributeGirlFragment() : GirlFragment
    @ContributesAndroidInjector
    abstract fun contributeAboutFragment() : AboutFragment
}