package com.dorokhov.testingdagger.di.modules

import android.app.Application
import com.dorokhov.testingdagger.di.CustomApp
import dagger.Binds
import dagger.Module

@Module
abstract class SecondModule {
    @Binds
    abstract fun provideApplication(app: CustomApp): Application
}