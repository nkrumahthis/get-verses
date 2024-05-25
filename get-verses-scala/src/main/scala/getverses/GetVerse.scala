package getverses

import scala.io.Source
import scala.io.StdIn.readLine

object GetVerse extends App {
  val filename = "data/en_bbe.json"
  val fileSource = Source.fromFile(filename)
  val bibleString = fileSource.mkString.replace("﻿", "")
  val bibleObject = ujson.read(bibleString)

  println("Enter the book, chapter and verse to show")

  private val bookInput = readLine("book > ")
  private val chapterInput = readLine("chapter > ")
  private val verseInput = readLine("verse > ")

  bibleObject.arr.find(book => book("name").str == bookInput) match {
    case Some(book) =>
      val verse = book("chapters").arr(chapterInput.toInt - 1)(verseInput.toInt - 1)
      println(verse)
    case None => println(s"Book $bookInput not found")
  }

  fileSource.close()
}
