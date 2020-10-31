#!/bin/sh

# Move files

mv viewmodels/src/main/java/com/squareup/aiik/viewmodels/ViewModel1.kt \
  blockers/viewmodels/src/main/java/com/squareup/aiik/blockers/viewmodels
mv viewmodels/src/main/java/com/squareup/aiik/viewmodels/ViewEvent1.kt \
  blockers/viewmodels/src/main/java/com/squareup/aiik/blockers/viewmodels

mv presenters/src/main/java/com/squareup/aiik/presenters/Presenter1.kt \
  blockers/presenters/src/main/java/com/squareup/aiik/blockers/presenters
mv presenters/src/test/java/com/squareup/aiik/presenters/Presenter1Test.kt \
  blockers/presenters/src/test/java/com/squareup/aiik/blockers/presenters

mv app/src/main/java/com/squareup/aiik/views/View1.kt \
  blockers/views/src/main/java/com/squareup/aiik/blockers/views
mv app/src/main/res/layout/view_1.xml blockers/views/src/main/res/layout

# Fix packages + imports

sed -i '' 's/viewmodels/blockers.viewmodels/' \
  blockers/viewmodels/src/main/java/com/squareup/aiik/blockers/viewmodels/ViewModel1.kt
sed -i '' 's/viewmodels/blockers.viewmodels/' \
  blockers/viewmodels/src/main/java/com/squareup/aiik/blockers/viewmodels/ViewEvent1.kt
sed -i '' 's/viewmodels/blockers.viewmodels/' \
  blockers/presenters/src/main/java/com/squareup/aiik/blockers/presenters/Presenter1.kt
sed -i '' 's/viewmodels/blockers.viewmodels/' \
  blockers/presenters/src/test/java/com/squareup/aiik/blockers/presenters/Presenter1Test.kt
sed -i '' 's/viewmodels/blockers.viewmodels/' \
  blockers/views/src/main/java/com/squareup/aiik/blockers/views/View1.kt

sed -i '' 's/presenters/blockers.presenters/' \
  blockers/presenters/src/main/java/com/squareup/aiik/blockers/presenters/Presenter1.kt
sed -i '' 's/presenters/blockers.presenters/' \
  blockers/presenters/src/test/java/com/squareup/aiik/blockers/presenters/Presenter1Test.kt
sed -i '' 's/presenters/blockers.presenters/' \
  blockers/views/src/main/java/com/squareup/aiik/blockers/views/View1.kt

sed -i '' 's/views/blockers.views/' blockers/views/src/main/res/layout/view_1.xml

sed -i '' 's/com.squareup.aiik.R/com.squareup.aiik.blockers.views.R/' \
  blockers/views/src/main/java/com/squareup/aiik/blockers/views/View1.kt
