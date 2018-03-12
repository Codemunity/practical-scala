package io.codemunity.subtitleparser

import java.time.LocalTime

case class SubtitleSegment(id: Option[String], startTime: LocalTime, endTime: LocalTime, text: List[String])

case class Subtitles(segments: List[SubtitleSegment])