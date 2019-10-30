package me.hafizdwp.kade_submission_2.mvvm

import android.app.Application
import me.hafizdwp.kade_submission_2.base.BaseViewModel
import me.hafizdwp.kade_submission_2.data.MyRepository
import me.hafizdwp.kade_submission_2.data.source.remote.model.ExampleResponse
import me.hafizdwp.kade_submission_2.util.livedata.SingleLiveEvent

/**
 * @author hafizdwp
 * 30/10/2019
 **/
class MainViewModel(application: Application,
                    val mRepository: MyRepository) : BaseViewModel(application) {

    val data = SingleLiveEvent<ExampleResponse>()

    fun getExample() = launch {
        try {
            val response = asyncAwait { mRepository.getExample() }
            data.value = response
        } catch (e: Exception) {
        }
    }
}