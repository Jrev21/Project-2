package ecommerce_app

import scala.Console.println

object DatabaseMenu {

  //create a new instance of ecommerce_app.DatabaseManager that establishes the SparkSession
  //in addition to functionality for each of the mapped marketing analysis queries in the menu
  val databaseManager = new DatabaseManager

  def main(args: Array[String]): Unit = {
    Init()
//    LoginMenu.loginMenu()
    databaseMenu()
  }

  def Init(): Unit = {
    databaseManager.createDatabase()
  }

  def databaseMenu(): Unit = {
    //parser for the loop statement
    var condition = true
    do {
      println("\nWelcome to the Project Database Management Menu")
      println("-----------------------------------------------")
      print_menu()
      println("-----------------------------------------------")
      println("\nPlease select an option from the menu:")
      try {
        //val input will take an input from a user based on the menu
        val input = scala.io.StdIn.readLine()
        input match { //println for now but each case would then go to the operation of there choosing
          case "1" => databaseManager.marketingQuestions("one")
          case "2" => databaseManager.marketingQuestions("two")
          case "3" => databaseManager.marketingQuestions("three")
          case "4" => databaseManager.marketingQuestions("four")
          case "0" => {
            println("Goodbye");
            condition = false;
            // a user input of zero sets the condition of loop to false
            databaseManager.closeSpark()
          } // which exits the program
          case other => println("Invalid option") // if a invalid option was inputted
        }
        // try and catch was used just in case we found any errors down the road
      } catch {
        case e: IllegalArgumentException => {
          println("error")
        }
      }
    } while (condition) //condition is initially set to true for the do while loop to execute at least once
  }

  def print_menu() {
    //menu would print the options to the user
    // I used a map since I could print it out using its keys
    val menu_options = Map(
      1 -> "Top Selling Categories of Items",
      2 -> "Product Popularity Change Throughout the Year",
      3 -> "Highest Traffic of Sales by Location",
      4 -> "Times during the year with the Highest Traffic of Sales",
      0 -> "Exit"
    )
    //would print the map out along with the keys
    menu_options.keys.foreach { i =>
      println(i + " --- " + menu_options(i))
    }
  }
}

