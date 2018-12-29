package com.github.droibit.anroid.lifecycle_viewmodel.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.droibit.anroid.lifecycle_viewmodel.utils.LifecycleLogger
import javax.inject.Inject
import javax.inject.Named
import kotlin.LazyThreadSafetyMode.NONE

class MainFragmentPresenterViewModel @Inject constructor(
  @Named("fragment") private val logger: LifecycleLogger
) : ViewModel() {

  init {
    logger.log("Create ${this::class.java.simpleName}.")
  }

  val ref: LiveData<String> by lazy(NONE) {
    MutableLiveData<String>().also {
      it.value = "${this::class.java.simpleName}@${Integer.toHexString(this.hashCode())}"
    }
  }
}