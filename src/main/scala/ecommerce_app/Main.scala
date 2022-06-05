package ecommerce_app

import ecommerce_app.DatabaseMenu.{Init, databaseMenu}

object Main {
  def main(args: Array[String]): Unit =
    Init()
    LoginMenu.loginMenu()
    databaseMenu()

}

