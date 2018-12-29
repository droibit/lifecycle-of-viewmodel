package com.github.droibit.anroid.lifecycle_viewmodel.ui

import androidx.lifecycle.Lifecycle.Event.ON_CREATE
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.github.droibit.anroid.lifecycle_viewmodel.utils.LifecycleLogger

class MainActivityPresenter(
  private val logger: LifecycleLogger
) : LifecycleObserver {

  init {
    logger.log("Create ${this::class.java.simpleName}.")
  }

  @OnLifecycleEvent(ON_CREATE)
  fun onCreate(owner: LifecycleOwner) {

  }
}