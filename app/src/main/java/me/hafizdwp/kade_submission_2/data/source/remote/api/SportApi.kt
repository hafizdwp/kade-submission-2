package me.hafizdwp.kade_submission_2.data.source.remote.api

import me.hafizdwp.kade_submission_2.data.source.remote.model.ExampleResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author hafizdwp
 * 30/10/2019
 **/
interface SportApi {

    @GET("lookupleague.php")
    suspend fun getLeagueDetail(
            @Query("id") leagueId: Int
    ): ExampleResponse

    @GET("eventsnextleague.php")
    suspend fun getNextMatchOfLeague(
            @Query("id") leagueId: Int
    ): ExampleResponse

    @GET("eventspastleague.php")
    suspend fun getPreviousMatchOfLeague(
            @Query("id") leagueId: Int
    ): ExampleResponse

    @GET("lookupevent.php")
    suspend fun getMatchDetail(
            @Query("id") eventId: Int
    ): ExampleResponse

    @GET("searchevents.php")
    suspend fun getMatchesByKeyword(
            @Query("e") keyword: String
    ): ExampleResponse
}