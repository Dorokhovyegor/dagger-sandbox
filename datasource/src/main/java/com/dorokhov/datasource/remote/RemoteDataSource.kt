package com.dorokhov.datasource.remote

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource
@Inject
constructor() {

    fun requestStringFromRemoteSource(): String {
        return "Remote"
    }

}