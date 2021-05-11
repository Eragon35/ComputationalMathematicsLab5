package prog

import prog.InterpolationMethods.{Lagrange, NewtonPolynomial}
import scalax.chart.module.Charting._

object Graph {
  def show(points: IndexedSeq[(Double, Double)]): Unit = {
    var dataset = Seq(
      ("Выбранная функция", points),
      ("y = 0", for (x <- points) yield (x._1, 0.0))
    )
    var lagrange = IndexedSeq[(Double, Double)]()
    var newton = IndexedSeq[(Double, Double)]()
    for (i <- points.indices) {
      val x = points(i)._1
      lagrange = lagrange :+ (x, Lagrange.solve(points, x))
//      newton = newton :+ (x, NewtonPolynomial.solve(points, x))
      if (x != points.last._1) {
        val nextX = (points(i + 1)._1 + x) / 2
        lagrange = lagrange :+ (nextX, Lagrange.solve(points, nextX))
        newton = newton :+ (nextX, NewtonPolynomial.solve(points, nextX))
      }
    }
    // show x - y table
//    lagrange.foreach(f => println(s"${f._1} ${f._2}"))
    dataset = dataset ++ Seq(("Многочлен Лагранжа", lagrange),("Многочлен Ньютона с конечными разностями", newton))
    XYLineChart(dataset.toXYSeriesCollection()).show("График функции", (1280, 720), scrollable = true)
  }
}
