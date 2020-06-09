package com.dorokhov.testingdagger.di.provider

import com.dorokhov.testingdagger.di.component.ApplicationComponent

interface ApplicationComponentProvider {

    fun providerApplicationComponent(): ApplicationComponent

}