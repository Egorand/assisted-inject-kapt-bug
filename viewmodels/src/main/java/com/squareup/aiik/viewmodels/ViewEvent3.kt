package com.squareup.aiik.viewmodels

sealed class ViewEvent3 {
  data class ChangeTitle(val newTitle: String) : ViewEvent3()
}
