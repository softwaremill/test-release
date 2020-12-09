lazy val commonSettings = commonSmlBuildSettings ++ ossPublishSettings ++ Seq(
  organization := "com.softwaremill.testrelease"
)

val scalaTest = "org.scalatest" %% "scalatest" % "3.2.3" % "test"

lazy val rootProject = (project in file("."))
  .settings(commonSettings: _*)
  .settings(scalaVersion := "2.12.6", publishArtifact := false, name := "root")
  .aggregate(core.projectRefs: _*)

lazy val core = (projectMatrix in file("core"))
  .settings(commonSettings: _*)
  .settings(
    name := "core",
    libraryDependencies ++= Seq(
      scalaTest
    )
  )
  .jvmPlatform(scalaVersions = Seq("2.13.3", "2.12.12"))
