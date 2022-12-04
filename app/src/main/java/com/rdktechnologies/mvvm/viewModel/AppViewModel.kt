package com.rdktechnologies.mvvm.viewModel

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.rdktechnologies.mvvm.BR
import com.rdktechnologies.mvvm.model.Model


class AppViewModel : BaseObservable() {
    // creating object of Model class
    var model: Model = Model("", "")

    // string variables for
    // toast messages
    private val successMessage = "Login successful"
    private val errorMessage = "Email or Password is not valid"

    // getter and setter methods
    // for toast message
    @Bindable
    var toastMessage: String? = null

    @JvmName("setToastMessage1")
    fun setToastMessage(toastMessage: String) {
        this.toastMessage = toastMessage
       // notifyPropertyChanged(BR.toastMessage)
    }

    @Bindable
    fun getUserEmail(): String {
        return model.email.toString()
    }

    fun setUserEmail(email: String) {
        model.email = email
        notifyPropertyChanged(BR.userEmail)
    }

    @Bindable
    fun getUserPassword(): String? {
        return model.password
    }

    fun setUserPassword(password: String?) {
        model.password = password
        notifyPropertyChanged(BR.userPassword)
    }

    fun onButtonClicked() {
        if (isValid()) setToastMessage(successMessage) else setToastMessage(errorMessage)
    }

    private fun isValid(): Boolean {
        return (!TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail())
            .matches() && getUserPassword()?.length!! > 5)
    }
}