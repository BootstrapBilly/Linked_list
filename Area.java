public class Area
{
    //Name of area - for display purposes
    private String areaName;
    //The first day in the list
    private Day firstDay;
    //Link to the next area(used by round)
    private Area nextArea;
    
    public Area (String areaName) {
        this.areaName = areaName;
        //Creates a new area with no days
        firstDay = null;   
    }
    
    //accessor for nextArea(Used by round)
    public Area getNextArea(){return this.nextArea;}
    
    //Mutator for next area (Used by round)
    public void setNextArea(Area nextArea){this.nextArea = nextArea;}
    
    //Accessor for area name - used for display purposes
    public String getAreaName() {return this.areaName;}
    
    public void addDay (Day dayToAdd) {
        
        //If the area is empty
        if(firstDay == null) { 
            //Set the first day to the given day
            firstDay = dayToAdd;            
        }
        
        else {  
            //Otherwise grab the first day
            Day current = firstDay; 
            //loop through the area
            while(current.getNextDay() != null) {                                
            current = current.getNextDay();        
        }
        //add the given day on to the end
        current.setNextDay(dayToAdd);
        }
    }
    
    public void showDays () {
            
            //Grab the first day
            Day current = firstDay;
           
            //Display what area it is
            System.out.println(areaName + " has the following days");
            
            //Loop through the list of days
            while(current != null) {
            
            //Printing out each day
            System.out.println (" -> " + current.getArea() + 
            " " + current.getNumber());
            
            current = current.getNextDay();

        }
    }
    
    public int areaValue () {
        
        //Define a total
        int sum = 0;
        //Grab the first day and store it in current
        Day current = firstDay;
        
        //loop through the list of days
        while (current != null) {
            //adding the sum of each day to the total
            sum += current.dayValue();
            current = current.getNextDay();
        }
        //return the value of the area
        return sum;
    }
    
    public Customer findCustomerArea(int doorNo, String road){        
        //Define a boolean to check whether the customer is found
        boolean found = false;        
        //Grab the first day in the list
        Day current = firstDay;        
        //keep going until the end of the list
        while(current!=null){        
         //call the method from day to see if the current customer matches the search
         //Store the result in search variable
         Customer search = current.findCustomerDay(doorNo,road);         
         //If we have located the customer
         if(search != null) {           
             //print where it is found
             System.out.println("->" + doorNo + " " + road + " IS in " 
             + areaName + "\n");
             //Set found to true
             found = true;
             //return the customer
             return search;             
            } 
         //If not, repeat until the end of the list
         current = current.getNextDay();
        }
        //If we did not find the customer
        if(found == false) {
            //Print where it was not found
         System.out.println("->" + doorNo + " " + road + " is NOT in " 
         + areaName + "\n");   
        }
        //return nothing
        return null;
    }
}