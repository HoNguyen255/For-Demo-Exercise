// package Mockito.Example_Two;

// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.reset;
// import static org.mockito.Mockito.when;

// import org.junit.Assert;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// // import org.mockito.runners.MockitoJUnitRunner;

// // @RunWith attaches a runner with the test class to initialize the test data
// // @RunWith(MockitoJUnitRunner.class)
// public class MathApplicationTester {
	
   
//    private MathApplication mathApplication;
//    private CalculatorService calcService;

//    @Before
//    public void setUp(){
//       mathApplication = new MathApplication();
//       calcService = mock(CalculatorService.class);
//       mathApplication.setCalculatorService(calcService);
//    }

//    @Test
//    public void testAddAndSubtract(){

//       //add the behavior to add numbers
//       when(calcService.add(20.0,10.0)).thenReturn(30.0);
  
//       //test the add functionality
//       Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);

//       //reset the mock	  
//       reset(calcService);

//       //test the add functionality after resetting the mock
//       Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);   
//    }
// }