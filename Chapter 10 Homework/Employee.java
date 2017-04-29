////////////////////////////////////////////////////////////
// Problem 10.8 - Payroll System Modification             //  
// Purpose - Create a payroll system using polymorphism.  //
// by. Nicole Anderson                                    //  
// Date - October 19, 2014                                //
////////////////////////////////////////////////////////////

public abstract class Employee
{
   private String firstName;
   private String lastName;
   private String socialSecurityNumber;
   private Date birthDate;
   
   // CONSTRUCTOR \\
   public Employee( String first, String last, String ssn, int month, int day, int year )
   {
      firstName = first;
      lastName = last;
      socialSecurityNumber = ssn;
      birthDate = new Date( month, day, year );
   } // end Employee constructor
   
   // SET AND GET FIRST NAME \\
   public void setFirstName( String first )
   {
      firstName = first;
   }// end setFirstName
   
   public String getFirstName()
   {
      return firstName;
   }// end getFirstName
   
   // SET AND GET LAST NAME \\
   public void setLastName( String last )
   {
      lastName = last;
   }// end setLastName
   
   public String getLastName()
   {
      return lastName;
   }// end getLastname
   
   // SET AND GET SOCIAL SECURITY NUMBER \\
   public void setSocialSecurityNumber( String ssn )
   {
      socialSecurityNumber = ssn;
   }// end setSocialSecurityNumber
   
   public String getSocialSecurityNumber()
   {
      return socialSecurityNumber;
   }// end getSocialSecurityNumber
   
   // SET AND GET BIRTH DATE
   public void setBirthDate( int month, int day, int year )
   {
      birthDate = new Date( month, day, year );
   } // end method setBirthDate

   public Date getBirthDate()
   {
      return birthDate;
   } // end method getBirthDate

   // DISPLAY EMPLOYEE INFORMATION
   @Override
   public String toString()
   {
      return String.format( "%s %s\n%s: %s\n%s: %s", 
         getFirstName(), getLastName(), 
         "social security number", getSocialSecurityNumber(), 
         "birth date", getBirthDate() );
   } // end method toString
   
   // abstract method overridden by subclasses
   public abstract double earnings();
} // end class Employee
