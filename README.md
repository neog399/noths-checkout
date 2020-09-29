# noths-checkout
A simple checkout system created for Not on the High Street implemented in Java

## Build & tests

To build the app just run `./gradlew clean build`. This will run the tests, too.

Alternatively, you could just run `./gradlew clean test`.

## Solution

I tried to stick to the [YAGNI principle](https://www.martinfowler.com/bliki/Yagni.html) and only implement what was
required by the task. This means that the solution is, unsurprisingly, not something I'd actually put in production.
I left a few comments / suggestions explaining what could / should be changed depending on the requirements.

I also used TDD during the implementation. In order to showcase this, I committed after each test / refactor step
as you can see from the git log.