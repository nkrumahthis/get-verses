package service

import model.Verse

object LocatorService:
    def apply(book: String, chapter: String, verse: String): Verse = Verse("in the beginning was the word")
