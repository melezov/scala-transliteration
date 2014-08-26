val ElementNexus     = "Element Nexus"     at "http://repo.element.hr/nexus/content/groups/public/"
val ElementReleases  = "Element Releases"  at "http://repo.element.hr/nexus/content/repositories/releases/"
val ElementSnapshots = "Element Snapshots" at "http://repo.element.hr/nexus/content/repositories/snapshots/"

// ### BASIC SETTINGS ### //

organization := "hr.element.etb"

name := "scala-transliteration"

version := "0.0.1"

unmanagedSourceDirectories in Compile := Seq((scalaSource in Compile).value)

unmanagedSourceDirectories in Test := Seq((scalaSource in Test).value)


// ### DEPENDENCIES ### //

libraryDependencies ++= Seq(
  "com.ibm.icu" % "icu4j" % "53.1"
, "org.scalatest" %% "scalatest" % "2.2.1" % "test"
, "junit" % "junit" % "4.11" % "test"
)

// ### RESOLVERS ### //

resolvers := Seq(ElementNexus)

externalResolvers := Resolver.withDefaultResolvers(resolvers.value, mavenCentral = false)

publishTo := Some(
  if (version.value endsWith "SNAPSHOT") ElementSnapshots else ElementReleases
)

credentials ++= {
  val creds = Path.userHome / ".config" / "scala-transliteration" / "nexus.config"
  if (creds.exists) Some(Credentials(creds)) else None
}.toSeq

publishArtifact in (Compile, packageDoc) := false


// ### COMPILE SETTINGS ### //

crossScalaVersions := Seq("2.11.2")

scalaVersion := crossScalaVersions.value.head

scalacOptions := Seq(
  "-deprecation"
, "-encoding", "UTF-8"
, "-feature"
, "-language:existentials"
, "-language:implicitConversions"
, "-language:postfixOps"
, "-language:reflectiveCalls"
, "-optimise"
, "-unchecked"
, "-Xcheckinit"
, "-Xlint"
, "-Xmax-classfile-name", "72"
, "-Xno-forwarders"
, "-Xverify"
, "-Yclosure-elim"
, "-Yconst-opt"
, "-Ydead-code"
, "-Yinline-warnings"
, "-Yinline"
, "-Yrepl-sync"
, "-Ywarn-adapted-args"
, "-Ywarn-dead-code"
, "-Ywarn-inaccessible"
, "-Ywarn-infer-any"
, "-Ywarn-nullary-override"
, "-Ywarn-nullary-unit"
, "-Ywarn-numeric-widen"
, "-Ywarn-unused"
)

javacOptions := Seq(
  "-deprecation"
, "-encoding", "UTF-8"
, "-source", "1.6"
, "-target", "1.6"
, "-Xlint:unchecked"
) ++ (sys.env.get("JDK16_HOME") match {
  case Some(jdk16Home) => Seq("-bootclasspath", jdk16Home + "/jre/lib/rt.jar")
  case _ => Nil
})

// ### ECLIPSE ### //

EclipseKeys.eclipseOutput := Some(".target")

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)
