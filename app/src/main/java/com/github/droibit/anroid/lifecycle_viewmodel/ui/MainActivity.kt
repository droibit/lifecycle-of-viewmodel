package com.github.droibit.anroid.lifecycle_viewmodel.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.commitNow
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.github.droibit.anroid.lifecycle_viewmodel.R
import com.github.droibit.anroid.lifecycle_viewmodel.ui.fragment.MainFragment
import com.github.droibit.anroid.lifecycle_viewmodel.utils.LifecycleLogger
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Named

class MainActivity : DaggerAppCompatActivity() {

  @field:[Inject Named("activity")]
  internal lateinit var logger: LifecycleLogger

  @Inject internal lateinit var presenter: MainActivityPresenter

  @Inject internal lateinit var viewModelFactory: ViewModelProvider.Factory

  private val viewModel: MainActivityViewModel by viewModels { viewModelFactory }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    lifecycle.addObserver(logger)
    setContentView(R.layout.activity_main)

    if (savedInstanceState == null) {
      supportFragmentManager.commitNow {
        replace(R.id.fragmentContainer, MainFragment())
      }
    }

    viewModel.ref.observe(this) {
      logger.log(it)
    }
    lifecycle.addObserver(presenter)
  }
}
