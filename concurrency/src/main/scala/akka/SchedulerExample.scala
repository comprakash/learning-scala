package akka

import akka.actor.{Actor, ActorSystem, Props}
import scala.concurrent.duration._

/**
  * Created by Om Prakash C on 20-06-2017.
  */
object SchedulerExample extends App {
  case object Count

  class SchedulerActor extends Actor {
    var n = 0
    def receive = {
      case Count =>
        n += 1
        println(n)
    }
  }

  val system = ActorSystem("SimpleSystem")
  val actor = system.actorOf(Props[SchedulerActor], "SimpleActor1")
  implicit val ec = system.dispatcher

  actor ! Count

  system.scheduler.scheduleOnce(1.seconds)(actor ! Count)

  val can = system.scheduler.schedule(0.seconds, 100.millis)(actor ! Count)

  Thread.sleep(2000)
  can.cancel()
  system.terminate()
}
