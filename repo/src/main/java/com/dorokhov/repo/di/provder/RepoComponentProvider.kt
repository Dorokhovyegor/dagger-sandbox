package com.dorokhov.repo.di.provder

import com.dorokhov.repo.di.components.RepoComponent

interface RepoComponentProvider {
    fun getRepoComponent(): RepoComponent
}