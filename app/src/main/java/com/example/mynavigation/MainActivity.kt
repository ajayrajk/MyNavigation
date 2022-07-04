package com.example.mynavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynavigation.databinding.ActivityMain2Binding
import com.example.mynavigation.databinding.ActivityMainBinding
import com.example.mynavigation.paging.QuotePagingAdapter
import com.example.mynavigation.viewmodels.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var quoteViewModel: QuoteViewModel
    lateinit var adapter: QuotePagingAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inItViewModel()

        adapter= QuotePagingAdapter()

        binding.quoteList.layoutManager=LinearLayoutManager(this)
        binding.quoteList.setHasFixedSize(true)
        binding.quoteList.adapter=adapter

        quoteViewModel.list.observe(this, Observer {
               adapter.submitData(lifecycle,it)
        })

    }

    private fun inItViewModel(){
        quoteViewModel= ViewModelProvider(this)[QuoteViewModel::class.java]
    }
}