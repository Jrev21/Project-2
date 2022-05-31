import scala.io.StdIn

object menu {
  def main(args: Array[String]) = {
    //print the menu
    print_menu()
    //used a infinite iterator to read the input of a user and
    Iterator.continually(StdIn.readLine())
      //exit the iterator if 0 was inputted
      .takeWhile(_ != "0" )
      // would parse the input for one of the options on the menu
      .foreach{
        case "1" => println("case 1")
        case "2" => println("case 2")
        case "3" => println("case 3")
        case "4" => println("case 4 ")
        case other => "not an option"
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


}
