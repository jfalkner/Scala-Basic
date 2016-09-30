package falkner.jayson.bootstrap

/**
  * Entry point for the example class
  *
  * See scaladoc for examples of how documentation can be written.
  */
object Main extends App {

  lazy val usageString = "Usage: java -jar scala-bootstrap*.jar I win"
  lazy val youWin = "You win"

  println(run(args.headOption))

  def run(arg: Option[String]): String = arg match {
    case Some(arg) if arg == "I win" => youWin
    case Some(arg) => unknown(arg)
    case None => usageString
  }

  def unknown(arg: String): String = s"Unknown argument: $arg"
}
