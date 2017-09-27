package multithreading

class ThreadExampleRunnable extends Runnable {
  override def run() {
    println("Thread is running...")
  }
}

object RunnableObject {
  def main(args: Array[String]) {
    val e: ThreadExample = new ThreadExample()
    val t: Thread = new Thread(e)
    t.start()
  }
}