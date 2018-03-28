organization := "hr.element.etb"
name := "scala-transliteration"
//version := "0.0.1" see version.sbt
description := "Transliteration & sanitization for Scala"
homepage := Some(url(s"https://github.com/raisercostin/"+name.value))

crossScalaVersions := Seq("2.11.12", "2.10.7", "2.12.5")
scalaVersion := crossScalaVersions.value.head

unmanagedSourceDirectories in Compile := Seq((scalaSource in Compile).value)

unmanagedSourceDirectories in Test := Seq((scalaSource in Test).value)



libraryDependencies ++= Seq(
  "com.ibm.icu" % "icu4j" % "53.1"
, "org.scalatest" %% "scalatest" % "3.0.5" % "test"
, "junit" % "junit" % "4.11" % "test"
)



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
//, "-Yclosure-elim" - not in 2.12
//, "-Yconst-opt" - not in 2.10
//, "-Ydead-code" - not in 2.12
//, "-Yinline-warnings" - not in 2.12
//, "-Yinline"
, "-Yrepl-sync"
, "-Ywarn-adapted-args"
, "-Ywarn-dead-code"
, "-Ywarn-inaccessible"
//, "-Ywarn-infer-any" - not in 2.10
, "-Ywarn-nullary-override"
, "-Ywarn-nullary-unit"
, "-Ywarn-numeric-widen"
//, "-Ywarn-unused" - not in 2.10
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


licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))

//eclipse
EclipseKeys.eclipseOutput := Some(".target")
EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)

//bintray
publishMavenStyle := true
bintrayPackageLabels := Seq("scala", "i18n", "transliteration", "icu", "sbt")

//release plugin
//version is commented since the version is in version.sbt
releaseCrossBuild := true

//bintray&release
//bintray doesn't like snapshot versions - https://github.com/softprops/bintray-sbt/issues/12
releaseNextVersion := { ver => sbtrelease.Version(ver).map(_.bumpMinor.string).getOrElse(sbtrelease.versionFormatError) }
