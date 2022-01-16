package com.walter.githubrepositories.presentation.repos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.walter.githubrepositories.R
import com.walter.githubrepositories.databinding.GithubRepositoryItemBinding
import com.walter.githubrepositories.domain.entity.GitHubRepo

class GitHubRepositoriesAdapter :
    PagingDataAdapter<GitHubRepo, GitHubRepositoriesAdapter.GitHubRepositoriesViewHolder>(
        DiffCallBack
    ) {

    object DiffCallBack : DiffUtil.ItemCallback<GitHubRepo>() {
        override fun areItemsTheSame(oldItem: GitHubRepo, newItem: GitHubRepo): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: GitHubRepo, newItem: GitHubRepo): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GitHubRepositoriesViewHolder {
        return GitHubRepositoriesViewHolder(
            GithubRepositoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: GitHubRepositoriesViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class GitHubRepositoriesViewHolder(private val binding: GithubRepositoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repo: GitHubRepo) {
            binding.repositoryName.text = repo.name
            binding.forkImageView.load(R.drawable.ic_fork){
                crossfade(true)
                scale(Scale.FIT)
            }
            binding.totalForksText.text = repo.totalForks.toString()
            binding.starImageView.load(R.drawable.ic_star) {
                crossfade(true)
                scale(Scale.FIT)
            }
            binding.totalStarsText.text = repo.totalStars.toString()
            binding.authorAvatar.load(repo.avatarUrl) {
                crossfade(true)
                scale(Scale.FIT)
                transformations(CircleCropTransformation())
            }
            binding.authorNameText.text = repo.authorName
        }
    }
}