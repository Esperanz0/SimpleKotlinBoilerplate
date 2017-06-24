package com.sherchen.gankclient.mvp

import android.app.Activity
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.sherchen.gankclient.bean.FuckGoods
import com.sherchen.gankclient.bean.JsonResult
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by sherchen on 2017/6/23
 */
open class RxBasePresenter<V : MvpView>(private val activity: Activity) : MvpBasePresenter<V>(activity) {


    var compositeDisposable = CompositeDisposable()


    protected fun addDisposable(subscription: Disposable) {
        compositeDisposable.add(subscription)
    }

     fun unSubscribe() {
        if(!compositeDisposable.isDisposed){
            compositeDisposable.dispose()
        }
    }

    protected fun <T> submit(observable: Observable<JsonResult<T>>, block: (T) -> Unit) {
        addDisposable(
                observable.observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { res ->
                                        if(!res.error && res.results != null) {
                                            block(res.results)
                                        }
                                },
                                { e ->
                                    android.util.Log.e("sherchen", "error android Presenter" + e.message)
                                }
                        )
        )
    }
}