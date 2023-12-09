package com.dariwan.appnews.presentation.detailnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dariwan.appnews.R
import com.dariwan.appnews.core.domain.model.News
import com.dariwan.appnews.databinding.ActivityDetailNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailNewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailNewsBinding
    private val detailNewsViewModel: DetailNewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailNews = intent.getParcelableExtra<News>(EXTRA_DATA)
        setupView(detailNews)
    }

    private fun setupView(detailNews: News?) {
        detailNews?.let {
            binding.tvTittleDetailNews.text = detailNews.title
            binding.tvAuthor.text = detailNews.author
            binding.tvDate.text = detailNews.publishedAt
            binding.tvContent.text = detailNews.content
            Glide.with(this@DetailNewsActivity)
                .load(detailNews.urlToImage)
                .into(binding.imgDetailNews)

            var statusBookmark = detailNews.isBookmark
            setStatusBookmark(statusBookmark)
            binding.ibBookmark.setOnClickListener {
                statusBookmark = !statusBookmark
                detailNewsViewModel.setBookmarkNews(detailNews, statusBookmark)
                setStatusBookmark(statusBookmark)
            }
        }
    }

    private fun setStatusBookmark(statusBookmark: Boolean) {
        if (statusBookmark) {
            binding.ibBookmark.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_bookmark_true
                )
            )
            Toast.makeText(this, "Data Berhasil ditambahkan", Toast.LENGTH_SHORT).show()
        } else {
            binding.ibBookmark.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_bookmark_false
                )
            )
            Toast.makeText(this, "Data Berhasil dihapus", Toast.LENGTH_SHORT).show()
        }
    }


    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}