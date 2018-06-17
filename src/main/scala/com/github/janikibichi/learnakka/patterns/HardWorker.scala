package com.github.janikibichi.learnakka.patterns

import akka.actor.{Actor, ActorLogging}
import com.github.janikibichi.learnakka.patterns.PausableActor.{Ready, Work}

import scala.util.Random

class HardWorker extends Actor with ActorLogging{
  def receive = {
    case Work(id) =>
      Thread.sleep(Random.nextInt(3)*1000)
      log.info(s"Work [$id] finished.")
      sender ! Ready
  }
}
