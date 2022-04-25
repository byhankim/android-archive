package com.bhk.aac.mvvmnewsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhk.aac.mvvmnewsapp.R
import com.bhk.aac.mvvmnewsapp.databinding.ItemArticlePreviewBinding
import com.bhk.aac.mvvmnewsapp.models.Article
import com.bumptech.glide.Glide

class NewsAdpater : RecyclerView.Adapter<NewsAdpater.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private lateinit var binding: ItemArticlePreviewBinding

    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url // urls: also unique!
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }


    // async list differ
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        binding = ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        binding.apply {
            Glide.with().load(article.urlToImage).into(ivArticleImage)
            tvSource.text = article.source.name
            tvTitle.text = article.title
            tvDescription.text = article.description
            tvPublishedAt.text = article.publishedAt
        }
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    override fun getItemCount() = differ.currentList.size


    // rv


}