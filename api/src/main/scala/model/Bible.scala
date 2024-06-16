package model

import zio.json._

case class Verse (text: String)
object Verse:
    implicit val decoder: JsonDecoder[Verse] = DeriveJsonDecoder.gen[Verse]
    implicit val encoder: JsonEncoder[Verse] = DeriveJsonEncoder.gen[Verse]

case class Chapter (verses: List[Verse])
object Chapter:
    implicit val decoder: JsonDecoder[Chapter] = DeriveJsonDecoder.gen[Chapter]
    implicit val encoder: JsonEncoder[Chapter] = DeriveJsonEncoder.gen[Chapter]

case class Book (abbrev: String, name: String, chapters: List[Chapter])
object Book:
    implicit val decoder: JsonDecoder[Book] = DeriveJsonDecoder.gen[Book]
    implicit val encoder: JsonEncoder[Book] = DeriveJsonEncoder.gen[Book]

case class Bible (books: List[Book])
object Bible:
    given JsonEncoder[Bible] = DeriveJsonEncoder.gen[Bible]
    given JsonDecoder[Bible] = DeriveJsonDecoder.gen[Bible]

