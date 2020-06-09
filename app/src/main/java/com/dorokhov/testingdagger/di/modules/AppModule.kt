package com.dorokhov.testingdagger.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.dorokhov.datasource.utils.SharedPrefsConstants
import dagger.Module
import dagger.Provides
import java.text.SimpleDateFormat
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideSharedPrefs(application: Application): SharedPreferences {
        return application.getSharedPreferences(SharedPrefsConstants.SHARED_PREFS, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideSharedPrefsEditor(sharedPreferences: SharedPreferences): SharedPreferences.Editor {
        return sharedPreferences.edit()
    }

    @Provides
    fun provideSimpleData(): SimpleDateFormat {
        return SimpleDateFormat("dd:MMM:yyyy")
    }

}