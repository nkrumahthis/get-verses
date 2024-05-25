package getverses

import ujson.Value
import scala.io.StdIn.readLine

class ThreeStepLocator(bibleObject: Value.Value) extends Locator(bibleObject) {
  def executor(): Unit = {
    println("Enter the book, chapter and verse to show")

    val bookInput = readLine("book > ")
    val chapterInput = readLine("chapter > ")
    val verseInput = readLine("verse > ")

    val verse = this.locate(bookInput, chapterInput, verseInput)
    println(verse)
  }

}
