package com.dorokhov.testingdagger.di.component

import com.dorokhov.repo.di.components.RepoComponent
import com.dorokhov.repo.di.modules.RepoModule
import com.dorokhov.testingdagger.di.CustomApp
import com.dorokhov.testingdagger.di.modules.AppModule
import com.dorokhov.testingdagger.di.modules.SecondModule
import com.dorokhov.testingdagger.ui.InputLastnameFragment
import com.dorokhov.testingdagger.ui.InputNameFragment
import com.dorokhov.testingdagger.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        SecondModule::class
    ]
)
interface ApplicationComponent {

    fun child(repoModule: RepoModule): RepoComponent

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(applicationContext: CustomApp): Builder
        fun build(): ApplicationComponent
    }

    fun inject(inputNameFragment: InputNameFragment)
    fun inject(inputlastFragment: InputLastnameFragment)
    fun inject(activity: MainActivity)


}