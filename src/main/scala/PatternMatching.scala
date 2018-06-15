object PatternMatching extends App {

  def unexhaustive() = {
    sealed trait Symbol
    sealed trait NoteName
    case object A extends NoteName
    case object B extends NoteName
    case object C extends NoteName
    case object D extends NoteName
    case object E extends NoteName
    case object F extends NoteName
    case object G extends NoteName

    case class Note(name: NoteName, duration: String, octave: Int) extends Symbol
    case class Rest(duration: String) extends Symbol

    def nonExhaustiveDuration(symbol: Symbol): String =

      symbol match {
        case Rest(duration) => duration
        //        case Note(name, duration, octave) => duration
      }
  }
}
