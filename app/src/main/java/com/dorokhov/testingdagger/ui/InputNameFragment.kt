package com.dorokhov.testingdagger.ui

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dorokhov.repo.UserRepo
import com.dorokhov.testingdagger.R
import com.dorokhov.testingdagger.di.provider.ApplicationComponentProvider
import kotlinx.android.synthetic.main.fragment_blank.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class InputNameFragment : Fragment() {

    @Inject
    lateinit var userRepo: UserRepo

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (this.context?.applicationContext as ApplicationComponentProvider).providerApplicationComponent()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userName.text = userRepo.getUserName()
        saveButton.setOnClickListener {
            userRepo.saveUserName(nameEditText.text.toString())
            Handler().postDelayed({
                userName.text = userRepo.getUserName()
            }, 1000)
        }
    }
}
