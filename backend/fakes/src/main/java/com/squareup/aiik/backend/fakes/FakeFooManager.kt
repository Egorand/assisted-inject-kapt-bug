package com.squareup.aiik.backend.fakes

import com.jakewharton.rxrelay2.BehaviorRelay
import com.squareup.aiik.backend.api.FooManager
import io.reactivex.Observable

class FakeFooManager : FooManager {
  val foos = BehaviorRelay.create<String>()

  override fun foo(): Observable<String> = foos
}
