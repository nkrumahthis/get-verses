package getverses

import ujson.Value
import scala.io.StdIn.readLine

class ThreeStepLocator(bibleObject: Value.Value) {
  def executor(): Unit = {
    println("Enter the book, chapter and verse to show")

    val bookInput = readLine("book > ")
    val chapterInput = readLine("chapter > ")
    val verseInput = readLine("verse > ")

    bibleObject.arr.find(book => book("name").str.toUpperCase == bookInput.toUpperCase) match {
      case Some(book) =>
        val verse = book("chapters").arr(chapterInput.toInt - 1)(verseInput.toInt - 1).str
        println(verse)
      case None => println(s"Book $bookInput not found")
    }
  }

}
