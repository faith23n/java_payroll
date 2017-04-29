////////////////////////////////////////////////////////////
// Problem 10.8 - Payroll System Modification             //  
// Purpose - Create a payroll system using polymorphism.  //
// by. Nicole Anderson                                    //  
// Date - October 19, 2014                                //
////////////////////////////////////////////////////////////

public class HourlyEmployee extends Employee
{
   private double wage;// wage per hour
   private double hours; // hours worked for week
   
   // constructor
   public HourlyEmployee(String first, String last, String ssn, 
                           int month, int day, int year, double hourlyWage, double hoursWorked )
   {
      super( first, last, ssn, month, day, year );
      setWage( hourlyWage );// validate wage
      setHours( hoursWorked );// validate hours worked
   }// end HourlyEmployee constructor 
   
   // Set and Get Wage
   public void setWage( double hourlyWage )
   {
      if( hourlyWage >= 0.0 )
         wage = hourlyWage;
      else
         throw new IllegalArgumentException( "Hourly wage must be >= 0.0" );   
   }// end setWage
   
   public double getWage()
   {
      return wage;
   }// end getWage
   
   // Set and Get Hours Worked
   public void setHours( double hoursWorked )
   {
      if( ( hoursWorked >= 0.0 ) && ( hoursWorked <= 168.0 ) )
         hours = hoursWorked;
      else
         throw new IllegalArgumentException( "Hours worked must be >= 0.0 and <= 168.0" );    
   }// end setHours
   
   public double getHours()
   {
      return hours;
   }// end getHours
   
   // calculate earnings
   @Override
   public double earnings()
   {
      if ( getHours() <= 40 ) 
         return getWage() * getHours();
      else
         return 40 * getWage() + ( getHours() - 40 ) * getWage() * 1.5;
   } // end method earnings

   // display hourly wages
   @Override
   public String toString()
   {
      return String.format( "hourly employee: %s\n%s: $%,.2f; %s: %,.2f", 
         super.toString(), "hourly wage", getWage(), 
         "hours worked", getHours() );
   } // end method toString
}// end HourlyEmployee