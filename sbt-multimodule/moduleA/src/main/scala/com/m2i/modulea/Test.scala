package com.m2i.modulea

import org.joda.time.DateTime

import scala.util.matching.Regex
import scala.util.{Failure, Random, Success, Try}


object Test extends App {


  val math = new Math()
  val multi = math.multiplication(2,5);

  val multi2: Double = math.multiplication(2,5);

  var carr = math.carre(2)

  carr = math.carre2(2)

  val t = {
    var k = math.multiplication(carr,3)
    k + 10
    2 // la valeur du bloc prend la valeur de la derniere ligne
  }

  println(t)


  lazy val eval: Double = math.carre(5) // pas évaluer directement

  println(eval+2) //evaluer à ce moment

  //exo

  var count = 0

  val x = {count += 1;1}
  lazy val y = {count += 1;2}
  def z = {count += 1;3}

  println(count)
  z+x
  println(count)
  x+z+y
  println(count)
  x+y
  println(count)


  val myList : List[String] = List("sdvs","sdv","sdvsdv")

  val myListInt : List[Int] = List(1,2,3)

  val myListInt2 : List[Int] = List(1,2,3)

  val myListInt3 = myListInt ++ myListInt2



  val myListEmpty = List()

  val p = new Product();
  println("Somme")
  val s1 = p.somme(List[Int](1,2,3))
  val s2 = p.somme2(List[Int](1,2,3))
  val s3 = p.somme3(List[Int](1,2,3))
  val s4 = p.somme4(List[Int](1,2,3))

  assert(s1 == s2 && s2 == s3  && s3 == s4)

  println("Produit")
  val p1 = p.produit(List[Int](1,2,3))
  val p2 = p.produit2(List[Int](1,2,3))

  assert(p1 == p2)

  val money = new ManageMoney();
  val ms : List[Money] = List(Money(3,"Euros"),Money(10,"$"),Money(5,"$"),Money(15,"Euros"),Money(1,"$"))

  println(money.sum(ms,"Euros"))
  println(money.sum(ms,"$"))

  println(money.sumMoneysByCurrency(ms))

  val date1 = new DateTime(2012,12,12,0,0)
  val date2 : DateTime = new DateTime(2018,12,12,0,0)
  val date3 : DateTime = new DateTime(2015,12,12,0,0)


  import ImprovedDateTime.ImprovedDateTime

  if(date3.isBetween(date1,date2))
  {
    println("la date est entre les deux dates")
  }
  else
  {
    assert(false)
  }



  def printX(x:Int):String = x match {
    case 0 => "zéro"
    case 1 => "un"
    case _ => "autre"
  }


  def getRandom(): Int = Random.nextInt(2)

  printX(getRandom())


  //sealed

  sealed abstract class Person
  //case class -> constructeur implicite + tostring gethashcode et equals implicite
  case class Student(name:String, age:Int) extends Person
  case class Employee(name:String, age:Int, salary: Double) extends Person


  def printPerson(person: Person):String = person match {
    case Student(name,age) => s"je suis l'étudiant $name"
    case Employee(name,age,salary) => s"je suis l'employee $name"
  }


  def findPersonByID(id :Int) : Option[Person] = {
    id match {
      case 1 => Option(Student("", 5))
      case _ => None
    }

  }

 // TODO val liste: List[Option[Int]] = List(Student("svddv",5),None)
  // TODO liste.flatten
  //flapMap = map().flatten

  def findPersonByIDTry(id :Int) : Try[Person] = {
    if(id == 1){
     Success(new Student("",5))
    }
    else{
      Failure(new Exception("Erreur"))
    }

  }

  val fail :Try[Throwable] = Failure(new UnsupportedOperationException("Success.failed"))

  fail.isFailure
  fail.isSuccess
  fail.get

  //TODO def division (x:Int, y:Int):Try(x)

  val pattern = "Scala".r

  val regex = new Regex("[S|s]cala")

  val str = "scala is scalable and cool"

  println(pattern.findAllIn(str).mkString(","))



  //scala arm
  //pour gérer stream ou pour ouvrir des fichiers

  //scopt
  //librairie de parsing d'options d'entrée d'un programme


  val ascii: Int = "B".toInt
  println(ascii)


  val line  ="""{"id":23,"nom":"Alain"} """
 /* val json = Json.parse(line)
  val Etudiant(
    id = (json \ "id").as[Int],
    nom = (json \ "nom").as[String]
  )*/


  //www.coursera.org/lear/progfun1/
  //scala-style-guide github

  var l: List[Option[Int]] = List(Option(8),Some(5),Option(85),None)
  var l2: List[String] = List("la","lp","mp")

  val newl : List[Int] = l.filter(m => m != None)
    .map{case (value : Option[Int]) => value.get}

  val students : List[Student] = newl.zipWithIndex.map{case (index,age) => new Student(l2(index),age)}




}
