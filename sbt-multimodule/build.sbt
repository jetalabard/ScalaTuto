import sbt.Keys.libraryDependencies

val Slf4jVersion = "1.7.7"

resolvers += Classpaths.typesafeReleases


lazy val commonSettings = Seq(
  organization := "com.m2i",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.11.11"
)

lazy val root = Project("m2i-multi-module", sbt.file("m2i-multi-module"))
  .aggregate(moduleA, moduleB)
  .settings(
    name := "m2i-multi-module",
    commonSettings
  )


lazy val moduleA = Project("moduleA", sbt.file("moduleA"))
  .settings(
    commonSettings,
    libraryDependencies += "org.slf4j" % "slf4j-api" % Slf4jVersion,
    libraryDependencies += "org.slf4j" % "slf4j-simple" % Slf4jVersion,
    libraryDependencies += "joda-time" % "joda-time" % "2.9.9",
    libraryDependencies += "com.github.scopt" %% "scopt" % "3.7.0"
  )

lazy val moduleB = Project("moduleB", sbt.file("moduleB"))
  .dependsOn(moduleA)
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-api" % Slf4jVersion,
      "org.slf4j" % "slf4j-simple" % Slf4jVersion
    )
  )


