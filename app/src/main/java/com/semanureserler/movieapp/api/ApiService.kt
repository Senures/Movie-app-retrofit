package com.semanureserler.movieapp.api

import com.semanureserler.movieapp.helper.Object.Companion.END_POINT
import com.semanureserler.movieapp.models.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(END_POINT)
    suspend fun getTvShows():Response<TvShowResponse>
}