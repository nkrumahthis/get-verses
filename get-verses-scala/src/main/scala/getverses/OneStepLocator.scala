package getverses

import ujson.Value

import scala.io.StdIn.readLine

class OneStepLocator(bibleObject: Value.Value) extends Locator(bibleObject) {
  def executor(): Unit = {
    println("Enter book chapter:verse")

    val addressInput = readLine("address > ")

    val pieces = addressInput.split(" ")
    val bookName = pieces(0)
    val chapterNumber = pieces(1).split(":")(0)
    val verseNumber = pieces(1).split(":")(1)

    val verse = this.locate(bookName, chapterNumber, verseNumber)

    println(verse)

  }
}
