package com.roof.navigation.activities.app.restoran_details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.roof.core.navigation.INavigator
import com.roof.payhammer.navigation.R
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class RestoranDetailsActivity : AppCompatActivity(R.layout.activity_restoran_details) {

    private val navigator by inject<INavigator<RestoranDetailsActivity>>(
        named(RestoranDetailsActivity::class.java.name)
    )

    private val router by inject<IRestoranDetailsRouter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigator.attach(this)

        if (savedInstanceState == null) {
            router.navigateToRestoranDetails()
        }
    }

}