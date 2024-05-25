package getverses

import ujson.Value

import scala.io.StdIn.readLine

class OneStepLocator(bibleObject: Value.Value) {
  def executor(): Unit = {
    println("Enter book chapter:verse")

    val addressInput = readLine("address > ")

    val pieces = addressInput.split(" ")
    val bookName = pieces(0)
    val chapterNumber = pieces(1).split(":")(0)
    val verseNumber = pieces(1).split(":")(1)

    bibleObject.arr.find(book => book("name").str.toUpperCase == bookName.toUpperCase) match {
      case Some(book) =>
        val verse = book("chapters").arr(chapterNumber.toInt - 1)(verseNumber.toInt - 1).str
        println(verse)
    }

  }
}
