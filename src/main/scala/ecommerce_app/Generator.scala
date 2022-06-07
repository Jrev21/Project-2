package ecommerce_app

import java.io.{File, PrintWriter}
import java.time.LocalDate
import scala.collection.mutable.ListBuffer
import scala.concurrent.duration
import java.time.temporal.ChronoUnit.DAYS
import scala.util.Random

object Generator {
  val pw = new PrintWriter(new File("C:\\Users\\mcelu\\IdeaProjects\\RevatureGroup2_Project1\\src\\input\\Dataset.csv"))

//  def main(args: Array[String]): Unit ={
//
//    val csv = ListBuffer[List[String]](
//      //List contains the headers to begin with then adds as more rows are generated
//      List("Order_ID","Customer_ID","Customer_name","Product_ID","Product_name",
//        "Product_category","Payment_type","Qty","Price","Datetime","Country","Ecommerce_website_name",
//        "Payment_txn_id","Payment_txn_success","Failure_reason")
//    )
//    //use a while loop to generate a number of needed rows
//    var generate = 0
//    var orderID:Int  = 1
//
//    while (generate < 10000){
//      val add = CreateRow(orderID)
//      //add all needed column values to a list and add them to the csv list
//      csv += add
//      generate += 1
//      orderID += 1 //for every entry is an order number
//    }
//    //prints in csv format
//    csv.foreach(s => makeCSV(s))
//    println("New Dataset.csv generated")
//    pw.close()
//  }
  def CreateRow(orderID: Int): List[String] ={
    //OrderID
    val newID = generateID(orderID)
    //CustomerID
    val customerID = Random.nextInt(73)
    //CustomerName
    val customerName = getCustomerName(customerID)
    //productID
    val productID = Random.nextInt(30)
    //Productname
    val productName = getProductname(productID)
    //ProductCategory
    val productCategory = getproductCategory(productID)
    //paymenttype
    val paymentType = getPaymentType()
    //qty
    val qty = Random.nextInt(1000)
    //price
    val price = getprice(productID)
    //datetime
    val datetime = getDateTime()
    //locationID
    val locationID = Random.nextInt(5)
    //country
    val country = getCountry()
    //ecommerce website
    val website = getWebsite()
    //payment_txn_id
    val txnID = randomtxn()
    //payment_txn_success
    val txn = getTXN()
    //failure reason
    val fr = getFailureReason(txn)
    //add will contain the methods and "grab" the needed values for each collumn
    val add = List(newID, customerID.toString(), customerName, productID.toString,
      productName, productCategory, paymentType, qty.toString, price, datetime, country, website, txnID, txn, fr)
    return add

  }
  def generateID(orderID: Int): String ={
    val intString = orderID.toString
    return intString
  }
  def getCustomerName(customerID:Int): String ={
    val customerNames = Map((0,"Christopher Edwin Breaux"),(1,"Normand Michel"), (2,"Danny Hue"), (3,"Jerry Jean"),
      (4,"Ken Masters"), (5,"Micheal Gus"), (6,"Michelle Otter"), (7,"Morgan Freeman"), (8,"Sherrell Lattes"),
      (9,"Ben Hues"), (10,"Chris Gene"),(11,"Abel Don"),(12,"Rose Jean"),(13,"Sophia Jean"),(14,"McKenzie Phoenix"),
      (15,"Farah Jean"),(16,"Farrah Michelle"),(17,"Christopher Michel"),(18,"Lewis Garden"),(19,"Chris garnet"),(20,"Danielle Will"),(21,"Kenneth Zah"),
      (22,"Liam Shaw"),(23,"Noah Han"),(24,"Ethan Shaw"),(25,"Melia Rage"),(26,"Kay Kiske"),(27,"Sol Badguy"),(28,"Baiken Faust"),(29,"Justice Rage"),(30,"Chipp Zanuff"),
      (31,"Baiken Hen"),(32,"Kliff Undersn"),(33,"Faust Williams"),(34,"Laura Williams"),(35,"Laurelton Shera"),(36,"Rudy Derr"),(37,"Elizabeth kind"),(38,"Honey Wells"),
      (39,"Zangieff Russ"),(40,"Carol Ritz"),(41,"Chungli Chin"),(42,"Sherry Cher"),(43,"Taylor Wind"),(44,"Karmelo Winnie"),(45,"Brian Sea"),(46,"Ronald Bensworth"),
      (47,"Cynthia Dean"),(48,"Danny Maggis"),(49,"Daniel Maggio"),(50,"Matthew Rosen"),(51,"Karen Starrs"),(52,"Tony Stark"),(53,"Louis Clark"),(54,"Luna Starr"),
      (55,"Camila Grant"),(56,"Harper Gene"),(57,"Evelyn Michels"),(58,"Mia Pena"),(59,"Isabella Willford"),(60,"Amelia Crawford"),(61,"Charlotte Hanson"),(62,"Emma Streak"),
      (63,"Oliva Gems"),(64,"Nova Williow"),(65,"Aurora Grace"),(66,"Jean Hazel"),(67,"Lillian Cruz"),(68,"Addison Leah"),(69,"Marc Galdson"),(70,"Gemina Zoe"),
      (71,"Elcy Jean"),(72,"Paisley Everly"),(73,"Erick Manison"))
    val customerName = customerNames(customerID)
    return customerName
  }
  def getProductname(productID: Int): String ={
    productID match{
      case 1 => "Shirt"
      case 2 => "Pants"
      case 3 => "hat"
      case 4 => "banana"
      case 5 => "eggs"
      case 6 => "milk"
      case 7 => "tv"
      case 8 => "phone"
      case 9 => "bike"
      case 10 => "bike tires"
      case 0 => "Computer"
      case _=> "etc"
    }
  }
  def getproductCategory(productID: Int): String ={
    productID match{
      case 1 | 2 | 3 => "apparel"
      case 4 | 5 | 6 => "food"
      case 7 | 8 | 0 => "electronics"
      case 9 | 10 => "bikes"
      case _=> "etc"
    }
  }
  def getPaymentType(): String ={
    val paymentTypes = List("card", "Internet Banking ", "UPI","wallet")
    val payType = paymentTypes(Random.nextInt((paymentTypes.length)))
    return payType
  }
  def getprice(productID: Int):String ={
    val ran = Random.nextInt(30)
    if(ran == 1 ){
      return "Error"
    }else {
      productID match {
        case 1 | 2 | 3  => {
          val price_choice = List("10.99", "5.99", "6.99", "40.99", "65.9")
          val price = price_choice(Random.nextInt((price_choice.length)))
          return price
        }
        case 4 | 5 | 6 => {
          val price_choice = List("3.99", "5.99", "6.99", "13.99", "15.99")
          val price = price_choice(Random.nextInt((price_choice.length)))
          return price
        }
        case 7 | 8 | 0 => {
          val price_choice = List("5.99", "50.99", "100.99", "200.99", "500.99")
          val price = price_choice(Random.nextInt((price_choice.length)))
          return price
        }
        case 9 | 10 => {
          val price_choice = List("150.99", "199.99", "250.99", "300.99", "450.99")
          val price = price_choice(Random.nextInt((price_choice.length)))
          return price
        }
        case _ => "etc"
      }
    }
  }
  def getDateTime(): String = {
    val from =  LocalDate.of(2020,1,1)
    val to = LocalDate.of(2022,12,31)
    def randomdate(a: LocalDate, b: LocalDate): LocalDate = {
      val diff = DAYS.between(a, b)
      val random = new Random(System.nanoTime) // You may want a different seed
      from.plusDays(random.nextInt(diff.toInt))
    }
    val newDate = randomdate(from, to)
    val date = newDate.toString
    return date
  }

