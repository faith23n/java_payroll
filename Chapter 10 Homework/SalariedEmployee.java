////////////////////////////////////////////////////////////
// Problem 10.8 - Payroll System Modification             //  
// Purpose - Create a payroll system using polymorphism.  //
// by. Nicole Anderson                                    //  
// Date - October 19, 2014                                //
////////////////////////////////////////////////////////////

public class SalariedEmployee extends Employee
{
   private double weeklySalary;
   
   // constructor
   public SalariedEmployee( String first, String last, String ssn, 
                              int month, int day, int year, double salary)
   {
      super( first, last, ssn, month, day, year ); // pass to Employee constructor
      setWeeklySalary( salary ); // validate and store salary
   }// end SalariedEmployee constructor
   
   // set salary
   public void setWeeklySalary( double salary )
   {
      if( salary >= 0.0 )
         weeklySalary = salary;
      else
         throw new IllegalArgumentException( "Weekly salary must be >= 0.0" );   
   }// end setWeeklySalary
   
   // get salary
   public double getWeeklySalary()
   {
      return weeklySalary;
   }// end getWeeklySalary
   
   // calculate earnings
   @Override
   public double earnings()
   {
      return getWeeklySalary();
   }// end earnings
   
   // return String representation of SalariedEmployee object
   @Override
   public String toString()
   {
      return String.format( "salaried employee: %s\n%s: $%,.2f", 
         super.toString(), "weekly salary", getWeeklySalary() );
   } // end method toString   
}// end Salaried Employee