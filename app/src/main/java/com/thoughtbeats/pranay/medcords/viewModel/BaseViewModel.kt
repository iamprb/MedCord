package com.thoughtbeats.pranay.medcords.viewModel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel(){
    private val compositeDisposable = CompositeDisposable()

    protected fun addDisposable(vararg d: Disposable){
        compositeDisposable.addAll(*d)
    }

    private fun clearDisposables(){
        compositeDisposable.clear()
    }
    override fun onCleared() {
        super.onCleared()
        clearDisposables()
    }
}