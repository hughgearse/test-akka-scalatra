import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

class Test extends Actor {

	def receive = {
		case msg => println("Received: " + msg)
	}

}

object Test {

	val system = ActorSystem("test", ConfigFactory.load().getConfig("akka-test"))

	def main(args: Array[String]): Unit = {
		system.actorOf(Props(new Test)) ! "Hello"
		implicit val ec = system.dispatcher
		system.terminate().foreach { term =>
			println("Terminated")
		}
	}
}
