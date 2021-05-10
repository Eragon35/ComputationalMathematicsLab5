package prog

import prog.InterpolationMethods.Lagrange

import scala.io.StdIn

object Main {

  var array: IndexedSeq[(Double, Double)] = IndexedSeq[(Double, Double)]()
  val x1: Double = 0.502
  val x2: Double = 0.745
  var x: Double = 0.0

  def main(args: Array[String]): Unit = {
    println(
      """ Вариант №2
        | Заданне таблицей точки
        | Функция b: x - 2
        | Функция c: cos(x)
        | Функция d: 1,38x^3 − 5,42x^2 + 2,57x + 10,95""".stripMargin)
//    1: Многочлен Лагранжа
//    2: Многочлен Ньютона с конечными разностями

    while (true) {
      println("\nВыберите ряд точек: ")
      array = ConsoleHandler.inputHandler(StdIn.readLine())
      println("Выберите точку для интерполяции: ")
      x = ConsoleHandler.inputPointHandler(StdIn.readLine())

      // do magic & all other stuff
      // todo: write Lagrange interpolation
      println(s"\nЛагранж = ${Lagrange.solve(array, x)}")
      // todo: write Newton interpolation

    }
  }
}
