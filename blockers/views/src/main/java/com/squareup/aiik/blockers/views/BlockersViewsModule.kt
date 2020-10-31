package com.squareup.aiik.blockers.views

import com.squareup.aiik.blockers.presenters.BlockersPresentersModule
import com.squareup.inject.inflation.InflationModule
import dagger.Module

@InflationModule
@Module(includes = [
  BlockersPresentersModule::class,
  InflationInject_BlockersViewsModule::class,
])
abstract class BlockersViewsModule
