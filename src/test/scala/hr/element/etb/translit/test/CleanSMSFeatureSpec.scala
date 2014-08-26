package hr.element.etb.translit
package test

import org.junit.runner.RunWith
import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CleanSMSFeatureSpec
    extends FeatureSpec with GivenWhenThen with ShouldMatchers {

  feature("SMS URL sanitization"){
    info("SMS should convert every evil character combination into a pretty URL-safe string")

    scenario("SMS unsafe character removal"){
      val in = "aZ{}[]! a";
      given ("a string containing: %s" format in)
      val res = "aZ-! a"
      then ("it should return a string: %s" format res)
      val out = CleanSMS(in)
      out should equal (res)
    }

    scenario("SMS unsafe character trimming"){
      val in = "!aćsčš ";
      given ("a string containing: %s" format in)
      val res = "!acscs "
      then ("it should return a string: %s" format res)
      val out = CleanSMS(in)
      out should equal (res)
    }

    scenario("SMS whitespace trimming to one character"){
      val in = "Helooooooooooooo   oooo";
      given ("a string containing: %s" format in)
      val res = "Helooooooooooooo oooo";
      then ("it should return a string: %s" format res)
      val out = CleanSMS(in)
      out should equal (res)
    }
  }
}
