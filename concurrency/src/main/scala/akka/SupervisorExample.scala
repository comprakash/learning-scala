package akka

import akka.actor.SupervisorStrategy.{Restart, Resume, Stop}
import akka.actor.{Actor, ActorSystem, OneForOneStrategy, Props}

/**
  * Created by Om Prakash C on 20-06-2017.
  */
object SupervisorExample extends App {
  case object CreateChild
  case class SignalChild(order: Int)
  case class PrintSignal(order: Int)
  case class DivideNumbers(n: Int, d: Int)
  case object BadStuff
  class ParentActor extends Actor {
    private var number = 0
    def receive = {
      case CreateChild =>
        context.actorOf(Props[ChildActor], "Child"+number)
        number += 1
      case SignalChild(n) =>
        context.children.foreach(_ ! PrintSignal(n))
    }
    override val supervisorStrategy = OneForOneStrategy(loggingEnabled = false) {
      case ae: ArithmeticException => Resume
      case ex: Exception => Restart
    }
  }
  class ChildActor extends Actor {
    println("Child Created")
    def receive = {
      case PrintSignal(n) => println(n + " " + self)
      case DivideNumbers(n, d) => println(n/d)
      case BadStuff => throw new RuntimeException("Bad Stuff happened")
    }

    override def preStart(): Unit = {
      super.preStart()
      println("Child Pre Start")
    }

    override def postStop(): Unit = {
      super.postStop()
      println("Child Post Stop")
    }

    override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
      super.preRestart(reason, message)
      println("Child Pre Restart")
    }

    override def postRestart(reason: Throwable): Unit = {
      super.postRestart(reason)
      println("Child Post Restart")
    }
  }

  val system = ActorSystem("HierarchySystem")
  val actor = system.actorOf(Props[ParentActor], "Parent1")
  val actor2 = system.actorOf(Props[ParentActor], "Parent2")

  actor ! CreateChild
  //actor ! CreateChild
  val child0 = system.actorSelection("/user/Parent1/Child0")
  child0 ! DivideNumbers(4, 0)
  child0 ! DivideNumbers(4, 2)
  child0 ! BadStuff

  Thread.sleep(2000)
  system.terminate()
}
