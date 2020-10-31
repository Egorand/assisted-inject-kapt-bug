package com.squareup.aiik.viewmodels

sealed class ViewEvent2 {
  data class ChangeTitle(val newTitle: String) : ViewEvent2()
}
