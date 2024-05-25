package getverses

import scala.io.Source

object GetVerse extends App {
  val filename = "data/en_bbe.json"
  val fileSource = Source.fromFile(filename)
  val bibleString = fileSource.mkString.replace("﻿", "")
  val bibleObject = ujson.read(bibleString)
  bibleObject.arr.foreach(book => {
    if(book("name").str == "Genesis") {
      val verse = book("chapters").arr(0)(1)
      println(verse)
    }
  })

  fileSource.close()
}
