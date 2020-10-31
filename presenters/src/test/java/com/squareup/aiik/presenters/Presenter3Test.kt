package com.squareup.aiik.presenters

import com.google.common.truth.Truth.assertThat
import com.jakewharton.rxrelay2.PublishRelay
import com.squareup.aiik.backend.fakes.FakeFooManager
import com.squareup.aiik.viewmodels.ViewEvent3.ChangeTitle
import io.reactivex.observers.TestObserver
import org.junit.Test
import com.squareup.aiik.viewmodels.ViewEvent3 as ViewEvent
import com.squareup.aiik.viewmodels.ViewModel3 as ViewModel

class Presenter3Test {
  private val fooManager = FakeFooManager()
  private val viewEvents = PublishRelay.create<ViewEvent>()

  @Test fun `default model`() {
    fooManager.foos.accept("foo")
    val viewModels = testPresenter(viewTitle = "View 1")
    assertThat(viewModels.values().single()).isEqualTo(ViewModel(title = "View 1 foo"))
  }

  @Test fun `change title`() {
    fooManager.foos.accept("foo")
    val viewModels = testPresenter(viewTitle = "View 1")

    viewEvents.accept(ChangeTitle(newTitle = "View 2"))

    assertThat(viewModels.values().last()).isEqualTo(ViewModel(title = "View 2"))
  }

  private fun testPresenter(viewTitle: String): TestObserver<ViewModel> {
    val presenter = Presenter3(fooManager, viewTitle)
    return viewEvents
        .compose(presenter)
        .test()
  }
}
