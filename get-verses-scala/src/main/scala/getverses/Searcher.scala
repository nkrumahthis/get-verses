package getverses

import ujson.Value

import scala.io.StdIn.readLine

class Searcher(bibleObject: Value.Value) {
  def search(term: String): Option[Array[String]] = {
    Some(Array("scripture 1", "scripture 2"))
  }

  def executor() = {
    val addressInput = readLine("Enter search term > ")
    this.search(addressInput)
  }
}
