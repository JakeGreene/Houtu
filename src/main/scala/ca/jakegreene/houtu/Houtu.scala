package ca.jakegreene.houtu

import scala.swing.SimpleSwingApplication
import scala.swing.MainFrame
import java.awt.Color
import java.awt.Dimension

object Houtu extends SimpleSwingApplication {
  
  val data = Array.fill(10, 10)(Color.RED)
  
  def top = new MainFrame {
    contents = new GridPanel(data) {
      preferredSize = new Dimension(300, 300)
    }
  }
}