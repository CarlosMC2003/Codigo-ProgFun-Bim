val cedula = "11087654321" 
Cedula = "11087654320"

val cedula = "1108765321"
val cedula = "1108765320"
var cedula = "1108765320"

//funcion ecuacion matematica
(x: Double) => -Math.pow(x, 2) + 8 * x - 12
val f1 = (x: Double) => -Math.pow(x, 2) + 8 * x - 12
f1(12)

//funcion integracion
def integracion(a: Int, b: Int, f : Double => Double) = {
	val intermedio = ((a + b) / 2.0)
	val fa = f(a)
	val fi = f(intermedio)
	val fb = f(b)
	(b - a) * (fa + 4 * fi + fb) / 6
}

//funcion calculadora
def select(option: char) : (Int, Int) => Double = {
	option match {
		case '+' => (a: Int, b: Int) => a + b
		case '-' => (a: Int, b: Int) => a - b
		case '*' => (a: Int, b: Int) => a * b
		case '/' => (a: Int, b: Int) => a / b.toDouble
		case _ => (a: Int, b: Int) => 0 / (a + b)
	}
}
select('+')(2, 1)
val operation = select('+')
operation(2, 1)

//funcion determinar pares 
val isEven = (k: Int) => if ( k % 2 == 0) 1 else 0
def isEleven (k: Int) : Int = ( k % 2) match {
	case 0 => 1
	case _ => 0
}

//L => Lista => List[int]
List( 1, 2, 3)
List( 1, 2, 3).sum 

//sum
List(1, 2, 3).sum

//map
List(1, 2, 3).map( x =>  x * x + 100 * x)
res1: List[Int] = List(101, 204, 309)

def func1(x : Int) : Int = x * x + 100 * x

List(1, 2, 3).map( func1 )
res3: List[Int] = List(101, 204, 309)

List(1, 2, 3) map func1 //dotless infix

val nums = List(1, 2, 3)
nums.map(x => x + 1)

def add1(a: Int) : Int = a + 1
nums.map(add1)
nums.map(x => add1(x))
nums.map(add1(_))

val sumaDos = (a: Int, b: Int) => a + b
nums.map(x => sumaDos(x, x))

def isEleven (k: Int) : Int = ( k % 2) match {
	case 0 => 1
	case _ => 0
}
def countEven( s : List[Int] ) : Int = s.map( isEven ).sum

def countEven( s : List[Int] ) : Int = {
	def isEleven (k: Int) : Int = ( k % 2) match {
		case 0 => 1
		case _ => 0
	}
	s.map ( isEven ).sum
}
countEven(List(12, 14, 9, 7, 5, 4, 40))