package prog.InterpolationMethods

import scala.annotation.tailrec

object NewtonPolynomial {
  def solve(points: IndexedSeq[(Double, Double)], x: Double): Double = {

    def findDY(power: Int, index: Int = 0): Double = {
      if (power == 0) points(index)._2
      else findDY(power - 1, index + 1) - findDY(power - 1, index)
    }

    val h = points(1)._1 - points(0)._1
    var answer: Double = points(0)._2

    for (i <- 1 until points.size) {
      answer += findDY(i) * q(i, x, points) / (factorial(i) * Math.pow(h, i))
    }
    answer
  }

  @tailrec
  private def factorial(limit: Int,curr: Long = 2, ans: Long = 1): Long = {
    if (curr <= limit) factorial(limit, curr + 1, ans * curr)
    else ans
  }

  private def q(index: Int, x: Double, points: IndexedSeq[(Double, Double)]): Double = {
    var value = 1.0
    for (i <- 0 until index) value *= (x - points(i)._1)
    value
  }

}
