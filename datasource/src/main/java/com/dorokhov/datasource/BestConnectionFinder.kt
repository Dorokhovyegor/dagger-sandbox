package com.dorokhov.datasource

import com.dorokhov.datasource.cache.LocalDataSource
import com.dorokhov.datasource.remote.RemoteDataSource
import java.text.SimpleDateFormat
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class BestConnectionFinder
@Inject
constructor(
    val remoteDataSource: RemoteDataSource,
    val localDataSource: LocalDataSource
) {

    @Inject
    lateinit var simpleDateFormat: SimpleDateFormat

    fun findBestConnection(): String {
        return if (Random(1).nextInt(0, 1) == 1) {

            remoteDataSource.requestStringFromRemoteSource()+ simpleDateFormat.dateFormatSymbols.weekdays
        } else {
            localDataSource.requestStringFromLocalSource() + simpleDateFormat.dateFormatSymbols.weekdays
        }
    }

}
