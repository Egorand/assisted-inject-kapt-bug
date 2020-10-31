package com.squareup.aiik

import com.squareup.aiik.backend.real.BackendModule
import dagger.Module

@Module(
    includes = [
      BackendModule::class,
    ]
)
abstract class ActivityModule
