package akka

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
  * Created by Om Prakash C on 20-06-2017.
  */
object HierarchyExample extends App {
  case object CreateChild
  case object SignalChild
  case object PrintSignal
  class ParentActor extends Actor {
    private var number = 0
    private val children = scala.collection.mutable.Buffer[ActorRef]()
    def receive = {
      case CreateChild =>
        children += context.actorOf(Props[ChildActor], "Child"+number)
        number += 1
      case SignalChild =>
        children.foreach(_ ! PrintSignal)
    }
  }
  class ChildActor extends Actor {
    def receive = {
      case PrintSignal => println(self)
    }
  }

  val system = ActorSystem("HierarchySystem")
  val actor = system.actorOf(Props[ParentActor], "Parent1")

  actor ! CreateChild
  actor ! SignalChild
  actor ! CreateChild
  actor ! CreateChild
  actor ! SignalChild

  system.terminate()
}
