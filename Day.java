import java.util.Scanner; 

public class Day
{
    //Used to grab the first customer in the list
    private Customer firstCustomer;
    //Name of area where the day is, Used for display purposes
    private String area;
    //Number of day (e.g Colchester 1) - Used for display purposes
    private int number;
    //Link to the next day
    private Day nextDay;
    
    //Used to return an empty array if a sort is used on an empty day
    private static final int[] emptyArray = {};
    
    //Takes in the area and number for display purposes
    public Day (String area, int number) {
      //Creates a day with no customers
      firstCustomer = null;
      //Sets the area and number of the day
      this.area = area;
      this.number = number;
    }
    
    //Accessor to get the next Day(Used by Area)
    public Day getNextDay() { return this.nextDay;}
    //Mutator to set the next day(Used by Area)
    public void setNextDay(Day nextDay) {this.nextDay = nextDay;}
    
    //Accessor for area - used for display purposes
    public String getArea() {return area;}
    
    //Accessor for number - used for display purposes
    public int getNumber() {return number;}   
    
    public void addCustomer (Customer customer){
        
        //if the day is empty
        if(firstCustomer == null) { 
            //set the given customer to be the first
            firstCustomer = customer;            
        }      
        else {
            //Otherwise, call the method from customer to add the customer
            //to the end of the day
            firstCustomer.addCustomer(customer);
        }
    }
    
    public void showCustomers () {
        
        System.out.println("\n" + area + " " + number + " has the following customers :");
        
        //Grab the first customer
        Customer current = firstCustomer;
        
        //Walk the list
        while (current != null) {
            
            //Printing out each customer in turn
            System.out.println(current.showDetails());
            current = current.getNext ();
            
        }
         
    }
    
   public Customer findCustomerDay(int doorNo, String road) {        
       //Define a boolean to check whether we found the customer
        boolean found = false;       
        //Grab the start of the list of customers
        //Store it in current variable
        Customer current = firstCustomer;        
        //Keep going until the end of the list is reached
        while (current != null) {            
            //If we a door and road match, we have found the customer
            if(current.getRoad() == road && current.getDoorNo() == doorNo) {
                //Set found to true
                found = true;
                //Print out where we found it
                System.out.println(doorNo + " " + road + " was found in "
                + area + " " + number);
                //Return the customer
                return current;
            }
            //If a match wasnt found, move to the next customer and repeat
            current = current.getNext ();        
        }   
        //If we get to the end and the customer isn't found
        if(found == false) {
            //Print out where it wasnt found
         System.out.println(doorNo + " " + road + " was NOT found in "
         + area + " " + number);   
        }
        //Return nothing
        return null;
    }
    
    
    public int[] sort(){        
        //Define a variable to count the customers
        int customerCount = 0;        
        //Grab the first customer and store it in current
        Customer current = firstCustomer;        
        //If the day is empty
        if(firstCustomer == null) {
            //Return the empty Array defined at the top
         return emptyArray ;   
        }        
        //Walk the list of customers
        while(current != null) {           
            //Find the lowest customer
            Customer lowest = findLowestPrice(current);
            //Swap it with the current(top)
            swap(current, lowest);            
            //Add 1 to the customer count
            customerCount += 1;
            //Move onto the next customer (increasing the top by 1)
            current = current.getNext();           
        }        
        //Create an array to hold the order number of each customer
        int[] orderArray = new int[customerCount];
        //Go back to the start of the (now sorted by price) list
        current = firstCustomer;  
        //Define an int used to fill the array
        int i = 0;        
        //loop through the (sorted) list again
        while(current != null) {
            //Fill the array with the order number at the current index
            orderArray[i] = current.getOrder();
            //move on to the next index of the list
            current = current.getNext();
            //move on to the next index of the array
            i++;
            //repeat until we have an array with the order of the
            //sorted array
        }     
        //return it
        return orderArray;
    }
    
