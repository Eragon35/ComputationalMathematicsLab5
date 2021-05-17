package prog.InterpolationMethods

import scala.annotation.tailrec

object NewtonPolynomial {
  def solveForward(points: IndexedSeq[(Double, Double)], x: Double): Double = {
    val h: Double = points(1)._1 - points(0)._1
    var answer: Double = points(0)._2
    for (j <- 1 until points.size) answer += findDY(j, points = points) * q0(j, x, points) / (factorial(j) * Math.pow(h, j))
    answer
  }

  def solveBack(points: IndexedSeq[(Double, Double)], x: Double): Double = {
    var answer: Double = points.last._2
    for (j <- 1 until points.size) answer += findDY(j, points.size - j - 1 ,points) * q2(j, x, points) / factorial(j)
    answer
  }

  def findDY(power: Int, index: Int = 0, points: IndexedSeq[(Double, Double)]): Double = {
    def find(power: Int, index: Int = 0): Double = {
      if (power == 0) points(index)._2
      else find(power - 1, index + 1) - find(power - 1, index)
    }
    find(power, index)
  }

  @tailrec
  private def factorial(limit: Int,curr: Int = 2, ans: Long = 1): Long = {
    if (curr <= limit) factorial(limit, curr + 1, ans * curr)
    else ans
  }

  private def q0(index: Int, x: Double, points: IndexedSeq[(Double, Double)]): Double = {
    var value: Double = 1.0
    for (i <- 0 until index) value *= (x - points(i)._1)
    value
  }
  def q2(index: Int, x: Double, points: IndexedSeq[(Double, Double)]): Double = {
    var value: Double = 1.0
    for (i <- 0 until index) value *= ((x - points.last._1) / (points(1)._1 - points(0)._1) + i)
    value
  }
}
