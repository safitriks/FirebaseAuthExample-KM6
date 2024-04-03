package com.catnip.firebaseauthexample.data.repository

import com.catnip.firebaseauthexample.data.network.firebase.auth.FirebaseAuthDataSource

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface UserRepository {

}

class UserRepositoryImpl(private val dataSource: FirebaseAuthDataSource) : UserRepository {

}
