package com.squareup.aiik.viewmodels

sealed class ViewEvent1 {
  data class ChangeTitle(val newTitle: String) : ViewEvent1()
}
