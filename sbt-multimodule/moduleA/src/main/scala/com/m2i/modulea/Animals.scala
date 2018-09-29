package com.m2i.modulea

object Animals {

  trait Carnivore <: Animal{

    def manger(a: NourritureCarnivore)

  }

  abstract class NourritureCarnivore{

  }

  abstract class NourritureHerbivore{

  }

  // L'écriture trait Carnivore <: Animal signifie
  // que la classe Animal et ses classes filles sont
  // les seuls à pouvoir hériter de ce trait (on dit aussi mixer le trait).



  trait Herbivore <: Animal {

    def manger(a: NourritureHerbivore)

  }

  abstract class Animal(val nom: String, var dresse: Boolean = false, var aFaim:Boolean = false) {

    def dresser = {

      dresse = true

      println("J'ai été dressé !!")

    }

    def afficher = println("Je suis un chien, je m'appelle " + nom)

  }

  class Chien(nom: String) extends Animal(nom) with Carnivore {

    def manger(nourriture: NourritureCarnivore) = { aFaim = false }

    def seDeplacer = println("Je marche")

  }


  object Spot extends Animal("Spot", true) with Carnivore with Herbivore {

    def manger(nourriture: NourritureCarnivore) = { aFaim = false }

    def manger(nourriture: NourritureHerbivore) = { aFaim = false }

    def seDeplacer = println("Je tourne")

  }



  class Serpent(n: String,d: Boolean){

    def seDeplacer = println("Je glisse")

  }


  class Poisson(n: String,d: Boolean) extends Animal(n, d){

    def seDeplacer = println("Je nage")

  }
}