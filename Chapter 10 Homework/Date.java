////////////////////////////////////////////////////////////
// Problem 10.8 - Payroll System Modification             //  
// Purpose - Create a payroll system using polymorphism.  //
// by. Nicole Anderson                                    //  
// Date - October 19, 2014                                //
////////////////////////////////////////////////////////////

public class Date
{
   protected int month; // represented by numbers 1 - 12
   private int day; // represented by numbers 1 - 31 based on month
   private int year; // any year
   
   private static final int[] daysPerMonth = // days in each month
      {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   
   // constructor: call checkMonth to confimr proper value for month.
   //    call checkDay to confirm proper value for day
   public Date( int theMonth, int theDay, int theYear )
   {
      month = checkMonth( theMonth );
      day = checkDay( theDay );
      year = theYear; // could validate year
      
      System.out.printf( "Date object constructor for date %s\n", this );
   } // end Date constructor    
   
   // utility method to confirm proper month value
   private int checkMonth( int testMonth )
   {
      if( testMonth > 0 && testMonth <= 12 ) // validate month
         return testMonth;
      else
         throw new IllegalArgumentException( "month must be between 1 and 12" );   
   } // end checkMonth
   
   // utility method to confirm proper day value based on month and year
   private int checkDay( int testDay )
   {
      // check to see if day is withing range for the month
      if( testDay > 0 && testDay <= daysPerMonth[ month ] )
         return testDay;
         
      // check for leap year
      if( month == 2 && testDay == 29 && ( year % 400 == 0 || ( year % 4 == 0 && year % 100 != 0 ) ) )
         return testDay;
         
      throw new IllegalArgumentException( "date is out of range for specified month and year" );   
   } // end checkDay
   
   public String toString()
   {
      return String.format( "%d / %d / %d" , month, day, year);
   }// end toString
} // end class Date