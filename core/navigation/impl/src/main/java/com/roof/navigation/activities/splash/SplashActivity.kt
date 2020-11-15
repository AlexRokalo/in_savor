package com.roof.navigation.activities.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.roof.core.navigation.INavigator
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.qualifier.named

class SplashActivity : AppCompatActivity() {

    private val navigator by inject<INavigator<SplashActivity>>(named(SplashActivity::class.java.name))
    private lateinit var viewModel: BaseSplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator.attach(this)
        viewModel = getViewModel()
    }
}