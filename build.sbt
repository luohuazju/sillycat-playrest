name := """sillycat-playrest"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  "mysql" % "mysql-connector-java" % "5.1.18",
  "commons-dbutils" % "commons-dbutils" % "1.6",
  "org.flywaydb" % "flyway-core" % "3.2.1"
  //javaEbean,
  //cache,
  //javaWs
)
