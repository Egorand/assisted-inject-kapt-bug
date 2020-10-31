package com.squareup.aiik.backend.real

import com.squareup.aiik.backend.api.FooManager
import dagger.Binds
import dagger.Module

@Module
abstract class BackendModule {
  @Binds
  abstract fun bindFooManager(fooManager: RealFooManager): FooManager
}
