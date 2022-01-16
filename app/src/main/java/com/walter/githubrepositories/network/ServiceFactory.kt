package com.walter.githubrepositories.network

interface ServiceFactory {
    fun <T> create(service: Class<T>): T
}
