object FirstTest extends App {
  println("Hello Scala!")

  val names = List("Ana", "Anders", "Calle Sam")
  println(secret_names(names))
  println(s_count(names))


  val builder = new StringBuilder

  val x = { builder += 'x'; 1 }
  lazy val y = { builder += 'y'; 2 }
  def z = { builder += 'z'; 3 }

  println(builder.result())
  println(z + y + x + z + y + x)
  println(builder.result())

  def winner (n1: Int, n2: Int): Int = {
    if (n1 > n2) n1
    else n2
  }

  val players = List(1,2,3,4,5,6,7,8,9)
  println( players.reduceLeft(winner))

  // declarative
  def sumD(xs: List[Int]): Int = xs
  match {
    case Nil => 0
    case x :: tail => x + sumD(tail)
  }

  // imperative
  def sumI(ints: List[Int]): Int = {
    var sum = 0;
    for (i <- ints) {
      sum += i
    }
    sum
  }

  def secret_names(names: List[String]) = {
    names.map(name => name.hashCode )
  }

  def s_count(names: List[String]) = {
    names.foldLeft(0) { (a, n) => a + n.toLowerCase().count(_ == 's') }
  }

}
