/**
  * Created by Om Praksah C on 2/16/2017.
  */

object TimeZoneUtil extends App {
  val timeZoneList = java.time.ZoneId.getAvailableZoneIds()
  timeZoneList.forEach(timeZone => println(timeZone + "," + java.time.ZonedDateTime.now(java.time.ZoneId.of(timeZone))))
}
