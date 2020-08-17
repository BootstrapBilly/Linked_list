public class Customer
{
    //Link to the next customer
    private Customer next;
    //OrderNumber used to sort by Order and display purposes
    private int orderNumber;
    
    //Customer fields - Self explanatory
    private int doorNo;
    private String road;
    //Every 4 or 8 weeks
    private int frequency;
    private int price;
    private String name;
    private String postCode;
    private String phone;
    private String notes;
    

    
    public Customer (int orderNumber, int doorNo, String road, int frequency, int price,
    String name, String postCode, String phone, String notes){
     
        this.orderNumber = orderNumber;
        this.doorNo = doorNo;
        this.road = road;
        this.frequency = frequency;
        this.price = price;
        
        //The following fields are optional
        //If the customer does not have one, null is passed in 
        
        this.name = name == null ? "No Name" : name;
        this.postCode = postCode == null ? "No postCode" : postCode;
        this.phone = phone == null ? "No phone" : phone;
        this.notes = notes == null ? "No notes" : notes;
        
        //The conditional statement says 
        //"Is the notes null?"
        //If it is, replace null with No notes
        //If not, set it to the value supplied
    }
    
    // accessor for 'next' (Used by Day)
    public Customer getNext () { return next;}
    // mutator for 'next' (Used by Day)
    public void setNext (Customer next) {this.next = next;}
    
    // accessor for 'orderNumber'
    public int getOrder () { return orderNumber;}
    //Mutator for setOrder
    public void setOrder(int orderNumber) {this.orderNumber = orderNumber;}
    
    // accessor for 'doorNo'
    public int getDoorNo () { return doorNo;}
    // mutator for 'doorNo'
    public void setDoorNo (int doorNo) {this.doorNo = doorNo;}
    
    // accessor for 'road'
    public String getRoad () { return road;}
    // mutator for 'road'
    public void setRoad (String road) {this.road = road;}
    
    // accessor for 'frequency'
    public int getFrequency () { return frequency;}
    // mutator for 'frequency'
    public void setFrequency (int frequency) {this.frequency = frequency;}
    
    // accessor for 'frequency'
    public int getPrice () { return price;}
    // mutator for 'frequency'
    public void setPrice (int price) {this.price = price;}
    
    // accessor for 'name'
    public String getName () { return name;}
    // mutator for 'name'
    public void setName (String name) {this.name = name;}
    
    // accessor for 'PostCode'
    public String getPostCode() { return postCode;}
    // mutator for 'PostCode'
    public void setPostCode(String postCode) {this.postCode = postCode;}
    
    // accessor for 'Phone'
    public String getPhone() { return phone;}
    // mutator for 'Phone'
    public void setPhone(String phone) {this.phone = phone;}
    
    // accessor for 'Notes'
    public String getNotes() { return notes;}
    // mutator for 'Notes'
    public void setNotes(String notes) {this.notes = notes;}
       
    public void addCustomer(Customer customer){
        
        //Grab the first customer and store it in current variable
        Customer current = this;

        // walk the list to find the last item
        while (current.getNext () != null) {
            current = current.getNext ();
        }
        
        //add the given customer the end of the list
        //The new customer gets inserted after the last customer
        current.setNext(customer);
    }
    
    public String showDetails () {
        
        //Display method - Self Explanatory 
        
        return "\nCustomer " + orderNumber + "\nAddress : " + doorNo + " " + road 
        + "\nFrequency : " + frequency + "\nPrice : " +  price + "\nOptional details : " + name
        + ", " + postCode + ", " + phone + "\nNotes : " + notes;
        
    }
    
    
}
