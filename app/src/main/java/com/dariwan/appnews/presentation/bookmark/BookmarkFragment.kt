package com.dariwan.appnews.presentation.bookmark

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dariwan.appnews.R
import com.dariwan.appnews.core.ui.NewsAdapter
import com.dariwan.appnews.databinding.FragmentBookmarkBinding
import com.dariwan.appnews.presentation.detailnews.DetailNewsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookmarkFragment : Fragment() {
    private lateinit var binding: FragmentBookmarkBinding
    private val bookmarkViewModel: BookmarkViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookmarkBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        if (activity != null){
            val newsAdapter = NewsAdapter()
            newsAdapter.onItemClick = {selectedData ->
                val intent = Intent(activity, DetailNewsActivity::class.java)
                intent.putExtra(DetailNewsActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            bookmarkViewModel.bookmarkNews.observe(viewLifecycleOwner) { dataNews ->
                newsAdapter.sendData(dataNews)
                binding.tvNoData.visibility = if (dataNews.isNotEmpty()) View.GONE else View.VISIBLE
            }

            with(binding.rvBookmarkNews){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = newsAdapter
            }
        }
    }

}