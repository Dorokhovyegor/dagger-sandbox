package com.dorokhov.repo

import com.dorokhov.datasource.BestConnectionFinder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConnectionRepo
@Inject constructor(
    val bestConnectionFinder: BestConnectionFinder
) {

    fun getBestConnection(): String {
        return bestConnectionFinder.findBestConnection()
    }

}