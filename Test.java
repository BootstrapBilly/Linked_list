public class Test
{
    public static boolean failed = false;
    
    public static void testEqualsInt (int result, int expected) {
     
        if(result == expected) {
         
            System.out.println("The expected value " + expected +
            " matches the result " + result);
            
        } else {
         failed = true;
         System.out.println("ERROR : The expected value does not the result");
        }
    }
    
    public static String arrayToString (int[] array) {
    String result = "";

    result += "[";
    for (int i=0; i<array.length; i+=1) {
        result += array[i] + ", ";
    }
    result += "]";

    return result;
}

    public static void testEqualIntArrays (int[] result, int[] expected) {
  boolean equalArrays = true;

  if (result.length != expected.length) {
    equalArrays = false;
  } else {
    for (int i=0; i<result.length; i=i+1) {
      if (result[i] != expected[i]) {
        equalArrays = false;
      }
    }
  }

  if (!equalArrays) {
    System.out.println ("ERROR : the result " + arrayToString(result) +
                        " does not equal the expected " + arrayToString(expected));
                        failed = true;
  } 
  else {
      System.out.println ("The result " + arrayToString(result) +
                        " does equal the expected " + arrayToString(expected));
    }
}

    public static void testEqualsCustomer (Customer result, Customer expected) {
     
        if(result == expected) {
            
            if(result != null){
            System.out.println("\nThe expected value : " + expected.getDoorNo() +
            " " + expected.getRoad() + "\n\nmatches the result : \n" + result.showDetails()
            + "\n");
        
        } else {
            System.out.println("\nThe expected value(null) matches the result(null)");
        }
        } else {
         failed = true;
         System.out.println("ERROR : The expected value does not the result");
        }
    }
    
    public static void main (String[] args){
       
        //                      Data simulation 
        //                      Starts
        //                      Here
        
        //-----------------------Create Round----------------------//
        Round round = new Round();
                               
        //-----------------------Create Areas----------------------//
        Area aveley = new Area("Aveley");
        Area colchester = new Area("Colchester");
        Area maldon = new Area("Maldon");
        Area mayland = new Area("Mayland");
        
              //----------Add areas to round---------//
                    round.addArea(aveley);
                    round.addArea(colchester);
                    round.addArea(maldon);
                    round.addArea(mayland);
        
        //-----------------------Create Days----------------------//
        //I am only simulating 1-2 days for each area to demonstrate 
        //my program
        
        //Aveley
        Day a1 = new Day("Aveley", 1);
        
        //Colchester
        Day c1 = new Day("Colchester", 1);
        Day c2 = new Day("Colchester", 2);//This will be an empty day
                                          //For testing my AreaValue method
        //Maldon
        Day md1 = new Day("Maldon", 1);
       
        //Mayland
        Day m1 = new Day("Mayland", 1);
        Day m2 = new Day("Mayland", 2);
        
                  //----------Add days to areas---------//
                    aveley.addDay(a1);
                    colchester.addDay(c1);
                    colchester.addDay(c2);//Empty day
                    maldon.addDay(md1);
                    mayland.addDay(m1);
                    mayland.addDay(m2);
        
        //-----------------------Create Customers----------------------------//
        
        //I am also only including a snippet of customers as an example
        //as I feel that hardcoding over 400 customers will be unnesessary 
        
        //Aveley -  Day 1 (One customer only for testing)
        Customer A1_1 = new Customer(1,12,"Example road",4,14,"Mr A",
        "Cm1 1dr", null, null);
        
        //Colchester - Day 1 (Price descending to test sort method)
        Customer C1_1 = new Customer(1,233,"Test road",4,12,"Jeff",
        null, null, null);
        Customer C1_2 = new Customer(2,23,"Test road",8,11,"Harry",
        null, null, null);
        Customer C1_3 = new Customer(3,11,"Another cresent",4,10,null,
        "Co1 2fx", "07777,777,776", null);
        Customer C1_4 = new Customer(4,61,"South close",4,8,"Anna",
        "Co4 9fh", null, null);
        Customer C1_5 = new Customer(5,42,"Navigation road",4,6,"Mr x",
        null, null, null);
        
        //Maldon - Day 1 (Has dupilcate prices to test sort method)
        Customer MD1_1 = new Customer(1,12,"New avenue",4,15,"paulius",
        "Md1 1dm", "07777,777,776", null);
        Customer MD1_2 = new Customer(2,423,"Fake road",8,15,null,
        null, null, null);
        Customer MD1_3 = new Customer(3,34,"Simulate street",4,23,null,
        null, null, null);
        Customer MD1_4 = new Customer(4,54,"Endless drive",4,9,"David Davidson",
        null, null, null);
        Customer MD1_5 = new Customer(5,93,"Diagon alley",4,19,"Hagrid",
        "Md4 4dm", null, null);
        
        //Mayland - Day 1 (A day with 4 customers for testing)
        Customer M1_1 = new Customer(1,1,"Road Road",4,6,"paulius",
        null, "07777,777,775", null);
        Customer M1_2 = new Customer(2,139,"Avenue avenue",8,12,null,
        "Ma9 7dr", null, null);
        Customer M1_3 = new Customer(3,22,"Street street",4,32,null,
        null, null, null);
        Customer M1_4 = new Customer(4,92,"Driving drive",8,5,null,
        "Ma9 9ma", "07777,777,779", null);
        
        //Mayland - Day 2 (A second day on mayland for testing)
        Customer M2_1 = new Customer(1,1,"This road",4,11,"Piano man",
        null, "07777,777,775", null);
        Customer M2_2 = new Customer(2,139,"Is avenue",8,45,"Peter Lane",
        "Ma9 7de", null, "House with gold door");
        Customer M2_3 = new Customer(3,22,"Long street",4,23,null,
        null, null, "Knock first");
        Customer M2_4 = new Customer(4,92,"Im drive",4,9,null,
        "Ma9 9ma", "07777,777,779", null);
        Customer M2_5 = new Customer(5,9001,"Bored endz",4,19,"Big man",
        null, null, null);
        Customer M2_6 = new Customer(6,1,"Bored endz",4,19,"Small man",
        null, null, null);
        
        
                    //----------Add Customers to days---------//
                    //Aveley - Day 1
                    a1.addCustomer(A1_1);
                    
                    //Colchester - Day 1
                    c1.addCustomer(C1_1);
                    c1.addCustomer(C1_2);
                    c1.addCustomer(C1_3);
                    c1.addCustomer(C1_4);
                    c1.addCustomer(C1_5);
                    
                    //Maldon - Day 1
                    md1.addCustomer(MD1_1);
                    md1.addCustomer(MD1_2);
                    md1.addCustomer(MD1_3);
                    md1.addCustomer(MD1_4);
                    md1.addCustomer(MD1_5);
                    
                    //Mayland - Day 1
                    m1.addCustomer(M1_1);
                    m1.addCustomer(M1_2);
                    m1.addCustomer(M1_3);
                    m1.addCustomer(M1_4);
                    
                    //Mayland - Day 2
                    m2.addCustomer(M2_1);
                    m2.addCustomer(M2_2);
                    m2.addCustomer(M2_3);
                    m2.addCustomer(M2_4);
                    m2.addCustomer(M2_5);
                    m2.addCustomer(M2_6);
                    

        //                      .value()            
        //                      Testing
        //                      Starts
        //                      Here
        
        System.out.println("\n-----Test the .value() method for day, area and round-----");                        
                            
                        //-----Days------//
                            
        System.out.println("\n        -----Days-----");
        System.out.println("\nThis method adds up the prices of each customer" +
        " in the day");
        
        int a1Value = a1.dayValue();
        int c1Value = c1.dayValue();
        int c2ValueEmpty = c2.dayValue();//Empty day
        int md1Value = md1.dayValue();
        int m1Value = m1.dayValue();
        int m2Value = m2.dayValue();

        System.out.println("\nAveley 1(1 Customers) -> dayValue()");
        testEqualsInt(a1Value,14); 
        
        System.out.println("\nColchester 1(5 Customers) -> dayValue()");
        testEqualsInt(c1Value,47); 
        
        System.out.println("\nColchester 2(No customers) -> dayValue()");
        testEqualsInt(c2ValueEmpty,0); //Empty day test
        
        System.out.println("\nMaldon 1 -> dayValue()");
        testEqualsInt(md1Value,81); 
        
        System.out.println("\nMayland 1(4 Customers) -> dayValue()");
        testEqualsInt(m1Value,55); //6 customers

        System.out.println("\nMayland 2(6 Customers) -> dayValue()");
        testEqualsInt(m2Value,126); //4 customers
        
                        //-----Areas------//
                        
        System.out.println("\n        -----Areas-----");
        System.out.println("\nThis method adds up the prices of each customer" +
        "\nof every day in the area");
        
        int aveleyValue = aveley.areaValue();
        int colchesterValue = colchester.areaValue();
        int maldonValue = maldon.areaValue();
        int maylandValue = mayland.areaValue();
        
        System.out.println("\nAveley -> areaValue()");
        testEqualsInt(aveleyValue,14); //has a1
        
        System.out.println("\nColchester(has second, empty day) -> areaValue()");
        testEqualsInt(colchesterValue,47); //Has c1 and c2, c2 is empty
        
        System.out.println("\nMaldon -> areaValue()");
        testEqualsInt(maldonValue,81); //has md1
        
        System.out.println("\nMayland(has second, filled day) -> areaValue()");
        testEqualsInt(maylandValue,181); //has m1 and m2, both have values
        
        //make an empty Area
        Area emptyArea = new Area("Empty Area");
        //Get the value of it
        int emptyAreaValue = emptyArea.areaValue();
        //Test it
        System.out.println("\nEmpty Area -> areaValue()");
        testEqualsInt(emptyAreaValue,0); 
                            
                        //-----Round------//
                        
        System.out.println("\n        -----Round-----");
        System.out.println("\nThis method adds up the prices of each customer" +
        "\nof every area in the round");
        
        int roundValue = round.roundValue();
        
        System.out.println("\nWhole round -> roundValue()");
        testEqualsInt(roundValue,323); 
        
        //make an empty round
        Round emptyRound = new Round();
        //Get the value of it
        int emptyRoundValue = emptyRound.roundValue();
        //Test it
        System.out.println("\nAn empty round -> roundValue()");
        testEqualsInt(emptyRoundValue,0); //has md1
        
        //                      .sort() 
        //                      Price
        //                      Testing
        //                      Starts
        //                      Here
        
        System.out.println("\n---Test the sort by price and sort by order method---");
        
        System.out.println("\n     ---Sort by price (Ascending)---");
        System.out.println("\nThis method sorts each day by price" +
        "\nThen returns an array of the rearranged order numbers" +
        "\nAs the order numbers are not swapped during the swapping,"
        + "\nI can test the expected new order" +
        "\nAll days are in numeric order before they are sorted(1,2,3,4,5)");
        
        //dAY WITH 1 CUSTOMER aveley
        int[] sortedAveley1Result = a1.sort();
        int[] sortedAveley1Expected = {1};
        
        System.out.println("\nA day with 1 customer, Aveley 1");
        testEqualIntArrays(sortedAveley1Result, sortedAveley1Expected);
        
        //A descending price day where prices get lower by each customer
        //opposite to what we want when sorting 
        int[] sortedColchester1Result = c1.sort();
        int[] sortedColchester1Expected = {5,4,3,2,1};
        
        System.out.println("\nA price descending day, Colchester 1");
        testEqualIntArrays(sortedColchester1Result, sortedColchester1Expected);
        
        //An empty day
        int[] sortedColchester2Result = c2.sort();
        int[] sortedColchester2Expected = {};
        
        System.out.println("\nAn empty day, Colchester 2");
        testEqualIntArrays(sortedColchester2Result, sortedColchester2Expected);
        
        //A regular day
        int[] sortedMayland1Result = m1.sort();
        int[] sortedMayland1Expected = {4,1,2,3};
        
        System.out.println("\nA regular day, Mayland1");
        testEqualIntArrays(sortedMayland1Result, sortedMayland1Expected);
        
        //                      .sort() 
        //                      Order
        //                      Testing
        //                      Starts
        //                      Here
        
        System.out.println("\n     ---Sort by order (Ascending)---");
        System.out.println("\nThis method sorts each day by order" +
        "\nThen returns an array of the rearranged order numbers" +
        "\nAs the order numbers are not swapped during the swapping,"
        + "\nI can test the expected new order" +
        "\nAll days are in price order, from the tests above" +
        "\nNow they will be sorted back into their orignal order(Most Efficient route)");
        
        //dAY WITH 1 CUSTOMER aveley
        int[] orderSortedAveley1Result = a1.sortByOrder();
        int[] orderSortedAveley1Expected = {1};
        
        System.out.println("\nA day with 1 customer, Aveley 1");
        testEqualIntArrays(orderSortedAveley1Result, orderSortedAveley1Expected);
        
        //A descending order day where order gets lower by each customer
        //opposite to what we want when sorting       
        int[] orderSortedColchester1Result = c1.sortByOrder();
        int[] orderSortedColchester1Expected = {1,2,3,4,5};
       
        System.out.println("\nA price descending day, Colchester 1");
        testEqualIntArrays(orderSortedColchester1Result, orderSortedColchester1Expected);
        
        //An empty day
        int[] orderSortedColchester2Result = c2.sortByOrder();
        int[] orderSortedColchester2Expected = {};
        
        System.out.println("\nAn empty day, Colchester 2");
        testEqualIntArrays(orderSortedColchester2Result, orderSortedColchester2Expected);
        
        //A regular day
        int[] orderSortedMayland1Result = m1.sortByOrder();
        int[] orderSortedMayland1Expected = {1,2,3,4};
        
        System.out.println("\nA regular day, Mayland1");
        testEqualIntArrays(orderSortedMayland1Result, orderSortedMayland1Expected);
        
        //                      .findCustomer() 
        //                      Testing
        //                      Starts
        //                      Here
        
                        //-----Days------//
                        
        System.out.println("\n     ---Search a day for a customer---");                
        System.out.println("\nThis method searches through the day" +
        "\nLooking for a customer by their door number and road" +
        "\nIf it finds them, it returns the whole customer"
        + "\nIf not it returns null\n");
        
        
        //A regular customer
        System.out.println("Find a regular customer in a day with 1 customer(aveley)");
        Customer firstResult = a1.findCustomerDay(12,"Example road");
        Customer firstExpected = A1_1;        
        
        testEqualsCustomer(firstResult, firstExpected);
        
        //An empty day
        System.out.println("Search an empty day for a customer");
        Customer emptyResult = c2.findCustomerDay(12,"Example road");
        Customer emptyExpected = null;        
        
        testEqualsCustomer(emptyResult, emptyExpected);
        
        //A customer that doesnt exist
        System.out.println("\nSearch for a customer that doesnt exist");
        Customer nullResult = m2.findCustomerDay(12,"Not in database");
        Customer nullExpected = null;        
        
        testEqualsCustomer(nullResult, nullExpected);
        
        //Last customer in a day
        System.out.println("\nSearch for the last customer in a day");
        Customer lastResult = m1.findCustomerDay(92,"Driving drive");
        Customer lastExpected = M1_4;        
        
        testEqualsCustomer(lastResult, lastExpected);
        
                                //-----Area------//
                        
        System.out.println("\n     ---Search an area for a customer---");                
        System.out.println("\nThis method searches through each day in an area" +
        "\nIt does so by calling the findCustomer method from days" +
        "\nWalking the list of days until it finds the customer or reaches the end" +
        "\nIf it finds them, it returns the whole customer"
        + "\nIf not it returns null\n");
        
        //Regular area
        System.out.println("\nSearch for a regular customer in a regular area");
        Customer areaResult = mayland.findCustomerArea(22,"Street street");
        Customer areaExpected = M1_3;        
        
        testEqualsCustomer(areaResult, areaExpected);
        
        //An empty area
        System.out.println("Search an empty area for a customer");
        Customer emptyAreaResult = emptyArea.findCustomerArea(12,"Example road");
        Customer emptyAreaExpected = null;        
        
        testEqualsCustomer(emptyAreaResult, emptyAreaExpected);
        
        //A customer that doesnt exist
        System.out.println("\nSearch for a customer that doesnt exist");
        Customer nullAreaResult = colchester.findCustomerArea(12,"Not in database");
        Customer nullAreaExpected = null;        
        
        testEqualsCustomer(nullAreaResult, nullAreaExpected);
        
        //Last customer in a day, in the last area
        System.out.println("\nSearch for the last customer in a day, in the last day");
        Customer lastAreaResult = mayland.findCustomerArea(1,"Bored endz");
        Customer lastAreaExpected = M2_6;        
        
        testEqualsCustomer(lastAreaResult, lastAreaExpected);
        
                                        //-----Round------//
                        
        System.out.println("\n     ---Search a round for a customer---");                
        System.out.println("\nThis method searches through each Area in a round" +
        "\nIt does so by calling the findCustomer method from Area" +
        "\nWalking the list of areas until it finds the customer or reaches the end" +
        "\nIf it finds them, it returns the whole customer"
        + "\nIf not it returns null\n");
        
        //Regular area
        System.out.println("\nSearch for a regular customer in a regular round");
        Customer roundResult = round.findCustomerRound(22,"Street street");
        Customer roundExpected = M1_3;        
        
        testEqualsCustomer(roundResult, roundExpected);
        
        //An empty area
        System.out.println("Search an empty round for a customer");
        Customer emptyRoundResult = emptyRound.findCustomerRound(12,"Example road");
        Customer emptyRoundExpected = null;        
        
        testEqualsCustomer(emptyRoundResult, emptyRoundExpected);
        
        //A customer that doesnt exist
        System.out.println("\nSearch for a customer that doesnt exist");
        Customer nullRoundResult = round.findCustomerRound(12,"Not in database");
        Customer nullRoundExpected = null;        
        
        testEqualsCustomer(nullRoundResult, nullRoundExpected);
        
        //Last customer in a day, in the last area
        System.out.println("\nSearch for a customer in the last day, in the last area");
        Customer lastRoundResult = round.findCustomerRound(1,"Bored endz");
        Customer lastRoundExpected = M2_6;        
        
        testEqualsCustomer(lastRoundResult, lastRoundExpected);
        
        //check if any tests failed
        if(failed){
         System.out.println("\nOne or more tests failed");   
        } else {
         System.out.println("\nAll Tests Passed!");   
        }
        
    }
}
