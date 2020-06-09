package com.dorokhov.testingdagger.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dorokhov.repo.ConnectionRepo
import com.dorokhov.testingdagger.R
import com.dorokhov.testingdagger.di.provider.ApplicationComponentProvider
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var connectionRepo: ConnectionRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        (this.application as ApplicationComponentProvider).providerApplicationComponent()
            .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectionName.text = connectionRepo.getBestConnection()

        supportFragmentManager.beginTransaction().replace(R.id.nameFragmentContainer, InputNameFragment())
            .commit()

        supportFragmentManager.beginTransaction().replace(R.id.lastnameFragmentContainer, InputLastnameFragment())
            .commit()

    }

}
