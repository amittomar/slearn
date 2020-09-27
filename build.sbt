import Dependencies._
import sbt.Keys.libraryDependencies

ThisBuild / scalaVersion     := "2.12.10"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
  Seq(
    name := "slearn",
    libraryDependencies += Seq(
      scalaTest % Test,
      "junit" % "junit" % "4.11" % Test,
      crossPaths := false,
      "com.novocode" % "junit-interface" % "0.11" % Test
    )
  ): _*
)

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
