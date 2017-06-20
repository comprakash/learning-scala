package akka

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by Om Prakash C on 16-06-2017.
  */
object SimpleActorExample extends App {
  class SimpleActor extends Actor {
    def receive = {
      case s: String => println("String = " + s)
      case i: Int => println("Int = " + i)
    }
  }

  val system = ActorSystem("SimpleSystem")
  val actor = system.actorOf(Props[SimpleActor], "SimpleActor1")

  actor ! "Hi there"
  actor ! 24

  system.terminate()
}
