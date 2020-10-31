package com.squareup.aiik.backend.real

import com.squareup.aiik.backend.api.FooManager
import io.reactivex.Observable
import javax.inject.Inject

class RealFooManager @Inject constructor() : FooManager {
  override fun foo(): Observable<String> = Observable.just("foo")
}
