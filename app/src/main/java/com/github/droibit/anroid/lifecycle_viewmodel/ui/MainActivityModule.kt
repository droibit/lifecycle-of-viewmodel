package com.github.droibit.anroid.lifecycle_viewmodel.ui

import androidx.lifecycle.ViewModel
import com.github.droibit.anroid.lifecycle_viewmodel.di.FragmentScope
import com.github.droibit.anroid.lifecycle_viewmodel.di.ViewModelKey
import com.github.droibit.anroid.lifecycle_viewmodel.ui.MainActivityModule.BindingModule
import com.github.droibit.anroid.lifecycle_viewmodel.ui.MainActivityModule.FragmentBindingModule
import com.github.droibit.anroid.lifecycle_viewmodel.ui.fragment.MainFragment
import com.github.droibit.anroid.lifecycle_viewmodel.ui.fragment.MainFragmentModule
import com.github.droibit.anroid.lifecycle_viewmodel.utils.LifecycleLogger
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Named

@Module(
    includes = [
      BindingModule::class,
      FragmentBindingModule::class
    ]
)
class MainActivityModule {

  @Named("activity")
  @Provides
  fun provideLogger(): LifecycleLogger {
    return LifecycleLogger(MainActivity::class.java)
  }

  @Provides
  fun providePresenter(
    @Named("activity") logger: LifecycleLogger
  ): MainActivityPresenter {
    return MainActivityPresenter(logger)
  }

  @Module
  interface BindingModule {

    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    @Binds
    fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel
  }

  @Module
  interface FragmentBindingModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    fun contributeMainFragmentInjector(): MainFragment
  }
}