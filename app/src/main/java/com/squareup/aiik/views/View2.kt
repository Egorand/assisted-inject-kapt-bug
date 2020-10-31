package com.squareup.aiik.views

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import com.jakewharton.rxrelay2.PublishRelay
import com.squareup.aiik.R
import com.squareup.aiik.viewmodels.ViewEvent2.ChangeTitle
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.inflation.InflationInject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

import com.squareup.aiik.presenters.Presenter2 as Presenter
import com.squareup.aiik.viewmodels.ViewEvent2 as ViewEvent
import com.squareup.aiik.viewmodels.ViewModel2 as ViewModel

@SuppressLint("ViewConstructor")
class View2 @InflationInject constructor(
  private val factory: Presenter.Factory,
  @Assisted context: Context,
  @Assisted attrs: AttributeSet?,
) : FrameLayout(context, attrs) {
  private lateinit var title: TextView

  private val viewEvents = PublishRelay.create<ViewEvent>()
  private lateinit var disposables: CompositeDisposable

  init {
    inflate(context, R.layout.view_1, this)
  }

  override fun onFinishInflate() {
    super.onFinishInflate()
    title = findViewById(R.id.title)
  }

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    disposables = CompositeDisposable()

    disposables.add(
        viewEvents
            .compose(factory.create(viewTitle = "View 2"))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::render)
    )

    setOnClickListener {
      viewEvents.accept(ChangeTitle(newTitle = "New View 2"))
    }
  }

  private fun render(viewModel: ViewModel) {
    title.text = viewModel.title
  }

  override fun onDetachedFromWindow() {
    super.onDetachedFromWindow()
    disposables.dispose()
  }
}
