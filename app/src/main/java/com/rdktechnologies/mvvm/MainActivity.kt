package com.rdktechnologies.mvvm


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.rdktechnologies.mvvm.databinding.ActivityMainBinding
import com.rdktechnologies.mvvm.viewModel.AppViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        activityMainBinding.viewModel = AppViewModel()
        activityMainBinding.executePendingBindings()
    }
}

@BindingAdapter("toastMessage")
fun runMe(view: View, message: String?) {
    if (message != null) Toast
        .makeText(
            view.context, message,
            Toast.LENGTH_SHORT
        )
        .show()
}