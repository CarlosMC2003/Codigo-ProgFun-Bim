//EJEMPLO LISTA DE TUPLAS 
val goleadores = List(
  ("Francisco Fydriszewski", 10),
  ("Joaquin Vargas", 9),
  ("Santiago Giordana", 9),
  ("ismael Dias", 8),
  ("Tomás Molina", 7),
  ("Danny Luna", 7),
  ("Cristian Martínez", 7),
  ("Gabriel Cortez", 7),
  ("Leonardo Villagra", 6),
  ("Michael Hoyos", 6)
)

//Promedio goles
val goles = goleadores.map(_._2).map(_.toDouble)
val average =
  (values: List[Double]) => values.sum / values.length
val avgGol = average(goles)

//Goleador
goleadores.maxBy(_._2)._1

//Menos Goles
goleadores.minBy(_._2)._1

//Jugadores mayor promedio de goles
val mayoresAvg = goleadores.
  filter(_._2 > avgGol).map(_._1)

//Jugadores menor promedio de goles
val mayoresAvg = goleadores.
  filter(_._2 < avgGol).map(_._1)

//CONJUNTOS = Grupo de valores únicos
val conj2 : Set[Int] = Set()

val conjunto: Set[Int] = Set(1, 1, 2, 2, 2, 3)

//Algunas funciones de los Conjuntos
val conNuevo = conjunto + 6
val conNuevo2 = conjunto.concat(List(2, 3, 4, 5))
conNuevo2.intersect(conjunto)

//MAPAS
/*Map[K, V]
K = representa a las claves
V = representa a los valores
 */
//1era Forma
Map(("apples", 3), ("oranges", 2), ("pears", 0))
//2da Forma
Map(("apples" -> 3), ("oranges" -> 2), ("pears" -> 0))
//Transformar una lista a MAP
List(("apples", 3), ("oranges", 2), ("pears", 0)).toMap
//Convertir un Map a Sequencia
Map(("apples", 3), ("oranges", 2), ("pears", 0)).toSeq
//Convertir un Map a Lista
Map(("apples", 3), ("oranges", 2), ("pears", 0)).toList

//FUNCIONES
val fruitBasket = Map(("apples", 3), ("oranges", 2), ("pears", 0))
fruitBasket.map(data => data match {
  case (frui, count) => count * 2
  }
)
fruitBasket.map{
  case(fruit, count) => count * 2
}
fruitBasket.map{
  case(fruit, count) => (fruit, count * 2)
}
fruitBasket.map{ case(fruit, count) => (fruit, count, count * 2)}.
  map{ case(fruit, _, count2) => (fruit, count2 / 2) }.toMap

val fruitBasket = Map(("apples", 3), ("oranges", 2), ("pears", 0))
Seq("wobal", "xanthan", "yogurt", "zebra").
  groupBy(s => if (s startsWith "y") 1 else 2)

List(1, 2, 3, 4, 5).groupBy(x => x % 3)

//Numeros de jugadores con los mismos goles
goleadores.groupBy{ case (_, goals) => goals}

goleadores.groupBy{ case (_, goals) => goals}.map(row => row match {
  case (goles, lista) => (goles, lista.size)
}).toList.sortBy(_._2)
