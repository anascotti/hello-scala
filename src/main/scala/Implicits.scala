object test {

  class MyIntWrapper(val original: Int) {
    def isOdd = original % 2 != 0
    def isEven = !isOdd
  }

  implicit def whateverName(value: Int) = new MyIntWrapper(value)

  val doubleEvens: PartialFunction[Int, Int] =
    new PartialFunction[Int, Int] {
      def isDefinedAt(x: Int) = x.isEven
      def apply(v1: Int) = v1 * 2
    }

  val tripleOdds: PartialFunction[Int, Int] = {
    case x if x.isOdd => x * 3
  }

  val whatToDo = doubleEvens orElse tripleOdds


  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    println(whatToDo(3))
    println(whatToDo(4))
  }

}
