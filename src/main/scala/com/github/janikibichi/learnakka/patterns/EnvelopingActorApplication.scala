package com.github.janikibichi.learnakka.patterns

import java.util.UUID
import akka.actor.{ActorSystem, Props}

object EnvelopingActorApplication extends App{
  val actorSystem = ActorSystem()

  val envelopReceived = actorSystem.actorOf(Props[EnvelopeReceiver], "receiver")
  val envelopingActor = actorSystem.actorOf(Props(classOf[EnvelopingActor], envelopReceived, headers _))

  envelopingActor ! "Hello!"

  def headers(msg: Any) = Map("t" -> System.currentTimeMillis(),"cId"-> UUID.randomUUID().toString)
}
