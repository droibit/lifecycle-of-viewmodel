package com.github.droibit.anroid.lifecycle_viewmodel.ui

import android.os.Bundle
import com.github.droibit.anroid.lifecycle_viewmodel.R.layout
import com.github.droibit.anroid.lifecycle_viewmodel.utils.LifecycleLogger
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

  @Inject internal lateinit var logger: LifecycleLogger

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
    lifecycle.addObserver(logger)
  }
}
