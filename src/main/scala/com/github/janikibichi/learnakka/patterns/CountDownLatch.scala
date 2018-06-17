package com.github.janikibichi.learnakka.patterns

import akka.Done
import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}
import com.github.janikibichi.learnakka.patterns.CountDownLatch.CountDown
import scala.concurrent.duration._
import scala.concurrent.{Await, Future, Promise}

object CountDownLatch{
  case object CountDown
  def apply(count: Int)(implicit actorSystem: ActorSystem) ={
    val promise = Promise[Done]()
    val props = Props(classOf[CountDownLatchActor], count, promise)
    val countDownLatchActor = actorSystem.actorOf(props,"countDownLatchActor")
    new CountDownLatch(countDownLatchActor, promise)
  }
}

class CountDownLatch(private val actor: ActorRef, private val promise: Promise[Done]){
  def countDown() = actor ! CountDown
  def await(): Unit = Await.result(promise.future, 10 minutes)
  val result: Future[Done] = promise.future
}

class CountDownLatchActor(count: Int, promise: Promise[Done]) extends Actor with ActorLogging {
  var remaining = count
  def receive = {
    case CountDown if remaining -1 == 0 =>
      log.info("Counting down")
      promise.success(Done)
      log.info("Gate opened")
      context.stop(self)

    case CountDown =>
      log.info("Counting down")
      remaining -= 1
  }
}

