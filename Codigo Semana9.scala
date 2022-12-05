import scala.io.StdIn
import scala.util.Try

val name = StdIn.readLine("Nombre: ")
Nombre: Jorge 
name: String = "Jorge"

val edad = StdIn.readLine("Edad: ").toInt
Edad: 20
edad: Int = 20

//Programa de ingreso de datos
import scala.io.StdIn
import scala.util.{Try, Success, Failure}

object InputData {
    def main(args: Array[String]) = {
      val name = StdIn.readLine("Nombre: ")
      val age = Try(StdIn.readLine("Edad: ").toInt)
      val weight = Try(StdIn.readLine("Peso: ").toDouble)
      printf("Hola %s, tienes %d años y pesas %fkg\n",
        name,
        age match {
          case Success(v) => v
          case Failure(e) => "Error"
        },
        weight match {
          case Success(v) => v
          case Failure(e) => "Error"
        })
    }
}

//Solución codigo Anterior
object InputData2 {
  def main(args: Array[String]) = {
    print(inData())
  }

  def inData(): String = {
    val name = StdIn.readLine("Nombre: ")
    val age = Try(StdIn.readLine("Edad: ").toInt)
    val weight = Try(StdIn.readLine("Peso: ").toDouble)

    "Hola %s, tienes %d años y pesas %fkg\n".format(
      name,
      age match {
        case Success(v) => v
        case Failure(e) =>
          println("Error en la edad")
          inData()
      },
      weight match {
        case Success(v) => v
        case Failure(e) =>
          println("Error en el peso")
          inData()
      }
    )
  }
}

//OTRO EJEMPLO
object Demo {
  def main(args: Array[String]): Unit = {
    case class User(name: String)

    def getUser(id: Int): Option[User] = {
      if (Set(1, 2, 3).contains(id))
        Some(User(s"User-$id"))
      else
        None
    }

    println(getUser(1).get.name)
    println(getUser(10).getOrElse("No existe"))
  }
}

//Otra forma
val result = getUser(31)
result match {
	case Some(v) => println(v.name)
	case None => println("Usuario no encontrado")
}

//Validar si una URL es valida
import scala.util.try
def parseURL(url: String): Try[URL] =
	Try{new URL(url)}

import scala.io.Source
Source.fromFile("myData.txt")

def readDataFromFile(filepath: String): Try{List[String]} =
	Try{Source.fromFile{filepath}.getLines.toList}

val capitals = Map("France" -> "Paris", "Japon" -> "Tokyo", "Ecuador" -> "Quito")

capitals.get("Ecuador")