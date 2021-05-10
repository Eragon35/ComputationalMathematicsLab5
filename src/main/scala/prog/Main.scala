package prog

import prog.InterpolationMethods.{Lagrange, NewtonPolynomial}

import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    var array: IndexedSeq[(Double, Double)] = IndexedSeq[(Double, Double)]()
    var x: Double = 0.0
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
      println(s"\nЛагранж = ${Lagrange.solve(array, x)}")
      println(s"\nНьютона с конечными разностями = ${NewtonPolynomial.solve(array, x)}")
    }
  }
}
