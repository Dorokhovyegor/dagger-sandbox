package com.dorokhov.datasource.di.provider

import com.dorokhov.datasource.di.components.DataSourceComponent

interface DataSourceProvider {

    fun getDataSourceComponent(): DataSourceComponent

}