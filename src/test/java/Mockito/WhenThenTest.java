// package Mockito;

// import java.util.Arrays;

// import org.junit.Test;
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.mockito.Mockito;
// import org.mockito.invocation.InvocationOnMock;
// import org.mockito.stubbing.Answer;



// public class WhenThenTest {
//     private CustomList mockedObject;

//     @BeforeEach
//     public void prepareForTest() {
//         // Mock creation
//         mockedObject = Mockito.mock(CustomList.class);
//     }

//     @Test
//     public void thenReturnTest() {
//         // Configure mock to return a specific value on a method call
//         Mockito.when(mockedObject.get(0)).thenReturn("gpcoder.com");

//         // Verify behavior
//         Assertions.assertEquals("gpcoder.com", mockedObject.get(0));
//     }

//     @Test //(expected = IllegalStateException.class)
//     public void thenThrowTest() {
//         // Configure mock to throw an exception on a method call
//         Mockito.when(mockedObject.add(Mockito.anyString())).thenThrow(IllegalStateException.class);

//         mockedObject.add("gpcoder.com");
//     }

//     @Test
//     public void thenAnswerTest1() {
//         // Configure mock method call with custom Answer
//         Mockito.when(mockedObject.get(Mockito.anyInt())).thenAnswer(new Answer<String>() {
//             public String answer(InvocationOnMock invocation) {
//                 Object[] args = invocation.getArguments();
//                 // Object mockedObject = invocation.getMock();
//                 return "gpcoder.com" + Arrays.toString(args);
//             }
//         });

//         // Verify behavior
//         Assertions.assertEquals("gpcoder.com[1]", mockedObject.get(1));
//     }

//     @Test
//     public void thenAnswerTest2() {
//         // Configure mock method call with custom Answer using Java 8 syntax
//         Mockito.when(mockedObject.get(Mockito.anyInt())).thenAnswer(invocation -> {
//             Object[] args = invocation.getArguments();
//             // Object mockedObject = invocation.getMock();
//             return "gpcoder.com" + Arrays.toString(args);
//         });

//         // Verify behavior
//         Assertions.assertEquals("gpcoder.com[1]", mockedObject.get(1));
//     }

//     @Test
//     public void thenCallRealMethodTest() {
//         // Configure mock method call real method
//         // Be sure the real implementation is 'safe'.
//         // If real implementation throws exceptions or depends on specific state of the
//         // object then you're in trouble.
//         Mockito.when(mockedObject.add(Mockito.anyString())).thenCallRealMethod();
//         Mockito.when(mockedObject.get(Mockito.anyInt())).thenCallRealMethod();
//         Mockito.when(mockedObject.size()).thenCallRealMethod();

//         mockedObject.add("gpcoder.com");
//         mockedObject.clear(); // This method will be not called on mocked object

//         // Verify behavior
//         Assertions.assertEquals(1, mockedObject.size());
//         Assertions.assertEquals("gpcoder.com", mockedObject.get(0));
//     }
// }
