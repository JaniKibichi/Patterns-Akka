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
<br><br>
- Branch out to explore ordered termination of Actors
````
git checkout -b ordered_actor_termination master_slave_work_pulling
````
- Create a Service handling file: <b>com.github.janikibichi.learnakka.patterns.ServiceHandler.scala</b>
- Create the services manager: <b>com.github.janikibichi.learnakka.patterns.ServiceManager.scala</b>
- Create the Ordered Killer Class:<b>com.github.janikibichi.learnakka.patterns.OrderedKiller.scala</b>
- Create actor for creating children actors:<b>com.github.janikibichi.learnakka.patterns.ServiceHandlersCreator.scala</b>
- Create app to test pattern:<b>com.github.janikibichi.learnakka.patterns.OrderedTerminatedApp.scala</b>
- [Run the ordered termination app](https://asciinema.org/a/zloc8j8kZzm9lGnIOhvv5RB7g)
````
sbt "runMain com.github.janikibichi.learnakka.patterns.OrderedTerminationApp"
````