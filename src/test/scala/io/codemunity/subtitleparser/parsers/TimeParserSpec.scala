package io.codemunity.subtitleparser.parsers

import java.time.LocalTime

import io.codemunity.subtitleparser.Formats.{SRT, VTT}
import org.scalatest.{Matchers, WordSpec}

class TimeParserSpec extends WordSpec with Matchers {

  "A TimeFormat" should {

    "format SRT times" in {
      val time = LocalTime.of(0, 2, 17, 440000000)

      val actual = TimeParser.format(time, SRT.timePattern)
      val expected = "00:02:17,440"

      actual shouldBe expected
    }

    "parse SRT valid times" in {

      val time1 = "00:02:17,440"
      TimeParser.parse(time1, SRT.timePattern) shouldBe LocalTime.of(0, 2, 17, 440000000)

      val time2 = "00:02:20,375"
      TimeParser.parse(time2, SRT.timePattern) shouldBe LocalTime.of(0, 2, 20, 375000000)

    }

    "format VTT times" in {
      val time = LocalTime.of(0, 2, 17, 440000000)

      val actual = TimeParser.format(time, VTT.timePattern)
      val expected = "00:02:17.440"

      actual shouldBe expected
    }

    "parse valid WebVTT times" in {

      val time1 = "00:02:17.440"
      TimeParser.parse(time1, VTT.timePattern) shouldBe LocalTime.of(0, 2, 17, 440000000)

      val time2 = "00:02:20.375"
      TimeParser.parse(time2, VTT.timePattern) shouldBe LocalTime.of(0, 2, 20, 375000000)

    }

  }

}
