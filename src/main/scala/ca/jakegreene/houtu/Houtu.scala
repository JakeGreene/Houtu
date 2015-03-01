package ca.jakegreene.houtu

import scala.swing.SimpleSwingApplication
import scala.swing.MainFrame
import java.awt.Color
import java.awt.Dimension

object Houtu extends SimpleSwingApplication {
  
  val data = {
    val heights = new HeightMapCreator()(9)
    val min = heights.height.map(_.min).min
    val max = heights.height.map(_.max).max
    heights.height.map { columns =>
      columns.map { cell =>
        // normalize min -> max to become 0 -> 1
        val normalized = (cell - min) / (max - min)
        // The closer to max => closer to green
        // The closer to min => closer to blue
        new Color(0.0f, normalized, (1 - normalized))
      }
    }
  }
  
  def top = new MainFrame {
    contents = new GridPanel(data) {
      preferredSize = new Dimension(500, 500)
    }
  }
}