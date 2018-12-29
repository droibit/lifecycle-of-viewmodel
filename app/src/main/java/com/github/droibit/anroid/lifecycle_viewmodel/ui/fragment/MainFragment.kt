package com.github.droibit.anroid.lifecycle_viewmodel.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.github.droibit.anroid.lifecycle_viewmodel.R
import com.github.droibit.anroid.lifecycle_viewmodel.ui.MainActivityViewModel
import com.github.droibit.anroid.lifecycle_viewmodel.utils.LifecycleLogger
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Named

class MainFragment : DaggerFragment() {

  @field:[Inject Named("fragment")]
  internal lateinit var logger: LifecycleLogger

  @Inject internal lateinit var presenter: MainFragmentPresenter

  @Inject internal lateinit var viewModelFactory: ViewModelProvider.Factory

  private val activityViewModel: MainActivityViewModel by activityViewModels { viewModelFactory }

  private val fragmentViewModel: MainFragmentViewModel by viewModels { viewModelFactory }

  override fun onAttach(context: Context) {
    viewModelStore
    super.onAttach(context)
    lifecycle.addObserver(logger)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_main, container, false)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)

    activityViewModel.ref.observe(this) {
      logger.log(it)
    }
    fragmentViewModel.ref.observe(this) {
      logger.log(it)
    }
    lifecycle.addObserver(presenter)
  }
}