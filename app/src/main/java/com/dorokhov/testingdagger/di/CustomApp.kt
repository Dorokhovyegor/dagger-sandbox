package com.dorokhov.testingdagger.di

import android.app.Application
import com.dorokhov.datasource.di.components.DataSourceComponent
import com.dorokhov.datasource.di.modules.DataSourceModule
import com.dorokhov.datasource.di.provider.DataSourceProvider
import com.dorokhov.repo.di.components.RepoComponent
import com.dorokhov.repo.di.modules.RepoModule
import com.dorokhov.repo.di.provder.RepoComponentProvider
import com.dorokhov.testingdagger.di.component.ApplicationComponent
import com.dorokhov.testingdagger.di.component.DaggerApplicationComponent
import com.dorokhov.testingdagger.di.provider.ApplicationComponentProvider

class CustomApp: Application(),  ApplicationComponentProvider, RepoComponentProvider, DataSourceProvider {

    lateinit var appComponent: ApplicationComponent
    lateinit var instance: CustomApp

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerApplicationComponent.builder().applicationContext(instance).build()
    }

    override fun getRepoComponent(): RepoComponent {
        return appComponent.plusRepositoryComponent(RepoModule())
    }

    override fun getDataSourceComponent(): DataSourceComponent {
        return appComponent.plusRepositoryComponent(RepoModule()).plusDataSourceComponent(
            DataSourceModule()
        )
    }

    override fun providerApplicationComponent(): ApplicationComponent {
        return appComponent
    }
}