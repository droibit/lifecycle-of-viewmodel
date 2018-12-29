package com.github.droibit.anroid.lifecycle_viewmodel.ui

import androidx.lifecycle.ViewModel
import com.github.droibit.anroid.lifecycle_viewmodel.di.ViewModelKey
import com.github.droibit.anroid.lifecycle_viewmodel.ui.MainActivityModule.BindingModule
import com.github.droibit.anroid.lifecycle_viewmodel.utils.LifecycleLogger
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [BindingModule::class])
class MainActivityModule {

  @Provides
  fun provideLogger(activity: MainActivity): LifecycleLogger {
    return LifecycleLogger(activity::class.java)
  }

  @Module
  interface BindingModule {

    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    @Binds
    fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel
  }
}