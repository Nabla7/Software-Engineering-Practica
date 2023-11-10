/**
 * Compile-time function.
 * 
 * Returns the factorial of n such that n! = n * (n-1) * ... * 1.
 * This function uses recursion to compute the factorial.
 */
function fact_recursive(n: nat): nat {
    if n == 0 || n == 1 then 1 else n * fact_recursive(n-1)
}

/**
 * Runtime method.
 *
 * Returns the factorial of n such that n! = n * (n-1) * ... * 1.
 * This method uses iterative loops to compute the factorial.
 *
 * @param n: The natural number for which the factorial is to be calculated.
 * @return retval: The factorial of the input number n.
 *
 * Post-condition: Ensures that the returned value 'retval' is the factorial of 'n',
 *                 validated against the recursive factorial function 'fact_recursive'.
 */
method strange_factorial(n: nat) returns (retval: nat)
    ensures retval == fact_recursive(n) // Post-condition

{
    var R := 0; // Counter for the outer loop
    retval := 1; // Initialize return value to 1 (factorial of 0)

    // Outer loop: Iteratively calculates the factorial
    while (R < n || retval != fact_recursive(n))
        // Loop invariant: At the start and end of each iteration, 'retval' must be equal to the factorial of 'R'.
        // This ensures that the loop is correctly calculating the factorial incrementally.
        invariant R <= n && retval == fact_recursive(R)
        // Loop variant: Decreases with each iteration, ensuring that the loop will terminate.
        decreases n - R
    {
        var V := retval; // Temporarily holds the current value of retval

        var S := 1; // Counter for the inner loop
        // Inner loop: Computes the multiplication needed for the next step of the factorial
        while (S <= R || retval != (R+1) * V)
            // Loop invariant: At the start and end of each iteration, 'retval' must be equal to 'S' multiplied by 'V'.
            // This invariant is crucial to ensure the correctness of this nested loop.
            invariant S <= R+1 && retval == S * V
            // Loop variant: Decreases with each iteration, ensuring that the inner loop will terminate.
            decreases R + 1 - S
        {
            retval := retval + V; // Update the retval by adding 'V' each time
            S := S + 1; // Increment the inner loop counter
        }

        R := R + 1; // Increment the outer loop counter
    }

    return retval; // Return the computed factorial
}
