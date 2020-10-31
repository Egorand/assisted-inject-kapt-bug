package com.squareup.aiik.presenters

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@AssistedModule
@Module(includes = [AssistedInject_PresentersModule::class])
abstract class PresentersModule
