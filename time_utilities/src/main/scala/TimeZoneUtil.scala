/**
  * Created by Om Praksah C on 2/16/2017.
  */
import java.time._

object TimeZoneUtil extends App {
  val timeZoneList = ZoneId.getAvailableZoneIds()
  timeZoneList.forEach(timeZone => println(timeZone + "," + java.time.ZonedDateTime.now(ZoneId.of(timeZone))))
}

object TimeConverter extends App {
  val isoTimeWithSeconds = "2017-07-14T02:40:00Z"
  val isoTimeWithMilliSeconds = "2017-07-14T02:40:00.123Z"
  val isoTimeWithMicroSeconds = "2017-07-14T02:40:00.123456Z"
  val isoTimeWithNanoSeconds = "2017-07-14T02:40:00.123456789Z"
  val instant = Instant.parse(isoTimeWithNanoSeconds)
  println(instant)
  println(instant.toString)
  println(instant.getEpochSecond())
  println(instant.toEpochMilli)
  println(instant.getNano)
  println(instant.getEpochSecond() + "." + instant.getNano)

  println(instant.plusNanos(2))

}
