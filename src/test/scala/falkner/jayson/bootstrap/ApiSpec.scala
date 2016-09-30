package falkner.jayson.bootstrap

import org.specs2.mutable.Specification


/**
  * Example test of API
  *
  * These tests are always the easiest since you are just mocking up params to pass to a method and checking the output.
  */
class ApiSpec extends Specification {

  "API" should {
    "Show usage if no arguments" in {
      Main.run(None) mustEqual Main.usageString
    }
    "Show usage if wrong argument" in {
      val badArg = "foo"
      Main.run(Some(badArg)) mustEqual Main.unknown(badArg)
    }
  }
}

