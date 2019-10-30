package me.hafizdwp.kade_submission_2.data.source.remote.api

import me.hafizdwp.kade_submission_2.data.source.remote.model.ExampleResponse
import retrofit2.http.GET


/**
 * @author hafizdwp
 * 29/10/2019
 **/
interface ExampleApi {

    @GET("json/")
    suspend fun getExample(): ExampleResponse
}