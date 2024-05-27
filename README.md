Deterministic finite automaton/transducer that takes in a string representing an arithmetic statement, and produces an output sequence of tokens that represent the numbers and operators. 

The following expressions are valid:
1. A valid number is a valid expression. 
2. Any valid expression, followed by an operator, followed by a valid number.
3. The operators and numbers may or may not be separated by white space.

Numbers will be in the following format:
1. A string of digits possibly followed by a decimal point and a non-empty string of digits. 
2. If there is a decimal point, the string before the decimal point should consist only of 0.
3. If the number starts with 0', it is either just 0, or 0.[something] where the [something] is a string of digits.

![Picture1](https://github.com/WilliamSottoriva/DFA-Token-Validator/assets/60838237/67d40bf8-9b0a-43d3-b595-de7d8eeb0fb6)
