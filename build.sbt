name := "Houtu"

version := "0.1"

scalaVersion := "2.11.4"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

libraryDependencies ++= Seq( 
    "org.scalatest" % "scalatest_2.11" % "2.2.0" % "test",
    "org.scalacheck" %% "scalacheck" % "1.11.4" % "test",
    "com.sksamuel.scrimage" %% "scrimage-core" % "1.4.2",
    "org.slf4j" % "slf4j-nop" % "1.6.4",
    "org.scala-lang" % "scala-swing" % "2.11.0-M7"
)
