package com.github.droibit.anroid.lifecycle_viewmodel

import android.app.Application
import android.content.Context
import dagger.Component
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import timber.log.Timber
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
      ApplicationComponent.Module::class,
      AndroidSupportInjectionModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<SampleApplication> {

  @dagger.Module
  object Module {

    @Provides
    @JvmStatic
    fun provideApplication(application: SampleApplication): Application = application

    @Named("appContext")
    @Provides
    @JvmStatic
    fun provideContext(application: Application): Context = application

    @Provides
    @JvmStatic
    fun provideTimberTree(@Named("debuggable") debug: Boolean): Timber.Tree =
      if (debug) Timber.DebugTree() else {
        object : Timber.Tree() {
          override fun log(
            priority: Int,
            tag: String?,
            message: String,
            t: Throwable?
          ) = Unit
        }
      }

    @Named("debuggable")
    @Provides
    @JvmStatic
    fun provideDebuggable() = BuildConfig.DEBUG
  }

  @Component.Builder
  abstract class Builder : AndroidInjector.Builder<SampleApplication>()
}