public class Round
{  
    private Area firstArea;
    
        public Round () {
        //Create a round with no areas
        firstArea = null;
        
    }
    
    public void addArea (Area areaToAdd) {
        
        //if the round is empty
        if(firstArea == null) {   
            //set the given area to be the first area
            firstArea = areaToAdd;         
        }
        
        else {
            //otherwise grab the first area
            Area current = firstArea;
            //Loop through the list of areas
            while(current.getNextArea() != null) {
                                
            current = current.getNextArea();
            
        }
        //Add the given area to the end
        current.setNextArea(areaToAdd);
        }
    }
    
    public int roundValue () {
        
        //define a variable to hold the total
        int sum = 0;
        //grab the first area
        Area current = firstArea;
        //loop through the list 
        while (current != null) {
            //adding the sum of each area to the total
            sum += current.areaValue();
            current = current.getNextArea();
        }
        //return the total sum of the round
        return sum;
    }
    
    public Customer findCustomerRound (int doorNo, String road) {        
        //Define a boolean to check whether we found the customer
        boolean found = false;        
        //Grab the first item on the list and store it in current
        Area current = firstArea;        
        //Keep going until the end of the list
        while(current!=null){         
         //Call the method from area to find the customer 
         //Store the result in search
         Customer search = current.findCustomerArea(doorNo,road);         
         //If we have located the customer
         if(search != null) {            
             //Print out where it was located
             System.out.println(doorNo + " " + road +  " was found in "
             + current.getAreaName());
             //Set found to true
             found = true;
             //Return the customer
             return search;             
            }         
            //If not repeat until the end of the list
         current = current.getNextArea();
        }
        //If the customer still wasn't located
        if(found == false) {
            //Print where it was not found
         System.out.println(doorNo + " " + road + " was NOT found");   
        }
        //return nothing
        return null;
    }
}
