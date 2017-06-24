package com.sherchen.gankclient.features.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.sherchen.gankclient.databinding.FragmentAboutBinding
import com.sherchen.gankclient.features.BaseBingingFragment

/**
 * Created by sherchen on 2017/6/23
 */
class AboutFragment : BaseBingingFragment<FragmentAboutBinding>() {
    override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): FragmentAboutBinding {
        return FragmentAboutBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        val text = "Kotlin \n"
                .plus("Dagger 2\n")
                .plus("Rxjava\n")
                .plus("Retrofit 2\n")
                .plus("OkHttp 3\n")
                .plus("DataBinding\n")
                .plus("DeepLinkDispatch\n")
                .plus("Gson\n")
                .plus("Glide")
        mBinding?.tvThank?.text = text

    }


}