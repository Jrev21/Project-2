object MenuVTwo {
  def main(args: Array[String]): Unit = {
      menu()
  }
  def menu(): Unit ={
    //parser for the loop statment
    var condition = true
    do{
      print_menu()
      try {
        //val input will take an input from a user based on the menu
        val input = scala.io.StdIn.readLine()
        input match {//println for now but each case would then go to the operation of there choosing
          case "1" => println("case 1")
          case "2" => println("case 2")
          case "3" => println("case 3")
          case "4" => println("case 4")
          case "0" => {
            println("Goodbye"); condition = false;
          } // would exit the program
          case other  => println("Invalid option") // if a invalid option was inputted
        }
      // try and catch was used just incase we found any errors down the road
      }catch{
        case e: IllegalArgumentException => {
          println("error")
        }
      }
    }while(condition)
  }
  def print_menu(){
    //menu would print the options to the user
    // i used a map since i could print it out using there keys
    val menu_options = Map(
      0 -> "Exit",
      1 -> "Case 1",
      2 -> "Case 2",
      3 -> "Case 3",
      4 -> "Case 4"

    )
    //would print the map out along with the keys
    menu_options.keys.foreach{ i =>
      println(i + " --- " + menu_options(i))
    }
  }

}
