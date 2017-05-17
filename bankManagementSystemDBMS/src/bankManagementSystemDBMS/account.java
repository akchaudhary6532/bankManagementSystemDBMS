package bankManagementSystemDBMS;

import java.sql.ResultSet;
import java.util.Scanner;

public class account {
	Scanner scn=new Scanner(System.in);
	Input run=new Input();
	public void new_acc() {
		
		// TODO Auto-generated method stub
		System.out.println("Enter Bank Code(String):");
	    String code=scn.next();          
	    System.out.print("\tEnter Bank Name(String):");
	    String name=scn.next();
	    System.out.print("\tEnter Branch code(Int):");
	    int bbcode=scn.nextInt();
	    System.out.print("\tEnter acc_no(int):");
	    int acc_no=scn.nextInt();
	    System.out.print("\tEnter Account Type(String):");
	    String type=scn.next();
	    String sql="insert into bank(code,name) values('"+code+"','"+name+"')";
	    String sql1="insert into bank_branch(bkcode,bbcode) values('"+code+"',"+bbcode+")";
	    String sql2="insert into account(acc_no,type,bkcode,bbcode) values("+acc_no+",'"+type+"','"+code+"',"+bbcode+")";
	    run.execute(sql);
	    run.execute(sql1);
	    run.execute(sql2);
	    scn.close();

	}
	public int view_acc(int acc_no) {
		int bal=0;
		 
             			
	       try{
		     String sql="select * from account where acc_no="+acc_no+"";
             ResultSet rs = run.execute(sql);
          while(rs.next())
         {   
      	   System.out.println("ACC_NO  " +rs.getInt(1)+"  BALANCE  "+rs.getInt(2)+"  TYPE  "+rs.getString(3)+"  BANK CODE  "+rs.getString(4)+"  BRANCH CODE  "+rs.getInt(5));
      	   bal=rs.getInt(2);
         }
         }catch(java.lang.NullPointerException e){  this.createTable(); e.printStackTrace();}
			catch(Exception e){e.printStackTrace();}
	       scn.close();
        return bal;
	}
    public void deposit(){
    	System.out.print("\tEnter acc_no:");
		int acc_no = scn.nextInt();
		int bal=this.view_acc(acc_no);
        System.out.println("Enter ammount to deposit");
        bal=bal+scn.nextInt();
        String sql="update account set balance="+bal+" where acc_no="+acc_no+"";
        run.execute(sql);
    }
    public void withdraw(){

    	System.out.print("\tEnter acc_no:");
		int acc_no = scn.nextInt();
		int bal=this.view_acc(acc_no);
        System.out.println("Enter ammount to withdraw");
        bal=bal-scn.nextInt();
        String sql="update account set balance="+bal+" where acc_no="+acc_no+"";
        run.execute(sql);
    }
    public void createTable(){
    	System.out.println("Fixing a few things..");
    	try{
    	String sql[]=new String[10];
    	int i=0;
    	sql[0]="drop table customer";
    		sql[1]= "drop table loan";
    			sql[2]="drop table account";
    			sql[3]="drop table bank_branch";
    			sql[4]="drop table bank";
    	        sql[5]="create table bank(code varchar(5),name varchar(25),address varchar(30),primary key(code))";
    			sql[6]="create table bank_branch(address varchar(30) default NULL, bkcode varchar(5) NOT NULL,bbcode int NOT NULL, foreign key(bkcode) references bank(code), primary key(bkcode,bbcode))";
    			sql[7]="create table account(acc_no int NOT NULL, balance int default 0, type varchar(8) NOT NULL, constraint account_type_ck check(type in('saving','current')),bbcode int, bkcode varchar(5) NOT NULL, foreign key(bkcode,bbcode) references bank_branch(bkcode,bbcode), primary key(acc_no,bkcode))";
                sql[8]="create table loan(loan_no int NOT NULL, amount int default 100, bkcode varchar(5),bbcode int, primary key(loan_no), foreign key(bkcode,bbcode) references bank_branch(bkcode,bbcode))";
    			sql[9]="create table customer( name varchar(25), phone decimal(10,0), address  varchar(30), cus_no varchar(10) NOT NULL, acc_no int, loan_no int , bkcode varchar(5), foreign key(acc_no,bkcode) references account(acc_no,bkcode), foreign key(loan_no) references loan(loan_no), primary key(cus_no))";
    			for(String name : sql){run.execute(sql[i]); i++;}
            System.out.println("Database created!");
    	}catch(Exception e){ //System.err.println(e.getMessage()); 
    		}
    	}
    	
    }

