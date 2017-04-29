////////////////////////////////////////////////////////////
// Problem 10.8 - Payroll System Modification             //  
// Purpose - Create a payroll system using polymorphism.  //
// by. Nicole Anderson                                    //  
// Date - October 19, 2014                                //
////////////////////////////////////////////////////////////

public class CommissionEmployee extends Employee
{
   private double grossSales;// gross weekly sales
   private double commissionRate;// commission percentage
   
   // constructor
   public CommissionEmployee( String first, String last, String ssn,
                              int month, int day, int year, double sales, double rate )
   {
      super( first, last, ssn, month, day, year );
      setGrossSales( sales );
      setCommissionRate( rate );
   }// end CommissionEmployee constructor
   
   //set and get commission rate
   public void setCommissionRate( double rate )
   {
      if( rate > 0.0 && rate < 1.0 )
         commissionRate = rate;
      else 
         throw new IllegalArgumentException( "Commission rate must be > 0.0 and < 1.0" );   
   }// end setCommissionRate                           
   
   public double getCommissionRate()
   {
      return commissionRate;
   }// getCommissionRate
   
   // set and get gross sales amount
   public void setGrossSales( double sales )
   {
      if( sales >= 0.0 )
         grossSales = sales;
      else
         throw new IllegalArgumentException( "Gross sales must be >= 0.0" );    
   }// end setGrossSales
   
   public double getGrossSales()
   {
      return grossSales;
   }// getGrossSales
   
   // calculate earnings
   @Override
   public double earnings()
   {
      return getCommissionRate() * getGrossSales();
   }// end earnings
   
   @Override
   public String toString()
   {
      return String.format( "%s: %s\n%s: $%,.2f; %s: %.2f", 
         "commission employee", super.toString(), 
         "gross sales", getGrossSales(), 
         "commission rate", getCommissionRate() );
   }// end toString
}// end CommissionEmployee
      