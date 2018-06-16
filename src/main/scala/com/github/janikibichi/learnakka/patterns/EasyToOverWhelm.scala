package com.github.janikibichi.learnakka.patterns

import akka.actor.{Actor, ActorLogging}

class EasyToOverWhelmReceiver extends Actor with ActorLogging{
  def receive = {
    case x =>
      log.info(s"received $x")
  }
}
