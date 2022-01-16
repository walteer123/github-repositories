package com.walter.githubrepositories.presentation.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.walter.githubrepositories.databinding.FragmentGithubReposBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GithubReposFragment : Fragment() {

    private val viewModel: GitHubReposViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding = FragmentGithubReposBinding.inflate(inflater)
        return binding.root
    }
}
