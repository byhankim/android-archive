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

    inner class ArticleViewHolder(val binding: ItemArticlePreviewBinding) : RecyclerView.ViewHolder(binding.root)

//    private lateinit var binding: ItemArticlePreviewBinding

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
        val rootView = ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

//        binding = ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.binding.apply {
            Glide.with(holder.binding.ivArticleImage.context).load(article.urlToImage)
                .into(ivArticleImage)
            tvSource.text = article.source.name
            tvTitle.text = article.title
            tvDescription.text = article.description
            tvPublishedAt.text = article.publishedAt

            root.setOnClickListener {
                onItemClickListener?.let { it(article) }
            }

        }
    }


    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setonItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount() = differ.currentList.size


    // rv


}