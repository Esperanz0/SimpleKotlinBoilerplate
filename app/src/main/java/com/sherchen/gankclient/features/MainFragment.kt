package com.sherchen.gankclient.features

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.sherchen.gankclient.bean.FuckGoods
import com.sherchen.gankclient.databinding.ViewRecyclerBinding
import com.sherchen.gankclient.di.Injectable
import com.sherchen.gankclient.mvp.FuckGoodsPresenter
import com.sherchen.gankclient.mvp.FuckGoodsView
import com.sherchen.gankclient.router.GankClientUri
import com.sherchen.gankclient.router.GankRouter
import java.net.URLEncoder
import javax.inject.Inject

/**
 * The description of use:
 * <br />
 * Created time:2017/6/10 11:57
 * Created by Dave
 */
abstract class MainFragment : BaseMvpBingingFragment<ViewRecyclerBinding, FuckGoodsView, FuckGoodsPresenter>(), FuckGoodsView, Injectable {
    lateinit var mAdapter: BaseBindingAdapter<*>
    protected var mList = ArrayList<FuckGoods>()
    private var mPage = 1
    @Inject lateinit var mPresent: FuckGoodsPresenter

    override fun setData(results: List<FuckGoods>) {
        mList.addAll(results)
        mAdapter.notifyDataSetChanged()
    }

    override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): ViewRecyclerBinding {
        return ViewRecyclerBinding.inflate(inflater, container, false)
    }

    override fun createPresenter(): FuckGoodsPresenter {
        return mPresent
    }

    override fun initView() {
        mAdapter = getAdapter(mList)
        with(mBinding!!) {
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = getLayoutManager()
            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!recyclerView?.canScrollVertically(1)!!) {//如果recyclerView为空，则强制抛出空指针
                        mPresent.getData(mPage++, getType())
                    }
                }

                override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                }
            })
        }

        mAdapter.setOnItemClickListener(getItemClickListener())

        mPresent.getData(mPage, getType())
    }

    open fun getItemClickListener(): (Int) -> Unit {
        return { pos ->
            var url = URLEncoder.encode(mList[pos].url)
            GankRouter.router(context, GankClientUri.DETAIL + url)
        }
    }

    open fun getLayoutManager() = LinearLayoutManager(context)


    override fun onDestroy() {
        super.onDestroy()
        mPresent.unSubscribe()
    }

    abstract fun getAdapter(list: ArrayList<FuckGoods>): BaseBindingAdapter<*>

    abstract fun getType(): String
}