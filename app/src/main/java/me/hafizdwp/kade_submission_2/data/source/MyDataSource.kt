package me.hafizdwp.kade_submission_2.data.source

import me.hafizdwp.kade_submission_2.data.source.remote.model.ExampleResponse

/**
 * @author hafizdwp
 * 10/07/19
 **/
interface MyDataSource {

    ///
    /// Remote
    ///

    suspend fun getExample(): ExampleResponse {
        throw Exception("remote only")
    }

    ///
    /// Local
    ///
}