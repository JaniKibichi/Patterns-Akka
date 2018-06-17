package com.github.janikibichi.learnakka.patterns

import akka.actor.{Actor, ActorLogging}
import TrafficLightFSM.ReportChange

class FSMChangeSubscriber extends Actor with ActorLogging{
  def receive = {
    case ReportChange(s,d) =>
      log.info(s"Change detected to [$s] at [$d]")
  }
}
