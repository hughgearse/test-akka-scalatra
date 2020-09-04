ThisBuild / scalaVersion := "2.12.12"

val AkkaVersion = "2.6.8"
val ScalatraVersion = "2.7.0"

lazy val test = (project in file("."))
	.settings(
		name := "Test",
		libraryDependencies ++= Seq(
			"ch.qos.logback" % "logback-classic" % "1.1.3",
			"org.slf4j" % "log4j-over-slf4j" % "1.7.6",
			"com.typesafe.akka" %% "akka-actor" % AkkaVersion,
			"com.typesafe.akka" %% "akka-actor" % AkkaVersion,
			"com.typesafe.akka" %% "akka-remote" % AkkaVersion,
			"com.typesafe.akka" %% "akka-cluster" % AkkaVersion,
			"com.typesafe.akka" %% "akka-serialization-jackson" % AkkaVersion,
			"com.typesafe.akka" %% "akka-slf4j" % AkkaVersion,
			"com.fasterxml.jackson.core" % "jackson-databind" % "2.8.4",
			"com.typesafe" % "config" % "1.3.2",
			"org.scalatra" %% "scalatra" % ScalatraVersion,
			"javax.servlet" % "javax.servlet-api" % "3.1.0",
		)
	).enablePlugins(ScalatraPlugin)
