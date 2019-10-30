package me.hafizdwp.kade_submission_2.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import me.hafizdwp.kade_submission_2.util.livedata.SingleLiveEvent
import kotlin.coroutines.CoroutineContext

/**
 * @author hafizdwp
 * 29/10/2019
 **/
abstract class BaseViewModel(val app: Application) : AndroidViewModel(app), CoroutineScope {

    private val supervisorJob = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + supervisorJob


    val globalToast = SingleLiveEvent<String>()

    open fun clearJob() {
        supervisorJob.cancel()
    }


    fun launch(action: suspend CoroutineScope.() -> Unit):
            Job = CoroutineScope(coroutineContext).launch { action(this) }

    suspend fun <T> asyncAwait(context: CoroutineContext = Dispatchers.IO,
                               action: suspend CoroutineScope.() -> T): T =
            CoroutineScope(context).async { action(this) }.await()


//    fun <T> Throwable.getErrorMessage(): String {
//        when (this) {
//            is UnknownHostException ->
//                return (app.getString(R.string.error_msg_no_internet))
//
//            is SocketTimeoutException ->
//                return (app.getString(R.string.error_msg_disconnected))
//
//            is HttpException -> {
//
//                val code = this.code()
//                var msg = this.message()
//                var errorDao: BaseApiModel<T>?
//
//                try {
//                    val body = this.response()?.errorBody()
//                    errorDao = body?.string()?.fromJson()
//
//                } catch (exception: Exception) {
//
//                    // When extracting the body failed,
//                    // return with throwable message instead
//                    return (exception.message!!)
//                }
//
//                when (code) {
//                    500 -> msg = errorDao?.status_message
//                            ?: app.getString(R.string.error_msg_internal_server_error)
//                    503 -> msg = errorDao?.status_message
//                            ?: app.getString(R.string.error_msg_server_error)
//                    504 -> msg = errorDao?.status_message
//                            ?: app.getString(R.string.error_msg_response)
//                    502, 404 ->
//                        msg = errorDao?.status_message
//                                ?: app.getString(R.string.error_msg_error_connect_or_not_found)
//                    400 -> msg = errorDao?.status_message
//                            ?: app.getString(R.string.error_msg_bad_request)
//                    401 -> msg = errorDao?.status_message
//                            ?: app.getString(R.string.error_msg_not_authorized)
//                }
//
//                // Return with code and filtered msg
//                return (msg)
//            }
//
//            else ->
//                return (this.message!!)
//        }
//    }
}