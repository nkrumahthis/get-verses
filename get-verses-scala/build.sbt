import Dependencies._

ThisBuild / scalaVersion     := "2.13.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "getverses"

lazy val root = (project in file("."))
  .settings(
    name := "get-verses-scala",
    libraryDependencies += munit % Test,
    libraryDependencies += "com.lihaoyi" %% "upickle" % "3.3.1"
)

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
