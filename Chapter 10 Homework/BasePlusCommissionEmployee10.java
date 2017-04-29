////////////////////////////////////////////////////////////
// Problem 10.8 - Payroll System Modification             //  
// Purpose - Create a payroll system using polymorphism.  //
// by. Nicole Anderson                                    //  
// Date - October 19, 2014                                //
////////////////////////////////////////////////////////////

public class BasePlusCommissionEmployee extends CommissionEmployee
{
   private double baseSalary; // base salary per week
   
   // constructor
   public BasePlusCommissionEmployee( String first, String last, String ssn,
                              int month, int day, int year, double sales, double rate, double salary )
   {
      super( first, last, ssn, month, day, year, sales, rate );
      setBaseSalary( salary );
   } // end BasePlusCommissionEmployee                             
   
   // set and get base salary
   public void setBaseSalary( double salary )
   {
      if( salary >= 0.0 )
         baseSalary = salary;
      else
         throw new IllegalArgumentException( "Base salary must be >= 0.0" );    
   }// end setBaseSalary
   
   public double getBaseSalary()
   {
      return baseSalary;
   }// getBaseSalary
   
   // calculate earnings
   @Override
   public double earnings()
   {
      return getBaseSalary() + super.earnings();
   } // end earnings
   
   // Display base salary toString
   @Override
   public String toString()
   {
      return String.format( "%s %s; %s: $%,.2f", 
         "base-salaried", super.toString(), 
         "base salary", getBaseSalary() );
      } // end method toString
}// end BasePlusCommissionEmployee