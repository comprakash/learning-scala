package akka

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.util.Timeout
import akka.pattern._

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
  * Created by Om Prakash C on 16-06-2017.
  */
object AskPattern extends App {
  case object AskName
  case class NameResponse(name: String)
  case class AskNameOf(other: ActorRef)
  class AskActor(name: String) extends Actor {
    implicit val timeout: Timeout = 5.seconds
    implicit val ec = context.system.dispatcher
    def receive: PartialFunction[Any, Unit] = {
      case AskName => sender ! NameResponse(name)
      case AskNameOf(other) =>
        val f = other ? AskName
        f.onComplete{
          case Success(NameResponse(n)) =>
            println("They said their name was " + n)
          case Success(n) =>
            println("They didn't tell their name")
          case Failure(ex) =>
            println("Asking their name failed")
        }
        val currentSender = sender
        Future {
          currentSender ! "message"
        }
    }
  }

  val system = ActorSystem("SimpleSystem")
  val actor = system.actorOf(Props(new AskActor("Pat")), "AskActor1")
  val actor2 = system.actorOf(Props(new AskActor("Val")), "AskActor2")

  implicit val timeout = Timeout(1.seconds)

  val answer = actor ? AskName

  answer.foreach(name => println("Name = " + name))

  actor ! AskNameOf(actor2)
  system.terminate()
}
