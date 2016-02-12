package part2;

public class Derangement
{
    private String input;

    public Derangement(String input)
    {
        this.input = input;
    }

    private Long getDerangement(Long n) throws IllegalArgumentException
    {
        if(n < 0)
        {
            throw new IllegalArgumentException();
        }
        if(n == 0)
        {
            return 1L;
        }
        else if(n == 1)
        {
            return 0L;
        }
        else
        {
            return (n - 1) * (getDerangement(n - 1) + getDerangement(n - 2));
        }
    }

    private Long getFactorial(Long n) throws IllegalArgumentException
    {
        if(n < 0)
        {
            throw new IllegalArgumentException();
        }
        if(n == 0)
        {
            return 1L;
        }
        else
        {
            return n * getFactorial(n - 1);
        }
    }

    public void calculateProbability()
    {
        try
        {
            Long n = Long.parseLong(input);
            Long numerator = getDerangement(n);
            Long denominator = getFactorial(n);
            System.out.println("the numerator (derangement) = " + numerator);
            System.out.println("the denominator (factorial) = " + denominator);
        }
        catch (NumberFormatException e)
        {
            System.err.println("error: the input is not a valid integer number.");
            System.exit(1);
        }
        catch (IllegalArgumentException e)
        {
            System.err.println("error: the input is a not a positive integer number.");
            System.exit(1);
        }
    }

    public static void main(String args[])
    {
        Derangement derangement = new Derangement(args[0]);
        derangement.calculateProbability();
    }
}