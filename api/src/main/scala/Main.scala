import zio._
import zio.http._
import zio.json._
import scala.io.Source

import service.LocatorService

object Main extends ZIOAppDefault {

  private val homeRoute = Method.GET / Root -> handler(Response.text("get-verses:0.0.0"))

  private val versesRoute = Method.GET / "verses" -> handler(Response.json(LocatorService("genesis", "1", "1").text))

  private val app = Routes(homeRoute, versesRoute)

  val run = Server.serve(app).provide(
    Server.defaultWithPort(8088)
  )

  // def run: ZIO[Environment with ZIOAppArgs with Scope, Throwable, Any] = 

}

// object Locator {
//   def apply(bookName: String, chapterNumber: String, verseNumber: String): Option[String] = {
//     Some("a bible verse")
//     val filename = "data/en_bbe.json"

//     val fileSource = Source.fromFile(filename)
//     val bibleString = fileSource.mkString.replace("﻿", "")
//     fileSource.close()

//     val parsedJson = bibleString.fromJson[Json]

//     parsedJson match {
//       case Left(error) => None
//       case Right(json) => 
//         val books 
//     }

//     // val parsedJson = json.read(bibleString).arr.find(book => book("name").str.equalsIgnoreCase(bookName)
//       // || book("abbrev").str.equalsIgnoreCase(bookName)) 

//     // foundBook match {
//     //   case Some(book) =>
//     //     val chapters = book("chapters").arr
//     //     if (chapters.isDefinedAt(chapterNumber.toInt - 1)) {
//     //       val verses = chapters(chapterNumber.toInt - 1).arr
//     //       if (verses.isDefinedAt(verseNumber.toInt - 1)) {
//     //         Some(verses(verseNumber.toInt - 1).str)
//     //       } else {
//     //         None
//     //       }
//     //     } else {
//     //       None
//     //     }
//     // }
//   }
    
// }