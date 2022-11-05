# MyEzetapApp

The aim of this app is to implement clean architecture and use proper android coding patterns to display server driven UI fetched from a remote API.
This project also focuses on multi-module pattern to enhance code reusability.
MyEzetapApp consists of 2 pieces of UI right now:
1. Home page with list of custom views fetched from remote
2. User entered response page

This app is under development. :construction_worker: :hammer_and_wrench:


## Demo and Screenshots
<p align="center">
<img src="/screenshots/Custom-UI-Home-Unfilled.jpg" width="240"/>
<img src="/screenshots/Custom-UI-Home-Filled.jpg" width="240"/>
<img src="/screenshots/Custom-UI_Detail.jpg" width="240"/>
</p>

## Android Development and Architecture

* The entire codebase is in [Kotlin](https://kotlinlang.org/)
* Uses Kotlin [Coroutines](https://kotlinlang.org/docs/reference/coroutines/coroutines-guide.html).
* Uses MVVM Architecture by [Architecture Components](https://developer.android.com/topic/libraries/architecture/). Retrofit, ViewModel
* Uses [Hilt Android](https://developer.android.com/training/dependency-injection/hilt-android) with [Dagger](https://dagger.dev/) for dependency injection
* Uses [Flow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/flow.html) and mutableState as a replacement over LiveData as a state-holder observable
* Uses [Jetpack compose](https://developer.android.com/jetpack/compose) latest tools to give out an appealing and smooth UI.