  def getCountry(): String = {
    val ran = Random.nextInt(25)
    if(ran == 1){
      return "ERROR"
    }
    val countries = Map(
      (0,"United States"),(1,"South Korea"),(2,"Canada"),(3,"Mexico"),(4,"Argentina"),(5,"Brazil"),(6,"United Kingdom"),(7,"France"),(8,"Italy"),
      (9,"Ireland"),(10,"Germany"),(11,"Spain"),(12,"Portugal"),(13,"Switzerland"),(14,"Finland"),(15,"Iceland"),(16,"India"),(17,"Italy"),
      (18,"Japan"), (19,"China"),(20,"Russia"),(21,"Montenegro"),(22,"New Zealand"),(23,"Turkey"),(24,"Serbia"),(25,"Australia"))

    val countrynum = Random.nextInt(25)
    val country = countries(countrynum)
    return country
  }

  def getWebsite(): String= {
    val websites = List("www.Amazon.com", "www.Wal-Mart.com",
      "www.Target.com", "www.Ebay.com")
    val ifcase = Random.nextInt(30)
    if(ifcase == 1){
      return "other"
    }
    val website = websites(Random.nextInt((websites.length)))
    return website
  }
  def randomtxn(): String ={
    val ranChar= Random.nextPrintableChar()
    val ranChar1= Random.nextPrintableChar()
    val rannum = Random.nextInt(5000)
    val rannum1 = Random.nextInt(5000)
    val txn: String = ranChar + rannum.toString + ranChar1 + ranChar+ rannum1.toString
    return txn

  }
  def getTXN(): String = {
    val yOrN = List("Y", "N")
    val decision = yOrN(Random.nextInt(yOrN.length))
    return decision
  }
  def getFailureReason(txn: String): String = {
    if(txn  == "Y"){
      return ""
    }else{
      val fReason = List("expired card",
        "no inventory",
        "payment gateway is misconfigured",
        "blocked by merchant account",
        "incorrectly entered information",
        "account has been closed",
        "insufficient funds",
        "processor declined",
        "purchase made while traveling",
        "Invalid credit card number",
        "Credit card type isn’t accepted")
      val reason = fReason(Random.nextInt(fReason.length))
      return reason
    }
  }
  //creates a csv
  def makeCSV(csvValues: List[String]) = {
    //csvValues.map(s => "\""+s.replace("\"", "\\\"").replace(",", "\\,")+"\"").mkString(",") + "\n";
    pw.write(csvValues.mkString(",") + "\n")
  }

}

