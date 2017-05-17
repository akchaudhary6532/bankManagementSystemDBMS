package bankManagementSystemDBMS;

@SuppressWarnings("serial")
public class IntException extends java.lang.Exception 
{
  public String getMessage()
  {
	  String msg="Please Enter Integer values!";
	  return msg;
  }
}
