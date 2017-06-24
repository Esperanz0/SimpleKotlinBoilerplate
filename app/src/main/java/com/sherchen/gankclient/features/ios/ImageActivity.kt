package com.sherchen.gankclient.features.ios

import com.sherchen.gankclient.R
import com.sherchen.gankclient.databinding.ActivityImageBinding
import com.sherchen.gankclient.features.BaseBindingActivity

/**
 * Created by sherchen on 2017/6/23
 */
class ImageActivity : BaseBindingActivity<ActivityImageBinding>() {

    override fun initView() {
        mBinding.url = intent.getStringExtra(IMG)
        mBinding.root.setOnClickListener {

            supportFinishAfterTransition()
        }
    }

    override fun createDataBinding(savedInstanceState: android.os.Bundle?): ActivityImageBinding {
        return android.databinding.DataBindingUtil.setContentView(this, R.layout.activity_image)
    }

    companion object {
        val IMG = "IMG"
        fun startActivity(context: android.content.Context, imageView: android.widget.ImageView, url: String) {
            val intent = android.content.Intent(context, ImageActivity::class.java)
            intent.putExtra(IMG, url)
            if(android.os.Build.VERSION.SDK_INT > 21) {
                context.startActivity(intent, android.app.ActivityOptions.makeSceneTransitionAnimation(context as android.app.Activity, imageView, "img").toBundle())
            }else{
                context.startActivity(intent)
            }
        }

    }
}
