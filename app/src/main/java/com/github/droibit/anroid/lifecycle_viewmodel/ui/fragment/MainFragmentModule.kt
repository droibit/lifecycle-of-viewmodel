package com.github.droibit.anroid.lifecycle_viewmodel.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
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
  fun provideLogger(): LifecycleLogger {
    return LifecycleLogger(MainFragment::class.java)
  }

  @Provides
  fun providePresenter(
    fragment: MainFragment,
    @Named("fragment") logger: LifecycleLogger,
    viewModelFactory: ViewModelProvider.Factory
  ): MainFragmentPresenter {
    return MainFragmentPresenter(
        logger,
        ViewModelProviders.of(fragment.requireActivity(), viewModelFactory).get(),
        ViewModelProviders.of(fragment, viewModelFactory).get()
    )
  }

  @Module
  interface BindingModule {

    @IntoMap
    @ViewModelKey(MainFragmentViewModel::class)
    @Binds
    fun bindMainFragmentViewModel(viewModel: MainFragmentViewModel): ViewModel

    @IntoMap
    @ViewModelKey(MainFragmentPresenterViewModel::class)
    @Binds
    fun bindMainFragmentPresenterViewModel(viewModel: MainFragmentPresenterViewModel): ViewModel

  }
}