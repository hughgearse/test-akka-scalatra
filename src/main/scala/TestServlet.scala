import akka.actor.ActorSystem
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}
import org.slf4j.LoggerFactory

class TestServlet extends HttpServlet {

	private val log = LoggerFactory.getLogger(classOf[TestServlet])

	val system = ActorSystem("test")

	override def init(): Unit = {
		log.debug("Created system: " + system.name)
	}

	override def doGet(req: HttpServletRequest, res: HttpServletResponse) = {
		res.setContentType("text/html")
		val pw = res.getWriter()
		pw.println("<html><body>")
		pw.println("Test Servlet")
		pw.println("</body></html>")
		pw.close()
	}

override def destroy(): Unit = {
		super.destroy()
		log.debug("Terminating")
		implicit val ec = system.dispatcher
		system.terminate().foreach { term =>
			log.debug("Terminated: " + term)
		}
	}
}
