package com.thoughtbeats.pranay.medcords.viewModel

import androidx.lifecycle.MutableLiveData
import com.thoughtbeats.pranay.medcords.R
import com.thoughtbeats.pranay.medcords.model.RequestParameter
import com.thoughtbeats.pranay.medcords.repo.HomeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel : BaseViewModel(){
    val responseString = MutableLiveData<String>()
    val errorResponseString = MutableLiveData<Int>()
    private val repository = HomeRepository()


    fun sendClickedButtonInfo(buttonName: String){
        val requestParameter = RequestParameter(buttonName)
        val disposable = repository.sendClickedButtonInfo(requestParameter)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response->
                responseString.postValue(response.data.rstr)
            }, {

                errorResponseString.postValue(R.string.something_went_wrong)
            })
           addDisposable(disposable)
    }


}