package com.github.janikibichi.learnakka.patterns

import akka.actor.{ActorSystem, Props}
import scala.concurrent.Await
import scala.concurrent.duration._


object OrderedTerminationApp extends App {
  val actorSystem = ActorSystem()
  val orderedKiller = actorSystem.actorOf(Props[ServiceHandlersCreator],"serviceHandlersCreator")

  val manager = actorSystem.actorOf(Props(classOf[ServicesManager],orderedKiller),"servicesManager")

  Thread.sleep(2000)
  actorSystem.stop(manager)
  Await.ready(actorSystem.terminate(), 2.seconds)
}
