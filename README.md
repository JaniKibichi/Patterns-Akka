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
<br><br>
- Branch out to explore shutdown patterns in akka
````
git checkout -b shutdown_patterns ordered_actor_termination
````
- Create a file to register actors in a set: <b>com.github.janikibichi.learnakka.patterns.Reaper.scala</b>
- Create a file to register actors in a set: <b>com.github.janikibichi.learnakka.patterns.ReaperAwareActor.scala</b>
- Create actor that simulates working: <b>com.github.janikibichi.learnakka.patterns.ShutdownPatternWorker.scala</b>
- Create a master actor to create child actors:<b>com.github.janikibichi.learnakka.patterns.ShutDownPatternMaster.scala</b>
- Create file to test shutdown actor:<b>com.github.janikibichi.learnakka.patterns.ShutdownPatternApp.scala</b>
- [Run the app]()
````
sbt "runMain com.github.janikibichi.learnakka.patterns.ShutdownPatternApp"
````
<br><br>
- Branch out to explore scheduling periodic messages to actors
````
git checkout -b periodic_messages_to_actors shutdown_patterns
````
- Add the Akka stream scheduler dependency:
````
libraryDependencies += "com.enragedginger" %% "akka-quartz-scheduler" % "1.6.0-akka-2.4.x"
````
- Create actor with scheduler:<b>com.github.janikibichi.learnakka.patterns.MessageAkkaScheduler.scala</b>
- Create actor using quartz scheduler:<b>com.github.janikibichi.learnakka.patterns.MessageQuartzScheduler.scala</b>
- Create the app to run the code:<b>com.github.janikibichi.learnakka.patterns.SchedulingMessagesApp.scala</b>
- [Run the app]()
````
sbt "runMain com.github.janikibichi.learnakka.patterns.SchedulingMessageApp"
````
<br><br>
- Branch out to explore throttling messages to actors
````
git checkout -b throttling_messages_to_actors periodic_messages_to_actors
````
- Add the dependency to build.sbt
````
libraryDependencies += "com.typesafe.akka" %% "akka-contrib" % "2.4.4"
````
- Create receiver actor:<b>com.github.janikibichi.learnakka.patterns.EasyToOverWhelm.scala</b>
- Actor to send messages we want to throttle:<b>com.github.janikibichi.learnakka.patterns.ReallyFastSender.scala</b>
- Create the app to throttle: <b>com.github.janikibichi.learnakka.patterns.ThrottlingApp.scala</b>
- [Run the App to see throttling:]()
````
sbt "runMain com.github.janikibichi.learnakka.patterns.ThrottlingApp"
````
<br><br>
- Branch out to explore balancing workload across actors
````
git checkout -b balance_workload_across_actors throttling_messages_to_actors
````
- Create a file: <b>com.github.janikibichi.learnakka.patterns.BalancedWorker.scala</b>
- Create the balancing work app:<b>com.github.janikibichi.learnakka.patterns.BalancingWorkApp.scala</b>
- Run the app with the BalancingDispatcher 
````
sbt "runMain com.github.janikibichi.learnakka.patterns.BalancingDispatcherApp"
````
- [Run the app with the SmallestMailbox]() 
````
sbt "runMain com.github.janikibichi.learnakka.patterns.SmallestMailboxRouterApp"
````
<br><br>
- Branch out to explore the aggregator pattern
````
git checkout -b aggregator_pattern balance_workload_across_actors
````
- Create file:<b>com.github.janikibichi.learnakka.patterns.SocialMediaHandler.scala<b/>
- Create file:<b>com.github.janikibichi.learnakka.patterns.SocialMediaAggregator.scala</b>
- Create file:<b>com.github.janikibichi.learnakka.patterns.SocialMediaStalker.scala</b>
- Create file:<b>com.github.janikibichi.learnakka.patterns.AggregatorPatternApp.scala</b>
- Run the [aggregator pattern app]()
````
sbt "runMain com.github.janikibichi.learnakka.patterns.AggregatorPatternApp"
````
<br><br>
- Branch out to explore CountDownLatch pattern
````
git checkout -b countdownlatch_pattern aggregator_pattern
````
- Create file <b>com.github.janikibichi.learnakka.patterns.CountDownLatch.scala</b>
- Create processing actor file: <b>com.github.janikibichi.learnakka.patterns.CountDownLatchWorker.scala</b>
- Create App to run the pattern:<b>com.github.janikibichi.learnakka.patterns.CountDownLatchApp.scala</b>
- [Run the app:]()
````
sbt "runMain com.github.janikibichi.learnakka.patterns.CountDownLatchApp"
````
<br><br>
- Branch out to explore the finite state machine
````
git checkout -b finite_state_machine countdownlatch_pattern
````
- Create the file: <b>com.github.janikibichi.learnakka.patterns.FSMChangeSubscriber.scala</b>
- Create model classes file: <b>com.github.janikibichi.learnakka.patterns.TrafficLightsFSM.scala</b>
- Create file:<b>com.github.janikibichi.learnakka.patterns.FSMApp.scala</b>
- [Run the App:]()
````
sbt "runMain com.github.janikibichi.learnakka.patterns.FSMApp"
````


