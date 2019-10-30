package me.hafizdwp.kade_submission_2.data

import me.hafizdwp.kade_submission_2.data.source.MyDataSource
import me.hafizdwp.kade_submission_2.data.source.local.MyLocalDataSource
import me.hafizdwp.kade_submission_2.data.source.remote.MyRemoteDataSource
import me.hafizdwp.kade_submission_2.data.source.remote.model.ExampleResponse

/**
 * @author hafizdwp
 * 10/07/19
 **/
open class MyRepository(val remoteDataSource: MyRemoteDataSource,
                        val localDataSource: MyLocalDataSource) : MyDataSource {


    override suspend fun getExample(): ExampleResponse {
        return remoteDataSource.getExample()
    }

    companion object {
        private var INSTANCE: MyRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.
         */
        @JvmStatic
        fun getInstance(remoteDataSource: MyRemoteDataSource,
                        localDataSource: MyLocalDataSource) =
                INSTANCE
                        ?: synchronized(MyRepository::class.java) {
                            INSTANCE
                                    ?: MyRepository(remoteDataSource, localDataSource)
                                            .also { INSTANCE = it }
                        }
    }
}