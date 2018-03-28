# Transliteration &amp; sanitization for scala

## Status
[![Download](https://api.bintray.com/packages/raisercostin/maven/scala-transliteration/images/download.svg)](https://bintray.com/raisercostin/maven/scala-transliteration/_latestVersion)
[![Build Status](https://travis-ci.org/raisercostin/scala-transliteration.svg?branch=master)](https://travis-ci.org/raisercostin/scala-transliteration)
[![Codacy Badge](https://www.codacy.com/project/badge/5cc4b6b21f694317ab8beec05342c7b5)](https://www.codacy.com/app/raisercostin/scala-transliteration)
[![codecov](https://codecov.io/gh/raisercostin/scala-transliteration/branch/master/graph/badge.svg)](https://codecov.io/gh/raisercostin/scala-transliteration)
<!--[![codecov.io](http://codecov.io/github/raisercostin/scala-transliteration/coverage.svg?branch=master)](http://codecov.io/github/raisercostin/scala-transliteration?branch=master)-->

## Description

A scala wrapper around ICU (http://site.icu-project.org/), with some specific use cases


# Usage

## Sbt dependencies

In order to add the library dependency to your project, add the bintray resolver:

    resolvers += "raisercostin resolver" at "http://dl.bintray.com/raisercostin/maven"

And then

    libraryDependencies += "hr.element.etb" %% "scala-transliteration" % "0.0.1"

In order to use:

    scala> import hr.element.etb.translit._
    import hr.element.etb.translit._

### Version 0.1

Released to `2.10.7`, `2.11.12`, `2.12.5` . See http://dl.bintray.com/raisercostin/maven/hr/element/etb/

### Version 0.0.1
Latest version (0.0.1) has been published against all reasonable versions of Scala:  
**2.8.x**: 2.8.1, 2.8.2  
**2.9.x**: 2.9.0, 2.9.0-1, 2.9.1, 2.9.1-1, 2.9.2, 2.9.3  
**2.10.x**: 2.10.4  
**2.11.x**: 2.11.2


You can now instantiate one of the transliteration/sanitization options.  
By default, SlugURL will lowercase, trim and transliterate everything into an URL-safe slug string:

    scala> SlugURL("Listening to: Humoresque № 7 by Antonín Dvořák")
    res0: String = listening-to-humoresque-no-7-by-antonin-dvorak

Congrats! You can now use this in your URL:

    http://example.com/playlist/listening-to-humoresque-no-7-by-antonin-dvorak

Remember that the result string length may differ after transliteration, since conversions work by replacing snippets of X characters with Y characters.

# Development
 - to configure release
     ```bintrayChangeCredentials```
 - to release

 ```
 sbt> release skip-tests
 ```
