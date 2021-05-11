package prog


import scala.annotation.tailrec
import scala.io.StdIn

object ConsoleHandler {
  private var left: Double = 0.0
  private var right: Double = 0.0
//  private val data = IndexedSeq((0.5, 1.532), (0.55, 2.5356), (0.6, 3.5406), (0.65, 4.5462), (0.7, 5.5504), (0.75, 6.5559), (0.8, 7.5594))
  private val data = IndexedSeq((0.1, 1.25), (0.2, 2.38), (0.3, 3.79), (0.4, 5.44), (0.5, 7.14))
  @tailrec
  def inputHandler(line: String): IndexedSeq[(Double, Double)] = {
    line.trim.toLowerCase match {
      case "1" | "a" => left = data(0)._1
        right = data(data.size - 1)._1
        data
      case "2" | "b" => chooseRange(second)
      case "3" | "c" => chooseRange(third)
      case "4" | "d" => chooseRange(forth)
      case "exit" | "no" | "n" | "учше" =>
        print("Хорошего Вам дня!")
        System.exit(0)
        IndexedSeq[(Double, Double)]() // костыль чтобы иметь возможность выйти из программы
      case _ => Console.err.println("Давай по новой, Миша все х*йня")
        inputHandler(StdIn.readLine())
    }
  }

  private def second(x: Double): Double = x - 2
  private def third(x: Double): Double = Math.cos(x)
  private def forth(x: Double): Double = 1.38 * Math.pow(x, 3) - 5.42 * Math.pow(x, 2) + 2.57 * x + 10.95

  @tailrec
  private def chooseRange(func: Double => Double): IndexedSeq[(Double, Double)] = {
    println("Выберите диапазон для генерации точек функцией")
    try {
      val line = StdIn.readLine().trim.replaceAll(",", ".").split(" ").map(x => x.toDouble)
      left = line(0)
      right = line(1)
      var array = IndexedSeq[(Double, Double)]()
      for (i <- left to right by (right-left)/data.size) array = array :+ (i, func(i))
      array
    }
    catch {
      case e: Exception => Console.err.println(e + "\nДавай по новой, Миша все х*йня")
        chooseRange(func)
    }
  }

  @tailrec
  def inputPointHandler(line: String): Double = {
    try {
      val value = line.trim.replaceAll(",", ".").toDouble
      if (value > left && value < right) value
      else throw new IllegalArgumentException("Значение должно быть между границами введённого диапазона")
    }
    catch {
      case e: Exception => Console.err.println(e + "\nДавай по новой, Миша все х*йня")
        inputPointHandler(StdIn.readLine())
    }
  }
}
