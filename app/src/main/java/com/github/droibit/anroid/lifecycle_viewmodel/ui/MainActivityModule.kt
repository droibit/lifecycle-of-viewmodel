package com.github.droibit.anroid.lifecycle_viewmodel.ui

import com.github.droibit.anroid.lifecycle_viewmodel.utils.LifecycleLogger
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

  @Provides
  fun provideLogger(activity: MainActivity): LifecycleLogger {
    return LifecycleLogger(activity::class.java)
  }
}