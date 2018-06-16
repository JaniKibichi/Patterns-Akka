package com.github.janikibichi.learnakka.patterns

import akka.actor.Actor
import com.github.janikibichi.learnakka.patterns.Reaper.WatchMe

trait ReaperAwareActor extends Actor {
  override final def preStart() = {
    registerReaper()
    preStartPostRegistration()
  }

  private def registerReaper() = context.actorSelection("/user/Reaper") ! WatchMe(self)

  def preStartPostRegistration() : Unit = ()
}
