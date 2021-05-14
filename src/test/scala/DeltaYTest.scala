
import junit.framework.{Assert, TestCase}
import junit.framework.TestCase.assertEquals
import org.junit.Test
import prog.InterpolationMethods.NewtonPolynomial.{solveRight, findDY}

class DeltaYTest extends TestCase{
  private val data = IndexedSeq((0.1, 1.25), (0.2, 2.38), (0.3, 3.79), (0.4, 5.44), (0.5, 7.14))
  private val delta = 0.0000000000001

  def testPower3(): Unit = assertEquals(-0.19, findDY(3, 1, data), delta)
  def testPower2(): Unit = assertEquals(0.28, findDY(2, 0, data), delta)
  def testPower1(): Unit = assertEquals(1.7, findDY(1, 3, data), delta)
  def testPower0(): Unit = assertEquals(7.14,findDY(0, 4, data), delta)
  def testRofloTest(): Unit = assertEquals(0.19,"0.19".toDouble )
//  def testNewton(): Unit = assertEquals(, solve(data, ))
}