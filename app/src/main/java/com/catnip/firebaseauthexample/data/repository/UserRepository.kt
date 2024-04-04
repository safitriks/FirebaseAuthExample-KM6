package com.catnip.firebaseauthexample.data.repository

import com.catnip.firebaseauthexample.data.datasource.AuthDataSource
import com.catnip.firebaseauthexample.data.model.User
import com.catnip.firebaseauthexample.utils.ResultWrapper
import com.catnip.firebaseauthexample.utils.proceedFlow
import kotlinx.coroutines.flow.Flow
import java.lang.Exception

interface UserRepository {
    @Throws(exceptionClasses = [Exception::class])
    fun doLogin(
        email: String,
        password: String
    ): Flow<ResultWrapper<Boolean>>

    @Throws(exceptionClasses = [Exception::class])
    fun doRegister(
        email: String,
        fullName: String,
        password: String
    ): Flow<ResultWrapper<Boolean>>

    fun updateProfile(fullName: String? = null): Flow<ResultWrapper<Boolean>>
    fun updatePassword(newPassword: String): Flow<ResultWrapper<Boolean>>
    fun updateEmail(newEmail: String): Flow<ResultWrapper<Boolean>>
    fun requestChangePasswordByEmail(): Boolean
    fun doLogout(): Boolean
    fun isLoggedIn(): Boolean
    fun getCurrentUser(): User?
}

class UserRepositoryImpl(private val dataSource: AuthDataSource) : UserRepository {
    override fun doLogin(
        email: String,
        password: String
    ): Flow<ResultWrapper<Boolean>> {
        return proceedFlow { dataSource.doLogin(email, password) }
    }

    override fun doRegister(
        email: String,
        fullName: String,
        password: String
    ): Flow<ResultWrapper<Boolean>> {
        return proceedFlow { dataSource.doRegister(email, fullName, password) }
    }

    override fun updateProfile(fullName: String?): Flow<ResultWrapper<Boolean>> {
        return proceedFlow { dataSource.updateProfile(fullName = fullName) }
    }

    override fun updatePassword(newPassword: String): Flow<ResultWrapper<Boolean>> {
        return proceedFlow { dataSource.updatePassword(newPassword) }
    }

    override fun updateEmail(newEmail: String): Flow<ResultWrapper<Boolean>> {
        return proceedFlow { dataSource.updateEmail(newEmail) }
    }

    override fun requestChangePasswordByEmail(): Boolean {
        return dataSource.requestChangePasswordByEmail()
    }

    override fun doLogout(): Boolean {
        return dataSource.doLogout()
    }

    override fun isLoggedIn(): Boolean {
        return dataSource.isLoggedIn()
    }

    override fun getCurrentUser(): User? {
        return dataSource.getCurrentUser()
    }

}
