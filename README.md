# Optimized Cycle finder for Collatz Conjecture generalization (qx+c)
This algorithm is built on a research paper: doi.org/10.21203/rs.3.rs-2288122/v1, please read the paper before reading the code.

## Build and run
1. Set the boundaries in src/lib/ConfigurationForLimitTest.java and src/App.java
2. Compile src/App.java: `cd src && javac App.java`
3. Run the code: `java App`

## CSV Column definition
You have four columns for all nontrivial cycles.
1. Level: This is the loop level
2. Q: the 'q' value in qx+c
3. C : the 'c' value in qx+c
4. X : the first term in the cycle for a specified qx+c
5. CycleLength : The length of the cycle, that is, the distance between the first X occurence (inclusive) and the second X occurence (exclusive). For example, for 5x+3 such that x=-12, the CycleLength is 3 where the sequence is [-12, -6, -3, -12]

## Definitions
1. Nontrivial cycle : A cycle such that it does not contain +1 or -1 in its sequence.

## License
This work is licensed under GNU General Public License v3.0, check the full legal text in LICENSE.