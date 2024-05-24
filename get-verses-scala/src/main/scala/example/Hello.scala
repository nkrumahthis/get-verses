package example

import scala.io.Source

object Hello extends Greeting with App {
  println(greeting)
  val filename = "data/en_bbe.json"
  val filesource = Source.fromFile(filename)
  val bibleString = filesource.mkString("")
  println(bibleString)
  filesource.close()
}

trait Greeting {
  lazy val greeting: String = "hello world"
}
