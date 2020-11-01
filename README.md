To repro the issue:

1. Build the project with the following command:

```
./gradlew :blockers:presenters:testDebugUnitTest \
  :presenters:testDebugUnitTest \
  :app:assembleDebug
```

2. Run `./move-view1.sh`. Rebuild the project using the same command.

3. Run `./revert-move-view1.sh`. Rebuild the project and observe build failures.
