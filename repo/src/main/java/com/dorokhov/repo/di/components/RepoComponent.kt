package com.dorokhov.repo.di.components

import com.dorokhov.datasource.di.components.DataSourceComponent
import com.dorokhov.datasource.di.modules.DataSourceModule
import com.dorokhov.repo.ConnectionRepo
import com.dorokhov.repo.UserRepo
import com.dorokhov.repo.di.modules.RepoModule
import dagger.Subcomponent

@Subcomponent(
    modules = [
        RepoModule::class
    ]
)
interface RepoComponent {
    fun child(dataSourceModule: DataSourceModule): DataSourceComponent
}