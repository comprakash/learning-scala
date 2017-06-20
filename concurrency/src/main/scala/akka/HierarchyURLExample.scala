package akka

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by Om Prakash C on 20-06-2017.
  */
object HierarchyURLExample extends App {
  case object CreateChild
  case object SignalChild
  case object PrintSignal
  class ParentActor extends Actor {
    private var number = 0
    def receive = {
      case CreateChild =>
        context.actorOf(Props[ChildActor], "Child"+number)
        number += 1
      case SignalChild =>
        context.children.foreach(_ ! PrintSignal)
    }
  }
  class ChildActor extends Actor {
    def receive = {
      case PrintSignal => println(self)
    }
  }

  val system = ActorSystem("HierarchySystem")
  val actor = system.actorOf(Props[ParentActor], "Parent1")
  val actor2 = system.actorOf(Props[ParentActor], "Parent2")

  actor ! CreateChild
  actor ! SignalChild
  actor ! CreateChild
  actor ! CreateChild
  actor ! SignalChild

  actor2 ! CreateChild
  val child0 = system.actorSelection("akka://HierarchySystem/user/Parent2/Child0")
  child0 ! PrintSignal

  val child2 = system.actorSelection("/user/Parent1/Child2")
  child2 ! PrintSignal

  Thread.sleep(1000)
  system.terminate()
}
