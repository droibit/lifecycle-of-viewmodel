package com.github.droibit.anroid.lifecycle_viewmodel.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import kotlin.LazyThreadSafetyMode.NONE

class MainActivityViewModel @Inject constructor() : ViewModel() {

  val ref: LiveData<String> by lazy(NONE) {
    MutableLiveData<String>().also {
      it.value = "${this::class.java.simpleName}@${Integer.toHexString(this.hashCode())}"
    }
  }
}