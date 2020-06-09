package com.dorokhov.repo

import android.content.SharedPreferences
import com.dorokhov.datasource.utils.SharedPrefsConstants
import java.text.SimpleDateFormat
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepo
@Inject
constructor(
    val sharedPreferences: SharedPreferences,
    val sharedPreferencesEditor: SharedPreferences.Editor
) {

    fun getUserName(): String {
        return sharedPreferences.getString(SharedPrefsConstants.SHARED_USER_NAME, "")!!
    }

    fun saveUserName(newName: String) {
        sharedPreferencesEditor.putString(SharedPrefsConstants.SHARED_USER_NAME, newName)
            .apply()
    }

    fun getLastname(): String {
        return sharedPreferences.getString(SharedPrefsConstants.SHARED_USER_LASTNAME, "")!!
    }

    fun saveLastname(lastName: String) {
        sharedPreferencesEditor.putString(SharedPrefsConstants.SHARED_USER_LASTNAME, lastName)
            .apply()
    }

}