    //This method is almost identical to the above
    public int[] sortByOrder(){
        
        int customerCount = 0;
        
        Customer current = firstCustomer;
        
        if(firstCustomer == null) {
         return emptyArray ;   
        }
        
        while(current != null) {
            
            //Except we find the lowest order Number instead of price
            Customer lowest = findOrder(current);
            swap(current, lowest);
            
            customerCount += 1;
            current = current.getNext();
            
        }
        //^ Now we have an array sorted by order(most efficient route)
        //Next we fill an array with the new order of customers
        int[] orderArray = new int[customerCount];        
        current = firstCustomer;        
        int i = 0;
        
        while(current != null) {
            
            orderArray[i] = current.getOrder();
            current = current.getNext();
            i++;
        }
        
        return orderArray;
    }
       

    //Takes in the place to start(current item on the list)
    //Used for the selection sort
    public Customer findLowestPrice(Customer start) {        
        //Grab the first customer store it in currentCustomer
        Customer currentCustomer = start;
        //Define smallest and set it to the price of the first customer
        int smallest = currentCustomer.getPrice();        
        //define a return value and set it to the first customer
        Customer returnValue = currentCustomer;       
        //loop through the list
        while(currentCustomer != null) {
            //If we find a price thats lower than the current lowest
            if(currentCustomer.getPrice() < smallest){
                //Set that price to be the new smallest
                smallest = currentCustomer.getPrice();
                //And set that customer to the return value
                returnValue = currentCustomer;
            }
            currentCustomer = currentCustomer.getNext();           
        }       
        //Return the lowest priced customer
        return returnValue;
    }
    
    //This method is also almost identical to the price version
    public Customer findOrder(Customer start) {        
        Customer currentCustomer = start;
        
        int smallest = currentCustomer.getOrder();
        
        Customer returnValue = currentCustomer;
        
        while(currentCustomer != null) {
            //except it finds the lowest order, not price
            if(currentCustomer.getOrder() < smallest){
                smallest = currentCustomer.getOrder();
                returnValue = currentCustomer;
            }
            currentCustomer = currentCustomer.getNext();
            //currentIndex +=1;
        }
        
        return returnValue;
    }
    
    public void swap(Customer firstCustomer, Customer secondCustomer){
        //this method is self explanatory and swaps every value
        //from the first and second customer  
        
        //grab set the given customers to c1 and c2
        Customer c1 = firstCustomer;
        Customer c2 = secondCustomer;
        //Store the next values for c1 and c2
        Customer tNext = c1.getNext();
        Customer tNext2 = c2.getNext();    
        //store all of c1s values into temp values
        int tOrderNo = c1.getOrder();
        int tDoorNo = c1.getDoorNo();
        String tRoad = c1.getRoad();
        int tFrequency = c1.getFrequency();
        int tPrice = c1.getPrice();
        String tName = c1.getName();
        String tPostCode = c1.getPostCode();
        String tPhone = c1.getPhone();
        String tNotes = c1.getNotes();
        //Set all of c1s values to c2's values
        c1.setOrder(c2.getOrder());
        c1.setDoorNo(c2.getDoorNo());
        c1.setRoad(c2.getRoad());
        c1.setFrequency(c2.getFrequency());
        c1.setPrice(c2.getPrice());
        c1.setName(c2.getName());
        c1.setPostCode(c2.getPostCode());
        c1.setPhone(c2.getPhone());
        c1.setNotes(c2.getNotes()); 
        //Set all of c2's values to the temp values (t1's old values)
        c2.setOrder(tOrderNo);
        c2.setDoorNo(tDoorNo);
        c2.setRoad(tRoad);
        c2.setFrequency(tFrequency);
        c2.setPrice(tPrice);
        c2.setName(tName);
        c2.setPostCode(tPostCode);
        c2.setPhone(tPhone);
        c2.setNotes(tNotes); 
        
        c1.setNext(tNext);
        c2.setNext(tNext2);      
    }
    
    public int dayValue (){
        
        //define an integer to hold the total sum
        int sum = 0;
        //grab the first customer and store it in current
        Customer current = firstCustomer;
        //loop through the list of customers
        while(current != null) {
            //adding every customer to the total
            sum += current.getPrice();
            current = current.getNext();
        }
        //return the total
        return sum;
    }
}
