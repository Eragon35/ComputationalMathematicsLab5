import scala.annotation.tailrec

var data = IndexedSeq((0.5, 1.532), (0.55, 2.5356), (0.6, 3.5406), (0.65, 4.5462), (0.7, 5.5504), (0.75, 6.5559), (0.8, 7.5594))

data(1)._2

@tailrec
def factorial(limit: Int,curr: Int = 2, ans: Long = 1): Long = {
  if (curr <= limit) factorial(limit, curr + 1, ans * curr)
  else ans
}

factorial(0)

Math.pow(1.4, 0)