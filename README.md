# Akka Patterns
Various actor patterns are useful for common scenarios. 
We can use various patterns to avoid problems such as mailbox message overflow etc.
<br><br>
- Branch out to explore master slave work pulling pattern
````
git checkout -b master_slave_work_pulling master
````
- Update the build.sbt file
````
name := "Patterns-Akka"

version := "1.0"

scalaVersion := "2.11.12"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.12"
````
- Create a file for Master Actor:<b>com.github.janikibichi.learnakka.patterns.MasterWorkPulling.scala</b>
- Create file for Worker Actor: <b>com.github.janikibichi.learnakka.patterns.WorkerWorkPulling.scala</b>
- Create generator actor for messages: <b>com.github.janikibichi.learnakka.patterns.GeneratorWorkPulling.scala</b>
- Create the app to test everything out: <b>com.github.janikibichi.learnakka.patterns.WorkPullingApp.scala</b>
- [Run the app:](https://asciinema.org/a/BNLknFXJHZVWekSqBsZzVbJHC)
````
sbt "runMain com.github.janikibichi.learnakka.patterns.WorkPullingApp"
````