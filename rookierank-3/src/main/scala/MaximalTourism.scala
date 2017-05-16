/**
  * Created by compr on 06-05-2017.
  */
object MaximalTourism {
  import scala.collection.mutable.Map
  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var m = sc.nextInt();
    var route = Array.ofDim[Int](m,2);
    var distinctStartCityConnections:Map[Int,List[Int]] = Map()
    for(route_i <- 0 to m-1) {
      for(route_j <- 0 to 2-1){
        route(route_i)(route_j) = sc.nextInt();
      }
    }
    for (i <- 0 until m) {
      // Ignore self connected cities
      if (route(i)(0) != route(i)(1)) {
        if (distinctStartCityConnections.contains(route(i)(0))) {
          distinctStartCityConnections(route(i)(0)) = route(i)(1) :: distinctStartCityConnections(route(i)(0))
        } else {
          distinctStartCityConnections(route(i)(0)) = List(route(i)(1))
        }
        if (distinctStartCityConnections.contains(route(i)(1))) {
          distinctStartCityConnections(route(i)(1)) = route(i)(0) :: distinctStartCityConnections(route(i)(1))
        } else {
          distinctStartCityConnections(route(i)(1)) = List(route(i)(0))
        }
      }
    }
    println(distinctStartCityConnections)
    // Write Your Code Here
    var maxConnections: Int = 0
    for(i <- 1 to n) {
      if (distinctStartCityConnections.contains(i)) {
        maxConnections = maxConnections.max(getConnectedCities(distinctStartCityConnections, i, i, 0, List()))
        println("i - " + i + " , maxConnections - " + maxConnections)
      }
    }
    println(maxConnections)
  }
  def getConnectedCities(distinctStartCityConnections:Map[Int,List[Int]], startCity: Int, currentCity: Int, connections: Int, connectedCities: List[Int]): Int = {
    if (connectedCities.contains(currentCity)) connections
    else {
      val nextCityList = distinctStartCityConnections(currentCity)
      println("nextCityList - " + nextCityList)
      var interimMax = connections
      for (nextCity <- nextCityList) {
        println("startCity - " + startCity + " , currentCity - " + currentCity + " , nextCity - " + nextCity + " , connections - " + connections)
        interimMax = interimMax.max(getConnectedCities(distinctStartCityConnections, startCity, nextCity, connections + 1, currentCity :: connectedCities))
      }
      interimMax
    }
  }
}
