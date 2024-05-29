package getverses

import ujson.Value

class Locator(bibleObject: Value.Value) {
  def locate(bookName: String, chapterNumber: String, verseNumber: String): Option[String] = {
    bibleObject.arr.find(book => book("name").str.toUpperCase == bookName.toUpperCase) match {
      case Some(book) =>
        val chapters = book("chapters").arr
        if(chapters.isDefinedAt(chapterNumber.toInt - 1)) {
          val verses = chapters(chapterNumber.toInt - 1).arr
          if(verses.isDefinedAt(verseNumber.toInt - 1)) {
            Some(verses(verseNumber.toInt - 1).str)
          } else {
            None
          }
        } else {
          None
        }
      case None => None
    }
  }
}
