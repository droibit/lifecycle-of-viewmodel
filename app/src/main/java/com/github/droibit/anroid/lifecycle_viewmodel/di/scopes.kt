package com.github.droibit.anroid.lifecycle_viewmodel.di

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

@Retention(RUNTIME)
@Scope
annotation class ActivityScope

@Retention(RUNTIME)
@Scope
annotation class FragmentScope
