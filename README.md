# Assignment 
[![CircleCI](https://dl.circleci.com/status-badge/img/gh/aliaziz/realogyRepo/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/aliaziz/realogyRepo/tree/master)


## Table of contents

 * [Features](#features)
 * [Architecture](#architecture)
 * [Build variants](#build-variants)
 * [Testing](#testing)
 * [Serialization](#serialization)

## Features

* Just a simple simpson character fetcher. 

## Architecture

* This project follows the [Model-View-ViewModel](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel) pattern for separation of concerns.

This repository is structured in a modular architecture:

* ([app](https://github.com/aliaziz/realogyRepo/tree/master/app)): Entry point into the application.
* ([buildSrc](https://github.com/aliaziz/realogyRepo/tree/master/buildSrc)): Contains all the gradle code and configuration for building and compiling the project.
* ([data](https://github.com/aliaziz/realogyRepo/tree/master/data)): Network layer.  Think retrofit, network access etc.
* ([domain](https://github.com/aliaziz/realogyRepo/tree/master/domain)): Business logic layer. Think usecases etc.

### Build Variants

There are two build variants: `Simpson Character` and `Wire Character`.

## Testing

Adhering to the testing conventions, the project will include 70% Unit tests, 20% Integration tests and 10% End to End tests. These are the libraries used:

* **Unit Tests**

  * Local Unit tests
     * [JUnit4](https://junit.org/junit4/)
     * [MockK](https://mockk.io/): Concise, better error messages, supports relaxed mocking and is built for Kotlin.
     
* **Integration Tests and End to End tests**
  * None added here. 
  
* **Shared dependencies**
  * [AndroidX test core](https://developer.android.com/reference/androidx/test/core/app/package-summary)
  * [Truth](https://truth.dev/): Provides more readable and fluent tests.

## Serialization

[Kotlinx serializer](https://github.com/Kotlin/kotlinx.serialization) was the preferred tool for our serialization. 

* **Known issues**
  * At the time we are adding it, KotlinX serializer has no support for serializing **_streams_** of data.
  
  
## Documentation & Links
* [Android Developer Docs](https://developer.android.com/docs)
