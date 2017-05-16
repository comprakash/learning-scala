/**
  * Created by compr on 06-05-2017.
  */
object MaximalTourismSet {
  import scala.collection.mutable.Set
  import scala.collection.mutable.Map
  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var m = sc.nextInt();
    var route = Array.ofDim[Int](m,2);
    var connectedCities: Map[Int, Set[Int]] = Map()
    for(route_i <- 0 to m-1) {
      for(route_j <- 0 to 2-1){
        route(route_i)(route_j) = sc.nextInt();
      }
      connectedCities += (route_i -> Set(route(route_i)(0), route(route_i)(1)))
    }
    // Write Your Code Here
    //println(connectedCities)
    var maxConnections = 0
    val mergedCities = mergeSets(connectedCities, Map())
    //println(mergedCities)
    mergedCities.keys.foreach{(i) => val conn = mergedCities(i).size; if (conn>maxConnections) maxConnections = conn}
    println(maxConnections)
  }
  def mergeSets(connectedCities: Map[Int, Set[Int]], connectedCitiesNew: Map[Int, Set[Int]]): Map[Int, Set[Int]] = {
    if (connectedCities.isEmpty) connectedCitiesNew
    else {
      if (connectedCitiesNew.isEmpty) {
        mergeSets(connectedCities.tail, Map(connectedCities.head))
      } else {
        var found = false
        connectedCitiesNew.foreach(i => if (!i._2.intersect(connectedCities.head._2).isEmpty) {connectedCitiesNew(i._1) = connectedCitiesNew(i._1) ++ connectedCities.head._2; found=true})
        if (found) {
          mergeSets(connectedCities.tail, connectedCitiesNew)
        } else {
          mergeSets(connectedCities.tail, connectedCitiesNew + (connectedCities.head._1 -> connectedCities.head._2))
        }
      }
    }
  }
}
