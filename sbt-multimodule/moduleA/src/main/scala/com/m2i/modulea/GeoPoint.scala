package com.m2i.modulea

class GeoPoint(var x:Double = 0,var y:Double = 0) { // constructeur var implique public


  def change(xc:Double,yc:Double): Unit ={
    x = x + xc
    y = y + yc
  }

}


case class GeoPoint2(x:Double = 0,y:Double = 0) { // constructeur case classe attribut publique par défaut



}


object GeoPoint{
  def apply(): GeoPoint = new GeoPoint(0,0)
  def apply(x:Int):GeoPoint = new GeoPoint(x,x)
  def apply(x:Int,y:Int):GeoPoint = {
    println("svdsv")
    new GeoPoint(x,y)

  }
}





/*var a = new GeoPoint
var b = new GeoPoint
a == b //false

a = new GeoPoint2
b = new GeoPoint2
a == b //true*/