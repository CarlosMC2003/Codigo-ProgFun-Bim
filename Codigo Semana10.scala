//INTRO - Programación Reactiva

//Libreria a utilizar
//libraryDependencies += "com.lihaoyi" %% "scalarx" % "0.4.3"

import rx._

//1 Ejemplo visto
object Main extends App{
  val a = Var(1)
  val b = Var(2)
  val c = Rx{ a() + b() }

  println(c.now)
  a() = 4

  println(c.now) //el ".now devuelve el valor que se encuentra en ese momento / sino devuelve la clase"
}

//2 Ejemplo visto
import rx._

object Main extends App{
  val a = Var(1)
  val b = Var(2)

  val c = Rx{ a() + b() }
  val d = Rx{ c() * 5}
  val e = Rx{c() + 4}
  val f = Rx( d() + e() + 4 )

  println(f.now)
  a() = 3
  println(f.now)
}

//3 Ejemplo visto con un Observer(o)
import rx._

object Main extends App{
  val a = Var(1)
  var count = 0
  val o = a.trigger {
    count = a.now + 1
  }
  println(count)
  a() = 4
  println(count)
}

//4 Ejemplo con TriggerLater
//TriggerLater = Se ejecuta luego de declarar la variable / no la toma en cuenta
import rx._

object Main extends App{
  val a = Var(1)
  var count = 0
  val o = a.triggerLater {
    count = a.now + 1
  }
  println(count)
  a() = 4
  println(count)

//5 EJEMPLO utilizando Kill (Kill OBS)
import rx._

object Main extends App{
  val a = Var(1)
  val b = Rx{ 2 * a() }
  var target = b.now
  val o = b.trigger {
    target = b.now
  }
  println(target)
  a() = 2
  println(target)
  o.kill()
  a() = 3
  println(target)
}