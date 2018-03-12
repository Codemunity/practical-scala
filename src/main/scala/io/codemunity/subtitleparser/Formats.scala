package io.codemunity.subtitleparser

object Formats {

  sealed trait SubtitleFormat {
    def extension: String
    def header: Option[String] = None

    val timePattern: String
  }

  case object VTT extends SubtitleFormat {
    override def extension: String = "vtt"
    override def header: Option[String] = Some("WEBVTT")

    override val timePattern: String = "HH:mm:ss.SSS"
  }

  case object SRT extends SubtitleFormat {
    override def extension: String = "srt"

    override val timePattern: String = "HH:mm:ss,SSS"
  }

  val all: Set[SubtitleFormat] = Set(VTT, SRT)

  def otherFormats(format: SubtitleFormat): Set[SubtitleFormat] =
    all.filterNot(_.extension == format.extension)

}

