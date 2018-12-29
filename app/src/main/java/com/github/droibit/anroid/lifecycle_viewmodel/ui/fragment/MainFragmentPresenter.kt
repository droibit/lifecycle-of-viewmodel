package com.github.droibit.anroid.lifecycle_viewmodel.ui.fragment

import androidx.lifecycle.Lifecycle.Event.ON_CREATE
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.observe
import com.github.droibit.anroid.lifecycle_viewmodel.ui.MainActivityViewModel
import com.github.droibit.anroid.lifecycle_viewmodel.utils.LifecycleLogger

class MainFragmentPresenter(
  private val logger: LifecycleLogger,
  private val activityViewModel: MainActivityViewModel,
  private val presenterViewModel: MainFragmentPresenterViewModel
) : LifecycleObserver {

  init {
    logger.log("Create ${this::class.java.simpleName}.")
  }

  @OnLifecycleEvent(ON_CREATE)
  fun onCreate(owner: LifecycleOwner) {
    activityViewModel.ref.observe(owner) {
      logger.log(it)
    }
    presenterViewModel.ref.observe(owner) {
      logger.log(it)
    }
  }
}