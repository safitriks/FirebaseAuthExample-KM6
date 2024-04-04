package com.catnip.firebaseauthexample.presentation.splashscreen

import androidx.lifecycle.ViewModel
import com.catnip.firebaseauthexample.data.repository.UserRepository

class SplashViewModel(private val repository: UserRepository) : ViewModel() {
    fun isUserLoggedIn() = repository.isLoggedIn()
}