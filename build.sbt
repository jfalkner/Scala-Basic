name := "Scala Bootstrap"

version in ThisBuild := "0.0.1"

organization in ThisBuild := "falkner.jayson"

scalaVersion in ThisBuild := "2.11.8"

scalacOptions in ThisBuild := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature", "-language:postfixOps")

fork in ThisBuild := true

// passed to JVM. See http://docs.oracle.com/javase/7/docs/technotes/tools/solaris/java.html
javaOptions in ThisBuild += "-Xms256m"
javaOptions in ThisBuild += "-Xmx2g"

// `sbt pack` to make all JARs for a deploy. see https://github.com/xerial/sbt-pack
packSettings

// `sbt run` will run this class
mainClass in (Compile, run) := Some("falkner.jayson.bootstrap.Main")

// allow code coverage via - https://github.com/scoverage/sbt-scoverage
//coverageEnabled := true
coverageExcludedPackages := "<empty>;.*ClassToExclude.scala" // exclude Main entry point

// import maven hosted libraries
libraryDependencies ++= Seq(
  "org.specs2" % "specs2_2.11" % "2.4.1-scalaz-7.0.6" % "test"
)

// import projects hosted in git as dependencies 
//lazy val basic_example  = (project in file(".")).dependsOn(cc2csv, file_monitor)
//lazy val cc2csv = RootProject(uri("https://github.com/jfalkner/cc2csv.git#v0.0.4"))
//lazy val file_monitor = RootProject(uri("https://github.com/jfalkner/file_monitor.git#v0.0.5"))
