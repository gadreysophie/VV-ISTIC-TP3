# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. The assertTrue assertion is not well used. You should declare variables and then assert the are true or not.

```
public int a = 3;
public int b = 0.4;
public int c = a*b;
assertTrue(c, 1.2);
``` 
2. AssetEquals checks if two given objects are equal. AssertSame verifies if two objects are the same and they can be not equal but it is the same object.

3. Here is an example of "fail" found here (https://www.javaguides.net/2018/08/junit-assertfail-method-example.html#:~:text=The%20fail%20assertion%20fails%20a,test%20failing%20during%20its%20development.&text=In%20JUnit%205%20all%20JUnit%204%20assertion%20methods%20are%20moved%20to%20org.) :

``` 
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AssertFailExample {

 public int largest(final int[] list) {
      int index, max = Integer.MAX_VALUE;
      for (index = 0; index < list.length - 1; index++) {
         if (list[index] > max) {
             max = list[index];
         }
      }
      return max;
 }
 
 @Test
 public void testEmpty() {
     try {
         largest(new int[] {});
         fail("Should have thrown an exception");
         // It could be replace by this :
         Assert.fail("Should have thrown an exception") - The code should have throw an exception and if the assert passes that is because the code is not throwing a exception and the test failed.
     } catch (final RuntimeException e) {
         assertTrue(true);
     }
   } 
}
``` 
I have add a Assert.fail() assertion that could be done instead of the fail message.

4. It is to test boundaries of the programs. It can cover the wrong use of the program and verify that the wrong use of the program throw an exception. It can be used for NullPointerException for example.
