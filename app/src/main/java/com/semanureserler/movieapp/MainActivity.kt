package com.semanureserler.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.semanureserler.movieapp.adapter.TvShowAdapter
import com.semanureserler.movieapp.databinding.ActivityMainBinding
import com.semanureserler.movieapp.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private  lateinit var binding:ActivityMainBinding
    private  val viewModel:TvShowViewModel by viewModels()
    private lateinit var tvShowAdapter:TvShowAdapter
    //adapterı dışarıda tanımladık
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
      setUpRv()
    }

    private fun setUpRv(){
      tvShowAdapter= TvShowAdapter()
        //dışarıda tanımladıgımız adapterı kendi adapterımızı aktardık
        binding.Recyler.apply {
            adapter = tvShowAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
        binding.rvEpisodes.apply {
            adapter = tvShowAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
        binding.rvRecentlyAdded.apply {
            adapter = tvShowAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
        viewModel.responseTvShow.observe(this,{listTvShows->
            tvShowAdapter.tvshows=listTvShows
            //bu fonksiyndan dönen listeyi adapterda tanımladıgımız listeye atadık
            }
            )
    }



}