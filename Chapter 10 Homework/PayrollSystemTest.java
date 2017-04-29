////////////////////////////////////////////////////////////
// Problem 10.8 - Payroll System Modification             //  
// Purpose - Create a payroll system using polymorphism.  //
// by. Nicole Anderson                                    //  
// Date - October 19, 2014                                //
////////////////////////////////////////////////////////////

import java.util.Scanner;

public class PayrollSystemTest
{
   public static void main( String[] args )
   {
      // create subclass objects
      SalariedEmployee salariedEmployee = 
         new SalariedEmployee( "Mary", "Hudson", "111-11-1111", 2, 1, 1951, 750.00 );
      HourlyEmployee hourlyEmployee = 
         new HourlyEmployee( "Chester", "Lee", "222-22-2222", 9, 4, 1950, 25.70, 45 );
      CommissionEmployee commissionEmployee = 
         new CommissionEmployee( "Rollo", "Jenkins", "333-33-3333", 11, 12, 1975, 3200.75, .5 );
      BasePlusCommissionEmployee basePlusCommissionEmployee = 
         new BasePlusCommissionEmployee( "Nicole", "Anderson", "444-44-4444", 12, 9, 1980, 2500.50, .4, 1500.00 );
      
      System.out.println( "Employees processed individually:\n" );
      
      System.out.printf( "%s\n%s: $%,.2f\n\n", 
         salariedEmployee, "earned", salariedEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n",
         hourlyEmployee, "earned", hourlyEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n",
         commissionEmployee, "earned", commissionEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n", 
         basePlusCommissionEmployee, 
         "earned", basePlusCommissionEmployee.earnings() );
      
      // create Employee array
      Employee[] employees = new Employee[ 4 ];
      
      employees[ 0 ] = salariedEmployee;
      employees[ 1 ] = hourlyEmployee;
      employees[ 2 ] = commissionEmployee; 
      employees[ 3 ] = basePlusCommissionEmployee;

      Scanner input = new Scanner( System.in ); // to get current month
      int currentMonth;

      // get and validate current month
      do
      {
         System.out.print( "Enter the current month (1 - 12): " );
         currentMonth = input.nextInt();
         System.out.println();
      } while ( ( currentMonth < 1 ) || ( currentMonth > 12 ) );

      System.out.println( "Employees processed polymorphically:\n" );
      
      // process each element in array employees
      for ( Employee currentEmployee : employees ) 
      {
         System.out.println( currentEmployee ); // invokes toString

         // determine whether element is a BasePlusCommissionEmployee
         if ( currentEmployee instanceof BasePlusCommissionEmployee ) 
         {
            BasePlusCommissionEmployee employee = 
               ( BasePlusCommissionEmployee ) currentEmployee;

            double oldBaseSalary = employee.getBaseSalary();
            employee.setBaseSalary( 1.10 * oldBaseSalary );
            System.out.printf( 
               "new base salary with 10%% increase is: $%,.2f\n",
               employee.getBaseSalary() );
         } // end if

         // if month of employee's birthday, add $100 to salary
         if ( currentMonth == currentEmployee.getBirthDate().month )
            System.out.printf(
               "earned $%,.2f %s\n\n", currentEmployee.earnings(), 
               "plus $100.00 birthday bonus" );
         else
            System.out.printf( 
               "earned $%,.2f\n\n", currentEmployee.earnings() );
      } // end for

      // get type name of each object in employees array
      for ( int i = 0; i < employees.length; i++ )
         System.out.printf( "Employee %d is a %s\n", i, 
            employees[ i ].getClass().getName() );    
   }// end main
}// end PayrollSystemTest