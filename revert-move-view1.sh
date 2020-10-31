#!/bin/sh

rm blockers/viewmodels/src/main/java/com/squareup/aiik/blockers/viewmodels/ViewModel1.kt
rm blockers/viewmodels/src/main/java/com/squareup/aiik/blockers/viewmodels/ViewEvent1.kt
rm blockers/presenters/src/main/java/com/squareup/aiik/blockers/presenters/Presenter1.kt
rm blockers/presenters/src/test/java/com/squareup/aiik/blockers/presenters/Presenter1Test.kt
rm blockers/views/src/main/java/com/squareup/aiik/blockers/views/View1.kt
rm blockers/views/src/main/res/layout/view_1.xml

git restore .
