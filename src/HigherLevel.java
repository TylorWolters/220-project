import java.time.LocalDate;
public class HigherLevel {
TreeNode root = new TreeNode("HomeStead");
//--------------------------------------------------------------------------------------------------------------------------------------------
//BASIC TREENODE FUNCTIONS	 
//--------------------------------------------------------------------------------------------------------------------------------------------
//item name, price, serial #, warranty Start, warranty End, Item was added on
//Add(will also start the )-Remove items, rename the item(and its search name accordingly)
	 public void addItem(String parentName, String newNodeName){
	String dateInt = LocalDate.now().toString(); //grab current date
	String noDash = (dateInt.substring(0, 4)+dateInt.substring(5, 7)+dateInt.substring(8, 10)); //turn date turn it into usable String.


root.add(root, parentName, newNodeName); //create the item
root.getLeaf(root, newNodeName).setItemName(newNodeName); //set the items name to the given name
root.getLeaf(root, newNodeName).setItemAquireDate(noDash); //set aquire date as given date.
}
	 public void renameItem(String itemName, String newItemName){
root.getLeaf(root, itemName).setItemName(newItemName); //using old name, find and change the name of the item.
root.getLeaf(root, itemName).setReferenceName(newItemName); //still using old name to find the node, use the new name to rename the node itself.
}	 
	 public void removeItem(String itemName) {
root.removeLeaf(root, itemName); //remove an item by name using the .removeLeaf method
}

//--------------------------------------------------------------------------------------------------------------------------------------------
// Setters and getters
//--------------------------------------------------------------------------------------------------------------------------------------------
//Set-Get Serial #
	public void setSerialNo(String itemName, String serialNo){
	root.getLeaf(root, itemName).setSerialNo(serialNo);
	}
	public String getSerialNo(String itemName){
	return root.getLeaf(root, itemName).getSerialNo();
	}

//Set-Get Warranty Start Date
	 public void setWarrantyAcquireDate(String itemName, String enteredDate){
root.getLeaf(root, itemName).setWarrantyAcquiredDate(enteredDate);
}
	 public String getWarrantyAcquireDate(String itemName){
return root.getLeaf(root, itemName).getWarrantyAcquiredDate();
}


//Set-get Warranty Expiration Date
	 public void setWarrantyExpireDate(String itemName, String warrantyExpireDate){
	root.getLeaf(root, itemName).setWarrantyExpireDate(warrantyExpireDate);
}
	 public String getWarrantyExpireDate(String itemName){
	 return root.getLeaf(root, itemName).getWarrantyExpireDate();
	 }
	 
//A LifeTime warranty is very misleading, for several reasons. Instead of going into detail, just accept that ~30 years is a reasonable estimate
//if the user has beef with this, they can just manually set it to 1000 years instead, and live in their own false reality.
public void setLifeTimeWarranty(String itemName){
	setYearWarranty(itemName, 30);
}
//warranty is set in time of years, assuming it starts today.
public void setYearWarranty(String itemName, int years){
	String dateInt = LocalDate.now().toString(); //grab current date
	String noDash = (dateInt.substring(0, 4)+dateInt.substring(5, 7)+dateInt.substring(8, 10)); //turn date turn it into usable String.

	root.getLeaf(root, itemName).setWarrantyAcquiredDate(noDash);//set todays date as the warranty start date.
	String year = noDash.substring(0, 4); //grab the year out of todays date (first 4 ints)
		int working_year = Integer.parseInt(year); //turn 4 digit date into an int for math.
		 working_year += years; //add the # of years given to the warranty.
	String working_yearString =Integer.toString(working_year); //Turn it back into a string
	String working_year_full = working_yearString +noDash.substring(4,8); //append current month and date to end of the string
	root.getLeaf(root, itemName).setWarrantyExpireDate(working_year_full); //set full date string as the Warranty expiration date.
	 }
//warranty is set in time of months, assuming it starts today.
public void setMonthWarranty(String itemName, int monthsGiven) {
	String dateInt = LocalDate.now().toString(); //grab current date
	String noDash = (dateInt.substring(0, 4)+dateInt.substring(5, 7)+dateInt.substring(8, 10)); //turn date turn it into usable String.
	
	root.getLeaf(root, itemName).setWarrantyAcquiredDate(noDash);//set todays date as the warranty start date.
	//The first four of our saved date is year.
	String year = noDash.substring(0,4);
	int working_year = Integer.parseInt(year);
	//The next two is our month.
	String month = noDash.substring(4, 6);
	int working_month = Integer.parseInt(month);
	//The last two is our day.
	String day = noDash.substring(6, 8);
	int working_day = Integer.parseInt(day);
	working_month += monthsGiven;
	int year_counter=0;
	while (working_month>12){
		working_month-=12;
		++year_counter;
		}
	
	switch(working_month){//Just a big ol case switch to make sure the expiration date isnt something impossible like February 31st.
	case 1: break;//January has 31 days 
	case 2:if(working_day>28){//February has 28 days
				working_month+=1;
				working_day-=28;
				}
	case 3: break;//March has 31 days
	case 4:if(working_day>30){ //April has 30 days
				working_month+=1;
				working_day-=30;
				}
	case 5:break;//May has 31 days
	case 6:if(working_day>30){//June has 30 days
				working_month+=1;
				working_day-=30;
				}
	case 7:break;//July has 31 days
	case 8:break;//August has 31 days
	case 9:if(working_day>30){//September has 30 days
				working_month+=1;
				working_day-=30;
				}
	case 10:break;//October has 31 days
	case 11:if(working_day>30){//November has 30 days
		working_month+=1;
		working_day-=30;
		}
	case 12:break;//December has 31 days
	default://??? 
		break;
		
	}
	
	
	working_year+=year_counter;
	String working_yearString =Integer.toString(working_year);
	String working_dayString =Integer.toString(working_day);
	String working_monthString = "";
	if (working_month<10) {
		working_monthString =Integer.toString(working_month);
		working_monthString ="0" + working_monthString;
		}
	else{
		working_monthString =Integer.toString(working_month);
		}
	
	
	String working_year_full = working_yearString +working_monthString+working_dayString;
	root.getLeaf(root, itemName).setWarrantyExpireDate(working_year_full);
	}
//warranty is set in time of months, assuming it starts today.
public void setDayWarranty(String itemName, int daysGiven) {
		String dateInt = LocalDate.now().toString(); //grab current date
		String noDash = (dateInt.substring(0, 4)+dateInt.substring(5, 7)+dateInt.substring(8, 10)); //turn date turn it into usable String.
		
		root.getLeaf(root, itemName).setWarrantyAcquiredDate(noDash);//set todays date as the warranty start date.
		//The first four of our saved date is year.
		String year = noDash.substring(0,4);
		int working_year = Integer.parseInt(year);
		//The next two is our month.
		String month = noDash.substring(4, 6);
		int working_month = Integer.parseInt(month);
		//The last two is our day.
		String day = noDash.substring(6, 8);
		int working_day = Integer.parseInt(day);
		working_day += daysGiven;
		
		switch(working_month){//Just a big ol case switch to make sure the expiration date isnt something impossible like February 31st.
		case 1: break;//January has 31 days 
		case 2:if(working_day>28){//February has 28 days
					working_month+=1;
					working_day-=28;
					}
		case 3: break;//March has 31 days
		case 4:if(working_day>30){ //April has 30 days
					working_month+=1;
					working_day-=30;
					}
		case 5:break;//May has 31 days
		case 6:if(working_day>30){//June has 30 days
					working_month+=1;
					working_day-=30;
					}
		case 7:break;//July has 31 days
		case 8:break;//August has 31 days
		case 9:if(working_day>30){//September has 30 days
					working_month+=1;
					working_day-=30;
					}
		case 10:break;//October has 31 days
		case 11:if(working_day>30){//November has 30 days
			working_month+=1;
			working_day-=30;
			}
		case 12:break;//December has 31 days
		default://??? 
			break;	
		}
		int year_counter=0;
		while (working_month>12){
			working_month-=12;
			++year_counter;
			}
		
		working_year+=year_counter;
		String working_yearString =Integer.toString(working_year);
		String working_dayString =Integer.toString(working_day);
		String working_monthString = "";
		if (working_month<10) {
			working_monthString =Integer.toString(working_month);
			working_monthString ="0" + working_monthString;
			}
		else{
			working_monthString =Integer.toString(working_month);
			}
		
		
		String working_year_full = working_yearString +working_monthString+working_dayString;
		root.getLeaf(root, itemName).setWarrantyExpireDate(working_year_full);
		}

//Set-get Price
public void setPrice(String itemName, double itemCost){
root.getLeaf(root, itemName).setItemCost(itemCost);
}
public double getPrice(String itemName){
return root.getLeaf(root, itemName).getItemCost();
}

	 
//--------------------------------------------------------------------------------------------------------------------------------------------
//constructors
//--------------------------------------------------------------------------------------------------------------------------------------------
//default house constructor
public void choice1(){
root.add(root, "HomeStead", "Appliances");
root.add(root, "HomeStead", "Electronics");
root.add(root, "HomeStead", "Tools");
root.add(root, "HomeStead", "Furnishing");
}
//blank house(?)
public void choice2(){
root.add(root, "HomeStead", "add more catagories!");
}

public String toString(String itemName){
	return root.getLeaf(root, itemName).toString();
}
public void printAll() {
	root.traverse(root, 0);	
}
public void printCertain(String startNode) {
	TreeNode hold = root.getLeaf(root, startNode);
	String[] arrayHold=new String[hold.getLeaves().size()];
	for (int i = 0; i < hold.leaves.size(); i++) {
	arrayHold[i]= hold.leaves.get(i).referenceName; 
	}
	for (int i = 0; i < arrayHold.length; i++) {
	System.out.println(arrayHold[i]);
	}
}
}
