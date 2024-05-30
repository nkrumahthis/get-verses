package getverses

import scala.io.Source
import scala.io.StdIn.readLine
import getverses.ThreeStepLocator

object GetVerse extends App {
  private val filename = "data/en_bbe.json"

  private val fileSource = Source.fromFile(filename)
  private val bibleString = fileSource.mkString.replace("﻿", "")
  fileSource.close()

  private val bibleObject = ujson.read(bibleString)

  while (true) {
    println(
      """
        |Welcome to Get-Verse
        | [1] 1 step quote finder
        | [2] 3 step quote finder
        | [3] search for verses
        |""".stripMargin)
    val mode = readLine("> ")

    mode match {
      case "1" =>
        println("you chose 1 step quote finder")
        val locator = new OneStepLocator(bibleObject)
        locator.executor()
      case "2" =>
        println("you chose 3 step quote finder")
        val locator = new ThreeStepLocator(bibleObject)
        locator.executor()
      case "3" =>
        println("you chose to search for verses")
    }
  }
}
