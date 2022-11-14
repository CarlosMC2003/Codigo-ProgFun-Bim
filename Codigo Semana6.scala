//Ejercicio Propuesto Examen Parcial 1
val nros = List(727.7, 1086.5, 1091.0, 1361.3, 1490.5, 1956.1)

def promedio(valores: List[Double]) : Double = valores.sum / valores.size

def desvEst(valores: List[Double]) : Double = {
  val avg = promedio(valores)

  def varianza(valores: List[Double]): Double =
    valores.map(x => Math.pow(x - avg, 2)).sum * (1.0 / (valores.size - 1))

  Math.sqrt(varianza(valores))
}

desvEst(nros)

def clasificac(valores: List[Double]) : Unit = {
  val s = desvEst(valores)
  val avg = promedio(valores)

  (1 to 3).foreach( i => 
  println((valores.filter(x =>
  x >= (avg - i * s) && x <= (avg + i * s))).size))
    
}

clasificac(nros)

//Tuplas
val par = (1, "Abad Ana")

println(par._1)
println(par._2)

val student = (1, "Abad Ana")

val datos = ("jorgaf", "M", 45, 95.2, true)

val student: Tuple2[Int, String]
val datos: Tuple5[String. Char, Int, Double, Boolean]

//ALGUNAS FUNCIONES DE TUPLAS
val student = (1, "Abad Ana")
val(edad, nombre) = student
print(edad)
print(nombre)

student.swap

student.canEqual((1, "Abad Ana"))

//Algunas OPERACIONES de las Listas[]
val myList = List(10, 20, 30, 40, 50, 60)
myList.isEmpty
myList.drop(2)
myList.dropWhile(_ < 25)
myList.slice(2, 4)
myList.tail
myList.take(3)
myList.takeWhile(_ < 30)
myList.sorted
myList.sorted(Ordering.Int.reverse)

/*foldLeft => Aplica un operador binario a un valor inicial y a todos los elementos
de esta secuencia, de izquierda a derecha*/
myList.foldLeft(0) ( (x, y) => x + y)
myList.foldLeft(0) (_ + _)

/*foldRigth => Aplica un operador binario a un valor inicial y a todos los elementos
de esta secuencia, de derecha a izquierda*/
myList.foldRight(0) ( (x, y) => x + y)
myList.foldRight(0) (_ + _)

/*Crear una función para calcular el promedio de los elementos de una lista de
 numero reales*/
def average(valores: List[Double]) : Double = {
  val t = valores.foldLeft((0.0, 0))((acc, currVal) => (acc._1 + currVal, acc._2 + 1))
  t._1 / t._2
}

def average2(valores: List[Double]) : Double = {
  val t = valores.foldLeft((0.0, 0)) ( (acc, currVal) =>
    val sum = acc._1 + currVal
    val cont = acc._2 + 1
    printf("suma: %f - contador: %d%n", sum, cont)
      (sum, cont)
  )
  t._1 / t._2
}
