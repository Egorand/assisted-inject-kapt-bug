package com.squareup.aiik

import com.squareup.aiik.views.ViewsModule
import com.squareup.inject.inflation.InflationInjectFactory
import dagger.Component
import dagger.Subcomponent

@Component(modules = [ActivityModule::class])
interface ActivityComponent {
  @Subcomponent(modules = [ViewsModule::class])
  interface ViewInjector {
    fun inflaterFactory(): InflationInjectFactory
  }

  fun viewInjector(): ViewInjector
}
