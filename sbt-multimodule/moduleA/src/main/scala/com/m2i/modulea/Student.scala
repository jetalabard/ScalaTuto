package com.m2i.modulea


object Student // compagnon de la classe student
{

  class Student(name:String, age:Int)

  def CreateStudent(name:String, age:Int): Student ={
    new Student(name,age)
  }

  def apply(name:String, age:Int): Student ={
    new Student(name,age)
  }

  //Student.CreateStudent("Nom",5)
  //Student("Nom",5)
}


