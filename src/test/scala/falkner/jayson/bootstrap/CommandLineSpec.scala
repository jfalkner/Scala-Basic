package falkner.jayson.bootstrap

import org.specs2.mutable.Specification
import java.io.{ByteArrayOutputStream, PrintStream}


/**
  * Example test of App's entry point
  *
  * This test covers that the command-line use works. Easy to forget about if just testing API, but helpful to confirm
  * that CLI usage actually works. CommandLineUtil is a helpful trait to buffer stdout or stderr as needed.
  */
class CommandLineSpec extends Specification with CommandLineUtil {

  "Command line usage" should {
    "stdout should mimic API" in {
      stdout {
        Main.main(Array[String]())
      }.trim mustEqual Main.usageString
    }
  }
}

/**
  * Helper methods to write tests that need to confirm expected stdout and stderr CLI output
  */
trait CommandLineUtil {
  // util method to buffer CLI stderr and provide a string for testing
  def stderr(f: => Unit): String = {
    val err = System.err
    try {
      val buf = new ByteArrayOutputStream()
      System.setErr(new PrintStream(buf))
      f
      buf.toString()
    }
    finally {
      System.setErr(err)
    }
  }

  // util method to buffer CLI stdout and provide a string for testing
  def stdout(f: => Unit): String = {
    val out = System.out
    try {
      val buf = new ByteArrayOutputStream()
      System.setOut(new PrintStream(buf))
      f
      buf.toString()
    }
    finally {
      System.setOut(out)
    }
  }
}