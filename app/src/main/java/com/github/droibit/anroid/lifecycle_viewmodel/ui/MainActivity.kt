package com.github.droibit.anroid.lifecycle_viewmodel.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.droibit.anroid.lifecycle_viewmodel.R.layout

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
  }
}
