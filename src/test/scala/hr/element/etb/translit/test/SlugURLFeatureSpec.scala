package hr.element.etb.translit
package test

import org.junit.runner.RunWith
import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.ShouldMatchers
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SlugURLFeatureSpec
    extends FeatureSpec with GivenWhenThen with ShouldMatchers {

  feature("Slug URL sanitization"){
    info("Slug URL should convert every evil character combination into a pretty URL-safe string")

    scenario("Uppercase character lowercasing"){
      val in = 'A' to 'Z' mkString;
      Given ("a string containing uppercase letters: %s" format in)
      val res = in.toLowerCase
      Then ("it should return a string with no uppercase characters: %s" format res)
      val out = SlugURL(in)
      out should equal (res)
    }

    scenario("URL unsafe character removal"){
      val in = """!"#$%&'()*+,/:;<=>?@[\]^`{|}~""" mkString;
      Given ("a string containing only non-safe characters: %s" format in)
      Then ("it should return an empty string.")
      val out = SlugURL(in)
      out should be ('empty)
    }

    scenario("URL unsafe character trimming"){
      val in = """~ Dinamo ! Is the best! ~""" mkString;
      Given ("an URL unsafe string: %s" format in)
      val res = "dinamo-is-the-best"
      Then ("the resulting slug should be trimmed: %s" format res)
      val out = SlugURL(in)
      out should equal (res)
    }

    scenario("URL unsafe character trimming 2"){
      val in = """~ $Hajduk ! Is better!!!Slayer rules$ ~""" mkString;
      Given ("an URL unsafe string: %s" format in)
      val res = "hajduk-is-better-slayer-rules"
      Then ("the resulting slug should be trimmed: %s" format res)
      val out = SlugURL(in)
      out should equal (res)
    }

    scenario("URL unsafe character trimming 3"){
      val in = """Listening to: Humoresque № 7 by Antonín Dvořák""" mkString;
      Given ("an URL unsafe string: %s" format in)
      val res = "listening-to-humoresque-no-7-by-antonin-dvorak"
      Then ("the resulting slug should be trimmed: %s" format res)
      val out = SlugURL(in)
      out should equal (res)
    }
  }
}
