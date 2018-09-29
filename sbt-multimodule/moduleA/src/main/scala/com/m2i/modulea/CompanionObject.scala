package com.m2i.modulea

object CompanionObject extends  App {

  val a = new GeoPoint(3,4) //passe par la classe
  val b = GeoPoint(5)
  val c = GeoPoint(3,4) //passe par le apply du companion object
  val d = GeoPoint()
}
