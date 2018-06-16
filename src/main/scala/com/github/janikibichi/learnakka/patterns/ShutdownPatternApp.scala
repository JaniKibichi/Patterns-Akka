package com.github.janikibichi.learnakka.patterns

import akka.actor.{ActorSystem, PoisonPill, Props}
import scala.concurrent.duration._

object ShutdownPatternApp extends App{
  val actorSystem = ActorSystem()
  import actorSystem.dispatcher

  val reaper = actorSystem.actorOf(Props[Reaper],"reaper")
  val worker = actorSystem.actorOf(Props[ShutDownPatternWorker],"worker")
  val master = actorSystem.actorOf(Props[ShutDownPatternMaster],"master")

  actorSystem.scheduler.scheduleOnce(3 seconds, worker, PoisonPill)
  actorSystem.scheduler.scheduleOnce(5 seconds, master, PoisonPill)

}