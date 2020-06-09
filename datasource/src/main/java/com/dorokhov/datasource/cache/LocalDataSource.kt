package com.dorokhov.datasource.cache

import android.app.Application
import com.dorokhov.datasource.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource
@Inject
constructor(
    val application: Application
) {

    fun requestStringFromLocalSource(): String {
        return application.getString(R.string.local_string)
    }

}