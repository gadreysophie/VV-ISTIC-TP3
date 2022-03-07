# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

### Identify which of the test smells discussed in classes are implemented by these rules.

DetachedTestCase = Manual intervention since there is no annotation


JUnit4SuitesShouldUseSuiteAnnotation,
JUnit4TestShouldUseAfterAnnotation, JUnit4TestShouldUseBeforeAnnotation,
JUnit4TestShouldUseTestAnnotation,
JUnitSpelling,
JUnitTestsShouldIncludeAssert
= Manual intervention to help improve automation


JUnitTestContainsTooManyAsserts = The Free ride or the PiggyBack when there is too many assert it is difficult to say wich assert has failed. And it could be also the Eager test, there is too many assert and too many functionnalities are being tested.

JUnitUseExpected,
UnnecessaryBooleanAssertion
= Happy path, it tests if the program react well in presence of error. Not only the expected path is tested.

UseAssertEqualsInsteadOfAssertTrue,
UseAssertNullInsteadOfAssertTrue,
UseAssertSameInsteadOfAssertTrue,
UseAssertTrueInsteadOfAssertEquals
= interacting tests and fragile test

JUnitStaticSuite = Testing private methods or X-Ray specs
