package bankManagementSystemDBMS;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
	  int choice=0;
      System.out.println("Bank Management System" );
      System.out.print("**********************"+"\n1.View account\n2.Create account\n3.Transaction\n4.Exit\nEnter your choice:");
      Scanner scn=new Scanner(System.in);
      account acc=new account();
     // while(choice!=4)
      //{
      try{
    	   choice=scn.nextInt();
       }catch(java.util.InputMismatchException e)
       {}
         switch(choice)
         {
          case 1: 
          System.out.print("\tEnter acc_no:");
  		int acc_no=scn.nextInt();
          acc.view_acc(acc_no);
          	 break;
          case 2: acc.new_acc();
    	     break;
          case 3: System.out.print("\t1.Deposite Money\t\n2.Withdraw Money\t\n3.Tranct funds between accounts\t\nEnter Your choice:");
           			try{
           				choice=scn.nextInt();
           				}catch(java.util.InputMismatchException e)
           				{}
                switch(choice)
                { case 1: //deposite fund
                		  acc.deposit();
                      break;
                  case 2: //withdraw funds
                	     acc.withdraw();
                	  break;
                  case 3: //transcat B/w accounts
                	     
                	  break;
                }
                break;
          case 4: /*String sql=scn.next();
          			Input run=new Input();
                   run.execute(sql);
                   */
        	      acc.createTable();
        	  break;
          default: System.out.println("Wrong choice");
              break;
        }
    //  }
      scn.close();
     }

}
