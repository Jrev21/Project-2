package ecommerce_app

import scala.collection.mutable
import scala.collection.mutable._
import scala.collection.JavaConversions._

object LoginMenu {

//  def main(args: Array[String]): Unit = {
//    loginMenu()
//  }
  //
  //val loginMap = mutable.Map[String,String]()
  val loginMap = mutable.Map(
    "michael" -> "123",
    "christiana" -> "123",
    "juan" -> "123",
    "raymond" -> "123",
    "julio" -> "123"
  )

  val adminMap = Map(
    "admin" -> "root"
  )

  //define a login menu that checks for username/password credentials
  //or an option for new users to register
  def loginMenu(): Unit = {
    //parser for the loop statement
    var condition = true
    do {
      println("\nWelcome to the Login Menu")
      println("-----------------------------------------------")
      print_menu()
      println("-----------------------------------------------")
      println("\nPlease select an option:")
      try {
        //val input will take an input from a user based on the menu
        val input = scala.io.StdIn.readLine()
        input match { //println for now but each case would then go to the operation of there choosing
          case "1" => {
            val success = findUser()
            if(success){
              println("Success...")
              println("Welcome back!")
              //launch menu here
              DatabaseMenu.Init()
              DatabaseMenu.databaseMenu
            }
            println()
          }
          case "2" => createUser(); println();
          case "0" => {
            println("Goodbye");
            condition = false;
            // a user input of zero sets the condition of loop to false
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
  def askInfo(): Map[String,String] ={
    //ask for a username and password, for an account for access
    println("Username: ")
    val usernameinfo = scala.io.StdIn.readLine()
    print("Password:")
    val passwordInfo = scala.io.StdIn.readLine()
    val userInfo = Map(
      "username" -> usernameinfo,
      "password" -> passwordInfo
    )
    return userInfo
  }

  def findUser(): Boolean = {
    //first send them to userinfo,which would ask for a username and password combination and return a map
    //of their combination
    val userinfo = askInfo()
    //if the loginMap is empty it automatically sends them back to the menu since there is no user created
    if (loginMap.isEmpty) {
      print("User not created or credentials not correct!")
      return false
    } else{
      try{
        //create else to search for password combination in map
        if((userinfo("password").equals(loginMap(userinfo("username"))))){
          return true
        }else{
          //if there is no match,user is sent back
          println("\nUser not created or credentials not correct!")
          return false
        }
      }catch{
        case e: IllegalArgumentException => {println("\nError"); return false;}
        case e: NoSuchElementException => {println("\nUser not created or credentials not correct!");return false;}
      }
    }
  }
  def createUser(): Unit ={
    println("\nadmin password")
    val success = findUser()
    if(success){
      println("\nLets get you in there...")
      //would user askInfo() to get a combination for us to use
      val newuser = askInfo()
      loginMap(newuser("username")) = newuser("password")
    }else{
      return
    }
  }

  def print_menu() {
    //menu would print the options to the user
    // I used a map since I could print it out using its keys
    val menu_options = Map(
      1 -> "Login",
      2 -> "Create New User",
      0 -> "Exit"
    )
    //would print the map out along with the keys
    for {
      k <- Seq(0,1,2) // the keys in the order you want to print them.
      v <- menu_options.get(k)
    } println (k+ " --- " + v)
  }
}
