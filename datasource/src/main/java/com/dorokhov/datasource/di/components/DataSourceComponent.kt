package com.dorokhov.datasource.di.components

import com.dorokhov.datasource.BestConnectionFinder
import com.dorokhov.datasource.di.modules.DataSourceModule
import dagger.Subcomponent

@Subcomponent(
    modules = [
        DataSourceModule::class
    ]
)
interface DataSourceComponent {

    fun inject(bestConnectionFinder: BestConnectionFinder)

}