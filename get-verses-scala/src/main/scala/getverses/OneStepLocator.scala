package getverses

import ujson.Value

import scala.io.StdIn.readLine

class OneStepLocator(bibleObject: Value.Value) extends Locator(bibleObject) {
  def executor(): Unit = {
    println("Enter {book} {chapter}:{verse}")

    val addressInput = readLine("address > ")

    val pieces = addressInput.split(" ")

    if (pieces.length != 2) {
      println("format should be {book} {chapter}:{verse}")
      return
    }

    val bookName = pieces(0)

    val numbers = pieces(1).split(":")

    if(numbers.length != 2) {
      println("format should be {book} {chapter}:{verse}")
      return
    }
    val verse = this.locate(bookName, numbers(0), numbers(1))

    println(verse)
  }
}
