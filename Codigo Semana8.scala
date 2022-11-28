//EJEMPLO EFECTO COLATERAL
int cont = 0
void addOne() {
	cont = cont + 1;
}

//EJEMPLO 2
newState = print("hola" + oldState) 

//DIVISION SIN EFECTOS COLATERALES
def division(n1: Double, n2 : Double) =
  if(n2 == 0) throw new RuntimeException("División por 0")
  else n1 / n2


import scala.util.Try
def pureDivision(n1: Double, n2: Double): Try[Double] = 
    Try{ division(n1, n2)}

import scala.util.Try
def pureDivision(n1: Double, n2: Double): Try[Double] = 
    Try{ division(n1, n2)}

val result = pureDivision(1, 3)

import scala.util.{Success, Failure}

result match {
    case Success(v) => println(v)
    case Failure(e) => println(e.getMessage)
}

//EJEMPLO NULL MISTAKE - OPTION - SOME - NONE
def toInt(s: String) : Option[Int] = {
    try {
        Some(Integer.parseInt(s))
    } catch {
        case e: Exception => None
    }
}
toInt("1")
toInt("Uno")
val txtNumbers = List("1", "2", "foo", "3", "bar")
txtNumbers.map(toInt)
txtNumbers.map(toInt).flatten

import scala.util.control.Exception._
def toInt(s: String) : Option[Int] = allCatch.opt(s.toInt)

//Obtener Valores getOrElse - foreach - match
val x = toInt("1").getOrElse(0)
toInt("1").foreach { i => printf("Obtener un Int:%d", i)}
toInt("1") match {
    case Some(i) => println(i)
    case None => println("That didn't work.")
}

//EJEMPLO Either - Left - Right
def divideXByY( x: Int, y: Int): Either[String, Int] =
    if(y == 0) Left("No se puede dividir por 0")
    else Right(x / y)

val x = divideXByY(1, 1).right.getOrElse(0)
val x2 = divideXByY(1, 0).right.getOrElse(0)

divideXByY(1, 0) match {
    case Left(s) => println("Answer: " + s)
    case Right(i) => println("Answer: " + i)
}

//Recomendación usar: Try / Success / Failure