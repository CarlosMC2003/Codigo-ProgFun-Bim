//1era Opcion
def isEven (k : Int) : Int = (k % 2) match {
	case 0 => 1
	case _ => 0
}
def countEven( s : lIST[Int] ) : Int = s.map( isEven ).sum

//2da Opcion
def countEven( s : List[Int] ) : Int = {
	def isEven(k: Int): Int = (k % 2) match {
		case 0 => 1
		case _ => 0
	}
	s.map( isEven ).sum
}

//3era Opcion
def countEven( s : List[Int] ) : Int = {
	def isEven = (k : Int) => k % 2 match {
		case 0 => 1
		case _ => 0
	}
	s.map( isEven ).sum
}

/*Mapear una lista de cadenas de textoa lista de enteros que
representan la longitud del texto*/
val names : List{String} = List( "Leo", "Cristiano", " Enner", "Felipe" )
names.map(_.length)

/*Dada una list de numeros enteros, desarrollar las funciones necesarias que
le permitan contar cuantos elementos de la lista son numeros primos.*/
val numbers = List(3, 4, 7, 11, 12)
val isPrime = (nro : Int) => ( 2 to nro - 1 ).forall( nro % _ != 0 )
numbers.map(isPrime(_) match {
	case true => 1
	case false => 0
}).sum

//Filtrar y truncar secuencias
val numbers = List( 6, 28, 15, 12, 11, 24 )

//numero mayor
numbers.max
res26: Int = 28

//numero menor
numbers.min
res27: Int = 6

//tamaño de la lista
numbers.size
res28: Int = 6

//forall y exists

/*forall => devuelve true si y solo si el predicado devuelve true
para todos los valores de la lista*/
def isPrime = (nro : Int) : Boolean = ( 2 until nro).forall(nro % _ != 0) 
//Lo que se encuentra entre parentesis luego del forall es el predicado

/*exists => devuelve true si y solo si el predicado devuelve true 
para por lo menos un valor de la lista*/
def isPrime = (nro : Int) : Boolean = !( 2 until nro).exists(nro % _ != 0) 

/*filter => devuelve una lista que unicamente contiene los
valores que cumplen con el predicado*/
List( 1, 2, 3, 4, 5).filter( k => k % 3 != 0 )
res: List[Int] = List(1, 2, 4, 5)

/*takeWhile => trunca la lista cuando encuentra un valor que
NO cumple con el predicado*/
List( 1, 2, 3, 4, 5 ).takeWhile( k => k % 3 != 0 )
res: List[Int] = List(1, 2)

(n : Int) => (1 until n).filter(div => n % div == 0)

val numbers = List(6, 28, 15, 12, 11, 24)

val sumDiv = (nro : Int) => (1 until nro).filter(div => nro % div == 0).sum

//Para numero perfecto (cuando la suma de los divisores es igual al numero) 
numbers.filter(nro => nro == sumDiv(nro)).size
//Para numero deficiente (cuando la suma de los divisores es menor al numero)
numbers.filter(nro => nro > sumDiv(nro)).size
//Para numero abundante (cuando la suma de los divisores es mayor al numero)
numbers.filter(nro => nro < sumDiv(nro)).size

//programa para el Factorial Escalonado
def factorialEscalonado( n : Int ) : Int = {
    n % 2 match {
        case 0 => (2 to n by 2).product
        case _ => (1 to n by 2).product
    }
}
factorialEscalonado(8)
factorialEscalonado(9)

val numbers = (1 to 20).toList 

//Contar Pares
numbers.filter( nro => nro % 2 == 0 ).size
numbers.count(nro => nro % 2 == 0 )

//Contar Impares
numbers.filter( nro => nro % 2 != 0 ).size
numbers.count(nro => nro % 2 != 0 )

//Contar Primos
def contarPrimos(nros : List[Int]) : Int = {
    val isPrime = (n : Int) => (2 until n ).forall(n % _ != 0)
    //nros.filter(isPrime).size
    nros.count(isPrime(_))
} 

contarPrimos(numbers)

//Presentar 3 factores
def tresFactores(nros : List[Int]) : List[Int] = {
    val factores = (n: Int) => (2 until n).filter(n % _ == 0)

    nros.filter((nro => factores(nro).size == 3))
}

tresFactores((1 to 1000).toList)