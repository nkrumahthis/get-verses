package getverses

import ujson.Value

import scala.io.StdIn.readLine

class OneStepLocator(bibleObject: Value.Value) extends Locator(bibleObject) {
  def executor(): Unit = {
    val addressInput = readLine("Enter {book} {chapter}:{verse} > ")

    val pieces = addressInput.split(" ")

    if (pieces.length != 2 || !pieces(1).contains(":")) {
      println("format should be {book} {chapter}:{verse}. eg Genesis 1:1")
      return
    }

    val bookName = pieces(0)

    val chapterAndVerse = pieces(1).split(":")

    val chapterNumber = chapterAndVerse(0)
    val verseNumber = chapterAndVerse(1)
    if(chapterAndVerse.length != 2 || !chapterNumber.forall(_.isDigit) || !verseNumber.forall(_.isDigit)) {
      println("format should be {book} {chapter}:{verse}. eg Genesis 1:1")
      return
    }

    this.locate(bookName, chapterNumber, verseNumber) match {
      case Some(verse) => println(verse)
      case None => println(s"Verse not found at $bookName $chapterNumber:$verseNumber")
    }

  }
}
