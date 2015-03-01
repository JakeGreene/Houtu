package ca.jakegreene.houtu

case class HeightMap(height: Array[Array[Float]])

class HeightMapCreator extends Function1[Int, HeightMap] {
  def apply(length: Int): HeightMap = {
    val map = Array.fill(length, length)(20.0f)
    cfor[Int](length - 1, _ > 1, _ / 2) { delta =>
      /*
       * Square step. Take the four corners of a square `delta + 1`
       * long, calculate the height of the middle as the average
       * height of the corners plus some random perturbation.
       */ 
      cfor[Int](0, _ < length - 1, _ + delta) { row =>
        cfor[Int](0, _ < length - 1, _ + delta) { column =>
          val topLeft = map(row)(column)
          val topRight = map(row)(column + delta)
          val bottomLeft = map(row + delta)(column)
          val bottomRight = map(row + delta)(column + delta)
          val center = (topLeft + topRight + bottomLeft + bottomRight) / 4
          val centerPerturbed = center + 5 + (Math.random() * -10)
          val centerDelta = delta / 2
          map(row + centerDelta)(column + centerDelta) = centerPerturbed.toFloat
        }  
      }
    }
    HeightMap(map)
  }
  
  private def cfor[@specialized T](zero: T, okay: T=>Boolean, inc: T=>T)(act: T => Unit) {
    var i = zero
    while (okay(i)) {
      act(i)
      i = inc(i)
    }
  }
}