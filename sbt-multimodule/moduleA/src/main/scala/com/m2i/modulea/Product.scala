package com.m2i.modulea

class Product {

  def somme(xs:List[Int]):Int = xs match{
    case List() => 0
    case y :: ys => y + somme(ys)
  }
  def somme2 (xs:List[Int]) :Int = xs.sum

  def somme3 (xs:List[Int]) :Int = xs.reduce{(a,b) => a+b}

  def somme4 (xs:List[Int]) :Int = xs.foldLeft(0){case (acc,elem) => acc +elem}

  def produit(xs : List[Int]) : Int = xs.reduce{(a,b) => a*b}

  def produit2 (xs:List[Int]) :Int = xs.foldLeft(1){case (acc,elem) => acc * elem}




}
