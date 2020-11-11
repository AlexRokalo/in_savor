package com.roof.navigation.activities.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.roof.core.navigation.INavigator
import com.roof.core.ui_kit.widget.BottomNavigationWidget
import com.roof.core.ui_kit.widget.ToolbarWidget
import com.roof.core.ui_kit.widget.bindWidget
import com.roof.payhammer.navigation.R
import kotlinx.android.synthetic.main.activity_app.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class AppActivity : AppCompatActivity() {

    private val navigator by inject<INavigator<AppActivity>>(
        named(AppActivity::class.java.name)
    )

    private val viewModel by viewModel<BaseAppViewModel>()

    private val toolbar = ToolbarWidget(this) { onBackPressed() }
    private val bottomBar = BottomNavigationWidget(
        fragmentActivity = this,
        menuRes = R.menu.dashboard,
        listener = { item ->
            when (item.itemId) {
                R.id.category -> viewModel.onCategoryClick()
                R.id.general_list -> viewModel.onGeneralListClick()
                R.id.filter -> viewModel.onFilterClick()
                R.id.profile -> viewModel.onProfileClick()
            }
            true
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        navigator.attach(this)

        if (savedInstanceState == null) {
            viewModel.onGeneralListClick()
        }

        bindWidget(toolbarHolder, toolbar)
        bindWidget(bottomNavigationHolder, bottomBar)

    }
}