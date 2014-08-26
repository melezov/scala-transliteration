Transliteration &amp; sanitization for scala
============================================

A scala wrapper around ICU (http://site.icu-project.org/), with some specific use cases

Latest version (0.0.1) has been published against all reasonable versions of Scala:  
**2.8.x**: 2.8.1, 2.8.2  
**2.9.x**: 2.9.0, 2.9.0-1, 2.9.1, 2.9.1-1, 2.9.2, 2.9.3  
**2.10.x**: 2.10.4  
**2.11.x**: 2.11.2

In order to add the library dependency to your project, add the Element resolver:

    resolvers += "Element Releases" at "http://repo.element.hr/nexus/content/repositories/releases/"

And then

    libraryDependencies += "hr.element.etb" %% "scala-transliteration" % "0.0.1"

In order to use:

    scala> import hr.element.etb.translit._
    import hr.element.etb.translit._

You can now instantiate one of the transliteration/sanitization options.  
By default, SlugURL will lowercase, trim and transliterate everything into an URL-safe slug string:

    scala> SlugURL("Listening to: Humoresque № 7 by Antonín Dvořák")
    res0: String = listening-to-humoresque-7-by-antonin-dvorak

Congrats! You can now use this in your URL:

    http://example.com/playlist/listening-to-humoresque-no-7-by-antonin-dvorak

Remember that the result string length may differ after transliteration, since conversions work by replacing snippets of X characters with Y characters.
