package com.semanureserler.movieapp.repository

import com.semanureserler.movieapp.api.ApiService
import javax.inject.Inject

class TvShowRepository
@Inject constructor(private val apiService:ApiService)
{
    suspend fun getTvShows()=apiService.getTvShows()
}