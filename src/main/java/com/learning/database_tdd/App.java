package com.learning.database_tdd;

import com.learning.database_tdd.frontend.ShowUserDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//before running the actual code
    	//remove "test" scope from dependancy
      ShowUserDetails details=new ShowUserDetails();
      details.showDetails();
    }
}
