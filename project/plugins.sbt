logLevel := Level.Info

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("me.lessis" % "bintray-sbt" % "0.3.0")
addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.0") 
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "3.0.0")
