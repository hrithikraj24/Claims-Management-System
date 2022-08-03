insert into member(member_Id,member_Name, phone_No , address ) 
values('admin','jeffrin' , 234569874 , 'coimbatore');

insert into member(member_Id,member_Name, phone_No , address ) 
values('user1','aditi' , 234569874 , 'mumbai');

insert into member(member_Id,member_Name, phone_No , address ) 
values('user2','dhanushah' , 234569874 , 'chennai');


insert into Member_Policy(member_Id , policy_Id)
values('admin' , 1000);

insert into Member_Policy(member_Id , policy_Id)
values('user1' , 1000);

insert into Member_Policy(member_Id , policy_Id)
values('user2' , 2000);

insert into Member_Premium(member_Id , premium_due, last_Paid_Date , policy_Id , due_Date, payment_Details)
values ('admin' , 2500 , '2020-06-01', 1000 ,'2022-06-01', 'debitcard');

insert into Member_Premium(member_Id , premium_due, last_Paid_Date , policy_Id , due_Date, payment_Details)
values ('user1' , 3500 ,'2020-05-05', 1000 ,'2022-05-09', 'creditcard');

insert into Member_Premium(member_Id , premium_due , last_Paid_Date, policy_Id , due_Date, payment_Details)
values ('user2' , 4500 ,'2020-01-04', 2000 ,'2022-04-01', 'upi');

