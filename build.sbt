name := "ComputationalMathematicsLab5"

version := "0.1"

scalaVersion := "2.12.0"

mainClass in (Compile, run) := Some("src.main.prog.Main")

libraryDependencies += "com.github.wookietreiber" % "scala-chart_2.12" % "0.5.1"
libraryDependencies += "au.com.dius.pact.provider" % "junit" % "4.2.5"