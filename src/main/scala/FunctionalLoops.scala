object FunctionalLoops extends App{

  println(sqrt(16))
  println(sum(x => x, 1, 10))
  println(List(1,2).flatMap(x => Some(x + 1)))


  def sqrt(x: Double) = {
    def improve(guess: Double, x: Double) = (guess + x / guess) / 2
    def isGoodEnough(guess: Double, x: Double) = Math.abs(guess * guess - x) < 0.001
    def sqrtIter (guess: Double, x: Double): Double = {
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)
    }
    sqrtIter(1.0, x)
  }


  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(x: Int, acc: Int): Int = {
      if (x > b) acc
      else loop(x + 1, acc + f(x))
    }
    loop(a,0)
  }

//  val cond: (Int, Int) => Boolean = (x,y) => x < y
  def cond (x: Int, y: Int): Boolean = x < y
  def insert(x: Int, xs: List[Int]): List[Int] =
    xs match {
      case List() => x :: Nil
      case y :: ys =>
        if (cond(x, y)) x :: y :: ys
        else y :: insert(x, ys)
    }
}
