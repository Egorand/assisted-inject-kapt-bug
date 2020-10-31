package com.squareup.aiik.views

import com.squareup.aiik.presenters.PresentersModule
import com.squareup.inject.inflation.InflationModule
import dagger.Module

@InflationModule
@Module(
    includes = [
      InflationInject_ViewsModule::class,
      PresentersModule::class,
    ]
)
abstract class ViewsModule
