package multithreading

class ThreadExample extends Thread {
  override def run() {
    println("Thread is running?")
  }
}

object MainObject {
  def main(args: Array[String]) {
    val t: ThreadExample = new ThreadExample()
    t.start()
  }
}