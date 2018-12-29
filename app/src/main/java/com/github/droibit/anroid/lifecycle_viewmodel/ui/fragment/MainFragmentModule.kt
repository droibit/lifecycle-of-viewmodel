package com.github.droibit.anroid.lifecycle_viewmodel.ui.fragment

import androidx.lifecycle.ViewModel
import com.github.droibit.anroid.lifecycle_viewmodel.di.ViewModelKey
import com.github.droibit.anroid.lifecycle_viewmodel.ui.fragment.MainFragmentModule.BindingModule
import com.github.droibit.anroid.lifecycle_viewmodel.utils.LifecycleLogger
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Named

@Module(includes = [BindingModule::class])
class MainFragmentModule {

  @Named("fragment")
  @Provides
  fun provideLogger(fragment: MainFragment): LifecycleLogger {
    return LifecycleLogger(fragment::class.java)
  }

  @Module
  interface BindingModule {

    @IntoMap
    @ViewModelKey(MainFragmentViewModel::class)
    @Binds
    fun bindMainFragmentViewModel(viewModel: MainFragmentViewModel): ViewModel
  }
}