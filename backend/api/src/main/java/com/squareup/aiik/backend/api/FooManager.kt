package com.squareup.aiik.backend.api

import io.reactivex.Observable

interface FooManager {
  fun foo(): Observable<String>
}
