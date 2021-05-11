package prog.InterpolationMethods

object Lagrange {
  def solve(points: IndexedSeq[(Double, Double)], x: Double): Double = {
    points.map(f => f._2 * (divider(x, f._1, points) / dividend(f._1, points))).sum
  }

  private def divider(X: Double, xi: Double, otherX: IndexedSeq[(Double, Double)]) : Double = {
    var sum: Double = 1.0
    for (x <- otherX) if (x._1 != xi) sum *= (X - x._1)
    sum
  }

  private def dividend(xi: Double, otherX: IndexedSeq[(Double, Double)]) : Double = {
    var sum: Double = 1.0
    for (x <- otherX) if (x._1 != xi) sum *= (xi - x._1)
    sum
  }
}
