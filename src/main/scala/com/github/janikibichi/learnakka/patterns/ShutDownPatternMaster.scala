package com.github.janikibichi.learnakka.patterns

import akka.actor.{Actor, ActorLogging, Props}
import scala.concurrent.duration._


class ShutDownPatternMaster extends ReaperAwareActor with ActorLogging{
  import context.dispatcher
  val receive = Actor.emptyBehavior
  override def postStop() = log.info(s"${self.path.name} has stopped")

  override def preStartPostRegistration() = {
    val worker1 = context.actorOf(Props[ShutDownPatternWorker],"worker1")
    context.actorOf(Props[ShutDownPatternWorker],"worker2")

    context.system.scheduler.scheduleOnce(2 seconds, worker1, new Exception("Something went wrong"))
    log.info(s"${self.path.name} is running")
  }
}