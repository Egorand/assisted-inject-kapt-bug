package com.squareup.aiik

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.squareup.inject.inflation.InflationInjectFactory

class MainActivity : AppCompatActivity() {
  private lateinit var viewFactory: InflationInjectFactory

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val component = DaggerActivityComponent.create()
    viewFactory = component.viewInjector().inflaterFactory()

    setContentView(R.layout.main_activity)
  }

  override fun onCreateView(
    parent: View?,
    name: String,
    context: Context,
    attrs: AttributeSet
  ): View? {
    return viewFactory.onCreateView(parent, name, context, attrs)
        ?: super.onCreateView(parent, name, context, attrs)
  }
}
