import Dependencies._

ThisBuild / scalaVersion     := "2.12.14"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.comprakash.programming.scala"
ThisBuild / organizationName := "programming-in-scala"

lazy val root = (project in file("."))
  .settings(
    name := "programming-in-scala",
    libraryDependencies += scalaTest % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
