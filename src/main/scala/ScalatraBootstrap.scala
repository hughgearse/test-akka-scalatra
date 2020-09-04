import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import org.scalatra.LifeCycle
import javax.servlet.ServletContext
import org.slf4j.LoggerFactory

class ScalatraBootstrap extends LifeCycle {

	private val log = LoggerFactory.getLogger(classOf[ScalatraBootstrap])

	val system = ActorSystem("test")

	override def init(context: ServletContext) {
	}

	override def destroy(context:ServletContext): Unit = {
		log.debug("Terminating")
		implicit val ec = system.dispatcher
		system.terminate().foreach { term =>
			log.debug("Terminated: " + term)
		}
	}
}
