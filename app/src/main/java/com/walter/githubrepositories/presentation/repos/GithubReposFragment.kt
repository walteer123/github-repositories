package com.walter.githubrepositories.presentation.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import com.walter.githubrepositories.databinding.FragmentGithubReposBinding
import com.walter.githubrepositories.presentation.repos.adapter.GitHubRepositoriesAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class GithubReposFragment : Fragment() {

    private val viewModel: GitHubReposViewModel by viewModel()
    private val listAdapter  by lazy { GitHubRepositoriesAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding = FragmentGithubReposBinding.inflate(inflater)
        setupRecycler(binding)
        observeData()

        return binding.root
    }

    private fun setupRecycler(binding: FragmentGithubReposBinding) {
        binding.repositoriesRecycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = listAdapter
        }
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.reposDataFlow.collectLatest {
                listAdapter.submitData(it)
            }
        }
    }
}
