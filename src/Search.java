package features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Search {

    public MyCustomer MC;
    public Customer c;
    public Admin user=new Admin();
    String customerID;

    boolean resultFlag=false;

    ArrayList<Customer> Result=new ArrayList<Customer>();

    public Search(MyCustomer a, Admin aa) {
        System.out.println("search feature");
        MC=a;
        user=aa;
    }

    @Given("these customers are contained in the Customer")
    public void these_customers_are_contained_in_the_Customer(io.cucumber.datatable.DataTable dataTable) {
        for(int i=0; i<4;i++) {

            CustomerID=dataTable.cell(i,2);

            c=new Customer(CustomerID);
            MC.add(c,user);
        }
        //    MC.print();
    }

    @When("the user searches for the text {string}")
    public void the_user_searches_for_the_text(String string) {
        Result=(ArrayList<Customer>) MC.CustomerIDSearch(string);
    }


    @Then("the customer with CustomerID {string} is found")
    public void the_customer_with_CustomerID_is_found(String string) {
        // assertTrue(Result.size()==1);
        assertEquals(string, Result.get(0).CustomerID);
	     /*System.out.println(Result.size());
			for(int i=0;i<Result.size();i++) {
				System.out.println(Result.get(i));

			}*/

    }

    @Then("no customers are found")
    public void no_customers_are_found() {
        assertTrue(Result.isEmpty());

    }

    @Then("the customers with CustomerID {string} and {string} are found")
    public void the_customers_with_CustomerID_and_are_found(String string, String string2) {
        // assertTrue(Result.size()==2);
		/*System.out.println(Result.size());
		for(int i=0;i<Result.size();i++) {
			System.out.println(Result.get(i).code);

		}*/
        assertTrue(Result.get(0).CustomerID.equals(string) && Result.get(1).CustomerID.equals(string2));
    }

}



