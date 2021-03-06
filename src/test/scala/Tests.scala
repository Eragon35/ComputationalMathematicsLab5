
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import prog.InterpolationMethods.NewtonPolynomial.{findDY, q2}

class Tests extends TestCase{
  private val data = IndexedSeq((0.1, 1.25), (0.2, 2.38), (0.3, 3.79), (0.4, 5.44), (0.5, 7.14))
  private val delta = 0.0000000000001
  private val h: Double = data(1)._1 - data(0)._1


  def testPower3(): Unit = assertEquals(-0.19, findDY(3, 1, data), delta)
  def testPower2(): Unit = assertEquals(0.28, findDY(2, 0, data), delta)
  def testPower1(): Unit = assertEquals(1.7, findDY(1, 3, data), delta)
  def testPower0(): Unit = assertEquals(7.14,findDY(0, 4, data), delta)
  def testRofloTest(): Unit = assertEquals(0.19,"0.19".toDouble )
//  def testNewton(): Unit = assertEquals(, solve(data, ))
  def testQ0():Unit = assertEquals(-2.8, q2(1, 0.22, data), delta)
  def testQ1():Unit = assertEquals(5.04, q2(2, 0.22, data), delta)
  def testQ2():Unit = assertEquals(-4.032, q2(3, 0.22, data), delta)
  def testQ3():Unit = assertEquals(-0.8064, q2(4, 0.22, data), delta)
}