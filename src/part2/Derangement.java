package part2;

public class Derangement
{
    private String input;
    private boolean print;

    public Derangement(String input)
    {
        this.input = input;
        this.print = false;
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

    private static long getGCD(Long a, Long b)
    {
        return b == 0 ? a : getGCD(b, a % b);
    }

    private static String simplifyFraction(Long a, Long b)
    {
        Long gcd = getGCD(a, b);
        return (a / gcd) + "/" + (b / gcd);
    }

    public void calculateProbability()
    {
        try
        {
            Long n = Long.parseLong(input);

            long startTime = System.currentTimeMillis();
            Long numerator = getDerangement(n);
            long endTime = System.currentTimeMillis();

            Long denominator = getFactorial(n);
            String fraction = simplifyFraction(numerator, denominator);

            if(print)
            {
                System.out.println("the numerator (derangement) = " + numerator);
                System.out.println("the denominator (factorial) = " + denominator);
                System.out.println("the simplified fraction = " + fraction);
            }
            else
            {
                System.out.println(fraction);
            }

            System.out.println("the execution time of computing derangement = " + (endTime - startTime));
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
        if(args.length == 0)
        {
            for(Integer counter = 0; counter <= 20; counter++)
            {
                System.out.println("input = " + counter);
                Derangement derangement = new Derangement(counter.toString());
                derangement.print = true;
                derangement.calculateProbability();
                System.out.println();
            }
        }
        else if(args.length == 1)
        {
            Derangement derangement = new Derangement(args[0]);
            derangement.calculateProbability();
        }
        else
        {
            System.err.println("error: the input is invalid. it should be the number of people.");
        }
    }
}