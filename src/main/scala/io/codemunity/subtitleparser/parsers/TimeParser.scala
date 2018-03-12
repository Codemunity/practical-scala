package io.codemunity.subtitleparser.parsers

import java.time.LocalTime
import java.time.format.{DateTimeFormatter, DateTimeFormatterBuilder}
import java.time.temporal.ChronoField

object TimeParser {

  private def formatter(pattern: String): DateTimeFormatter =
    new DateTimeFormatterBuilder()
      .appendPattern(pattern)
      .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
      .toFormatter

  def format(time: LocalTime, pattern: String): String =
    time.format(formatter(pattern))

  def parse(time: String, pattern: String): LocalTime =
    LocalTime.parse(time, formatter(pattern))
}