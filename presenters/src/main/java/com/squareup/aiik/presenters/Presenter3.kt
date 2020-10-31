package com.squareup.aiik.presenters

import com.squareup.aiik.backend.api.FooManager
import com.squareup.aiik.viewmodels.ViewEvent3.ChangeTitle
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

import com.squareup.aiik.viewmodels.ViewEvent3 as ViewEvent
import com.squareup.aiik.viewmodels.ViewModel3 as ViewModel

class Presenter3 @AssistedInject internal constructor(
  private val fooManager: FooManager,
  @Assisted private val viewTitle: String,
) : ObservableTransformer<ViewEvent, ViewModel> {
  override fun apply(events: Observable<ViewEvent>): ObservableSource<ViewModel> {
    return Observable.merge(
        fooManager
            .foo()
            .map { foo -> ViewModel(title = "$viewTitle $foo") },
        events
            .filter { event -> event is ChangeTitle }
            .cast(ChangeTitle::class.java)
            .map { event -> ViewModel(title = event.newTitle) },
    )
  }

  @AssistedInject.Factory
  interface Factory {
    fun create(viewTitle: String): Presenter3
  }
}
