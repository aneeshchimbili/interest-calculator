package ci;
import org.junit.Before;
import org.junit.Test;

//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class InterestCalculatorTest {

    private InterestCalculator interestCalculator;

    @Before
    public void setUp() throws Exception {
        interestCalculator = new InterestCalculator();
    }

    @Test
    public void shouldReturnAValueForGivenInput() throws Exception {
        Double principal = 1.0;
        Double percentageInterest = 1.0;
        Double timeInYears = 1.0;

        assertThat(interestCalculator.calculateSimpleInterest(principal, percentageInterest, timeInYears), not(nullValue()));
    }

    @Test
    public void shouldReturnInterestAccruedForRateOf10PercentFor5YearsOnAnAmountOf100000Dollars() throws Exception {
        Double principal = 100000.0;
        Double percentageInterest = 10.0;
        Double timeInYears = 5.0;

        assertThat(interestCalculator.calculateSimpleInterest(principal, percentageInterest, timeInYears), is(50000.0));
    }

    @Test
    public void shouldReturnCompoundInterestFor100Dollars20percentInterestFor2Years() throws Exception {
        Double principal = 100.0;
        Double percentageInterest = 20.0;
        Double timeInYears = 2.0;

        assertThat(interestCalculator.calculateCompoundInterest(principal, percentageInterest, timeInYears), is(44.0));
    }

    @Test(expected = RequiredInputNotPresentException.class)
    public void shouldHandleNullInputs() throws Exception {
        interestCalculator.calculateSimpleInterest(1.0, 1.0, null);
    }

    @Test
    public void shouldReturnInterestAccruedForRateOf10PercentFor5YearsOnAnAmountOf1000000Dollars() throws Exception {
        Double principal = 1000000.0;
        Double percentageInterest = 10.0;
        Double timeInYears = 5.0;

        assertThat(interestCalculator.calculateSimpleInterest(principal, percentageInterest, timeInYears), is(500000.0));
    }

    @Test
    public void shouldReturnInterestAccruedForRateOf10PercentFor5YearsOnAnAmountOf10000000Dollars() throws Exception {
        Double principal = 10000000.0;
        Double percentageInterest = 10.0;
        Double timeInYears = 5.0;

        assertThat(interestCalculator.calculateSimpleInterest(principal, percentageInterest, timeInYears), is(5000000.0));
    }

    @Test
    public void shouldReturnInterestAccruedForRateOf10PercentFor5YearsOnAnAmountOf100Dollars() throws Exception {
        Double principal = 100.0;
        Double percentageInterest = 10.0;
        Double timeInYears = 5.0;

        assertThat(interestCalculator.calculateSimpleInterest(principal, percentageInterest, timeInYears), is(50.0));
    }

    @Test
    public void shouldReturnInterestAccruedForRateOf10PercentFor5YearsOnAnAmountOf1000Dollars() throws Exception {
        Double principal = 1000.0;
        Double percentageInterest = 10.0;
        Double timeInYears = 5.0;

        assertThat(interestCalculator.calculateSimpleInterest(principal, percentageInterest, timeInYears), is(500.0));
    }

    @Test
    public void shouldReturnInterestAccruedForRateOf10PercentFor7YearsOnAnAmountOf1000Dollars() throws Exception {
        Double principal = 1000.0;
        Double percentageInterest = 10.0;
        Double timeInYears = 7.0;

        assertThat(interestCalculator.calculateSimpleInterest(principal, percentageInterest, timeInYears), is(700.0));
    }

    @Test
    public void shouldReturnInterestAccruedForRateOf10PercentFor7YearsOnAnAmountOf10000Dollars() throws Exception {
        Double principal = 10000.0;
        Double percentageInterest = 10.0;
        Double timeInYears = 7.0;

        assertThat(interestCalculator.calculateSimpleInterest(principal, percentageInterest, timeInYears), is(7000.0));
    }
}
