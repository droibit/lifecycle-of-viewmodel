package com.github.droibit.anroid.lifecycle_viewmodel.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.github.droibit.anroid.lifecycle_viewmodel.R.layout
import com.github.droibit.anroid.lifecycle_viewmodel.utils.LifecycleLogger
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

  @Inject internal lateinit var logger: LifecycleLogger

  @Inject internal lateinit var viewModelFactory: ViewModelProvider.Factory

  private val viewModel: MainActivityViewModel by viewModels { viewModelFactory }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
    lifecycle.addObserver(logger)

    viewModel.ref.observe(this) {
      logger.log(it)
    }
  }
}
