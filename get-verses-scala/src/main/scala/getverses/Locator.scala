package getverses

import ujson.Value

class Locator(bibleObject: Value.Value) {
  def locate(bookName: String, chapterNumber: String, verseNumber: String): Option[String] = {
    bibleObject.arr.find(book => book("name").str.toUpperCase == bookName.toUpperCase) match {
      case Some(book) =>
        Some(book("chapters").arr(chapterNumber.toInt - 1)(verseNumber.toInt - 1).str)
      case None => None
    }
  }
}
