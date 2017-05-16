/**
  * Created by compr on 07-05-2017.
  */
object MaximalTourismSetArray {
  import scala.collection.mutable.Set
  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var m = sc.nextInt();
    var cities: Array[Set[Int]] = Array.fill[Set[Int]](n+1)(Set())
    for(i <- 0 to m-1) {
      val firstCity = sc.nextInt()
      val secondCity = sc.nextInt()
      if (firstCity<secondCity) {
        cities(firstCity) = cities(firstCity) ++ Set(secondCity)
      } else {
        cities(secondCity) = cities(secondCity) ++ Set(firstCity)
      }
    }
    // Write Your Code Here
    for (i <- 1 to n) {
      if (cities(i).size > 0) {
        cities(i).foreach( j => {if (cities(j).size > 0) {cities(i) = cities(i) ++ cities(j); cities(j) = Set()}})
        cities(i).foreach( j => {for(k <- i+1 to n) {if (cities(k).size>0 && cities(k).contains(j)) {cities(i) = cities(i) ++ cities(k); cities(i) = cities(i) ++ Set(k); cities(k) = Set()}}})
      }
    }
    var maxConnections = 0
    cities.foreach{i => val conn = i.size + 1; if (conn>maxConnections) maxConnections = conn}
    println(maxConnections)
  }
}