package com.github.droibit.anroid.lifecycle_viewmodel

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import javax.inject.Inject

class SampleApplication : DaggerApplication() {

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerApplicationComponent.builder().create(this)
  }

  @Inject
  fun boostrap(timberTree: Timber.Tree) {
    Timber.plant(timberTree)
  }
}