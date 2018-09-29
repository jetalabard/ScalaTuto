package com.m2i.modulea


import scala.util.{Failure, Success, Try}

class Math  {

  def multiplication(x: Double, y: Double) : Double = x*y

  def carre(x: Double) : Double ={
    return multiplication(x,x)
  }

  def carre2(x: Double) : Double = {
    def multiplication2(x: Double, y: Double) = x * y

    return multiplication(x, x)
  }

  def divide(x: Double,y: Double) : Try[Double]= {
    if(y != 0)
    {
      Success(x/y)
    }
    else
    {
      Failure(new Exception("Division par 0 interdit"))
    }
  }


}





