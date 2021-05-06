#Table creation:: 

Drop Table If Exists CartItem, Item, Address, Seller, Customer, Cart, Account; 
Create Table Account( 
	Account_ID INT not Null, 
	FirstName Varchar(10), 
	LastName Varchar(10),  
	Email Varchar(30), 
	Phone Varchar(12), 
	IsSeller Boolean not null, 
	Primary key (Account_ID) 
); 

Create table Cart( 
	Cart_ID varchar(12) not null, 
	Total  float, 
	Primary key (Cart_ID) 
); 

Create Table Customer( 
	Account_ID int not null,  
	Customer_ID varchar(20) not null, 
	Cart_ID varchar(12) not null, 
	Primary Key (Customer_ID),
	Foreign Key (Account_ID) references Account(Account_ID)
	/*Foreign Key (Cart_ID) references Cart(Cart_ID)*/
);

Create Table Seller( 
	Account_ID int not null,  
	Seller_ID int not null, 
	Company_Name Varchar(30), 
	Primary Key (Seller_ID), 
	Foreign Key (Account_ID) references Account(Account_ID)  
); 

Create table Address( 
	Address_ID int not null, 
	Address varchar(30) not null, 
	City varchar(20) not null, 
	State varchar(20) not null, 
	Account_ID int, 
	Primary Key (Address_ID), 
	Foreign Key (Account_ID) references Account(Account_ID) 
); 

Create table Item( 
	Item_ID int not null, 
	Category varchar(20) not null, 
	ItemPrice float not null, 
	Seller_ID int not null, 
	Primary key (Item_ID), 
	Foreign key (Seller_ID) references Seller(Seller_ID) 
); 

Create Table CartItem( 
	CartItem_ID varchar(12) not null, 
	Quantity int, 
	Purchased boolean, 
	OrderDate varchar(12),  
	OrderStatus varchar(10) not null, 
	Item_ID int not null, 
	Cart_ID varchar(12) not null,  
	Address_ID int not null, 
	Primary Key (CartItem_ID),
	Foreign Key (Cart_ID) references Cart(Cart_ID), 
	Foreign Key (Item_ID) references Item(Item_ID), 
	Foreign Key (Address_ID) references Address(Address_ID) 
); 

 
#CSV Load data:: 

LOAD DATA LOCAL INFILE 'EXCELDATA/Accounts.txt'  
INTO TABLE Account 
FIELDS TERMINATED BY ','  
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

LOAD DATA LOCAL INFILE 'EXCELDATA/Customer.txt' 
INTO TABLE Customer 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n'
IGNORE 1 ROWS; 

LOAD DATA LOCAL INFILE 'EXCELDATA/Seller.txt' 
INTO TABLE Seller 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS; 

LOAD DATA LOCAL INFILE 'EXCELDATA/Address.txt' 
INTO TABLE Address 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS; 

LOAD DATA LOCAL INFILE 'EXCELDATA/Item.txt' 
INTO TABLE Item 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS; 

LOAD DATA LOCAL INFILE 'EXCELDATA/Cart.txt' 
INTO TABLE Cart 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS; 

LOAD DATA LOCAL INFILE 'EXCELDATA/Cart_Item.txt' 
INTO TABLE CartItem 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
IGNORE 1 ROWS; 

#Update Total column of Cart
Update Cart as C
Set C.Total = (Select Sum(CI.Quantity * I.ItemPrice)
		From (CartItem as CI), (Item as I)
		Where C.Cart_ID = CI.Cart_ID
		And CI.Item_ID = I.Item_ID
		Group by CI.Cart_ID);

#Queries

#1. The top 5 Cities with the most items being shipped there 
Select A.City, A.State, sum(CI.Quantity) 
from Address A, CartItem CI 
Where A.Address_ID = CI.Address_ID
group by A.City
Order by sum(CI.Quantity)
Limit 5;

#2. Top 5 revenue items
select CI.Item_ID, round(sum(I.ItemPrice * CI.Quantity),2) as Revenue 
from CartItem CI, Item I 
Where CI.Item_ID = I.Item_ID and CI.Purchased = TRUE 
Group by CI.Item_ID 
Order by Revenue desc 
Limit 5; 

#3. Locate all the sellers in Louisiana 
select ac.Account_ID 
from Account ac 
left join Address ad 
on ac.Account_ID = ad.Account_ID 
where ad.State = "Louisiana" 
and ac.IsSeller = TRUE;


#4. Top 50% of states with highest number of orders
Select A.State, Count(A.State) as numOrders
From (Address as A)
Right Join (CartItem as CI)
on A.Address_ID = CI.Address_ID
Where CI.OrderStatus in ("pending", "processed")
Group by A.State
Having numOrders > Avg(numOrders)
Order by numOrders desc;

#5. Most Expensive Item Per Category
Select Category,Item_ID, MAX(ItemPrice) as Tot_Price 
From Item 
Group by Category; 


#6. Top Revenue Generating Cities 
Select A.City, A.State, ROUND(I.ItemPrice * CI.Quantity, 1) AS Revenue
From Address A, Item I, CartItem CI 
Where A.Address_ID = CI.Address_ID AND I.Item_ID = CI.Item_ID
Group by A.City
Order by Revenue desc
Limit 5;


#7. Item categories with highest number of sellers 
select Category, count(Seller_ID) as num_sellers 
From Item 
Group by Category 
Order by num_sellers; 

#8. The Top 5 Spenders most purchased Item Category
Select a.FirstName, a.LastName, ct.Total, I.Category AS Top_Category
From Item I, CartItem CI, Account a, Customer c, Cart ct,
	(Select count(I.Category) 
	 From Item I, CartItem CI, Account a, Customer c, Cart ct 
	 Where I.Item_ID = CI.Item_ID 
	 AND c.Cart_ID = CI.Cart_ID 
	 AND CI.Cart_ID = ct.Cart_ID 
	 AND c.Account_ID = a.Account_ID 
	 Group by 	ct.Cart_ID, I.Category 
	 Order by count(I.Category) desc 
	 Limit 1) as top
Where I.Item_ID = CI.Item_ID 
AND c.Cart_ID = CI.Cart_ID 
AND CI.Cart_ID = ct.Cart_ID 
AND c.Account_ID = a.Account_ID
Group by CI.Cart_ID
Order by ct.total desc
Limit 5;


#9. Checks if a product is pending and the purchase is true and the total is over 10 dollars
select  CI.CartItem_ID, round(sum(CI.Quantity*I.ItemPrice),2) as total 
from (CartItem CI) 
Left join Item I 
on CI.Item_ID = I.Item_ID 
where CI.OrderStatus = “pending“ and CI.Purchased = TRUE 
group by CI.CartItem_ID 
having total >= 10.0; 

#10. Find the seller with the most sells
select Seller_ID,count(Seller_ID) as Total_Sells 
from Item 
Group by Seller_ID 
Order by Total_Sells desc  
Limit 5; 
