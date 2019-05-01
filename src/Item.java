import java.time.LocalDate;

public class Item {
String itemName; //user given name of item
double itemCost; //user given cost of item
boolean isWarranty; //comparison of current date to warranty expire date
String warrantyAcquiredDate; //the day the warranty started
String warrantyExpireDate; //the day the warranty is set to expire
String itemAquireDate; //date the item was added
String serialNo;


String dateInt = LocalDate.now().toString();
String noDash = (dateInt.substring(0, 4)+dateInt.substring(5, 7)+dateInt.substring(8, 10));
int usableDate = Integer.parseInt(noDash);
public String toString(){
	return  "ITEM NAME: \""+ itemName +"\" \n"+
			"SERIAL #: \"" + serialNo +"\" \n"+
			"ITEM COST: \""+itemCost+"\" \n"+
			"WARRANTY BEGAN: \""+warrantyAcquiredDate.substring(0, 4)+"/"+warrantyAcquiredDate.substring(4, 6)+"/"+warrantyAcquiredDate.substring(6, 8)+"\" \n"+
			"WARRANTY END: \""+warrantyExpireDate.substring(0, 4)+"/"+warrantyExpireDate.substring(4, 6)+"/"+warrantyExpireDate.substring(6, 8)+"\" \n"+
			"ITEM WAS ADDED ON: \""+itemAquireDate.substring(0, 4)+"/"+itemAquireDate.substring(4, 6)+"/"+itemAquireDate.substring(6, 8)+"\" \n";
}
public String saveToString(){
	return	this.itemName +serialNo +"\n"+
			this.itemName +itemCost +"\n"+
			this.itemName +warrantyAcquiredDate +"\n"+
			this.itemName +warrantyExpireDate   +"\n"+
			this.itemName +itemAquireDate       +"\n";	
}
public Item(String name, double cost, String serialNo, String aquired, String expired, String date){
this.itemName = name;
this.itemCost = cost;
this.serialNo = serialNo;
this.warrantyAcquiredDate = aquired;
this.warrantyExpireDate = expired;
this.itemAquireDate = date;
}

public Item(){
this.itemName = "null";
this.itemCost = -1;
this.serialNo = "00XX00";
this.warrantyAcquiredDate = "00000000";
this.warrantyExpireDate = "00000000";
this.itemAquireDate = "00000000";
}

//--------------------------------------------------------------------------------------------------------------------------------------------
		//THE VALLEY OF SETTERS & GETTERS 
//--------------------------------------------------------------------------------------------------------------------------------------------
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}

public String getSerialNo() {
	return serialNo;
}

public void setSerialNo(String serialNo) {
	this.serialNo = serialNo;
}

public double getItemCost() {
	return itemCost;
}
public void setItemCost(double itemCost) {
	this.itemCost = itemCost;
}


public boolean isWarranty() {
	return isWarranty;
}
public String getWarrantyAcquiredDate() {
	return warrantyAcquiredDate;
}


public void setWarrantyAcquiredDate(String warrantyAquireDate) {
	this.warrantyAcquiredDate = warrantyAquireDate;
}
public String getWarrantyExpireDate() {
	return warrantyExpireDate;
}


public void setWarrantyExpireDate(String warrantyExpireDate) {
	this.warrantyExpireDate = warrantyExpireDate;
}
public String getItemAquireDate() {
	return itemAquireDate;
}
public void setItemAquireDate(String itemAquireDate) {
	this.itemAquireDate = itemAquireDate;
}
}