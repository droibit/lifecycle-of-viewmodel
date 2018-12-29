package com.github.droibit.anroid.lifecycle_viewmodel.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import kotlin.LazyThreadSafetyMode.NONE

class MainFragmentViewModel @Inject constructor() : ViewModel() {

  val ref: LiveData<String> by lazy(NONE) {
    MutableLiveData<String>().also {
      it.value = "${this::class.java.simpleName}@${Integer.toHexString(this.hashCode())}"
    }
  }
}