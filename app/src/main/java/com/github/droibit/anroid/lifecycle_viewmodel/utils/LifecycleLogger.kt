package com.github.droibit.anroid.lifecycle_viewmodel.utils

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import timber.log.Timber

class LifecycleLogger(
  private val tag: Class<*>
) : LifecycleObserver {

  @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
  fun onLifecycleEvent(owner: LifecycleOwner, event: Lifecycle.Event) {
    Timber.d("${tag.simpleName} : $event")
  }

  fun log(message: String) {
    Timber.d("${tag.simpleName} : $message")
  }
}