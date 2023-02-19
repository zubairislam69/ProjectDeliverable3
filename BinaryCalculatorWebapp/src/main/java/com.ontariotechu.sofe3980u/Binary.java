package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary {
    private String number = "0"; // string containing the binary value '0' or '1'

    /**
     * A constructor that generates a binary object.
     *
     * @param number a String of the binary values. It should conatins only zeros or
     *               ones with any length and order. otherwise, the value of "0"
     *               will be stored. Trailing zeros will be excluded and empty
     *               string will be considered as zero.
     */
    public Binary(String number) {
        for (int i = 0; i < number.length(); i++) {
            // check each character if it's not 0 or 1
            char ch = number.charAt(i);
            if (ch != '0' && ch != '1') {
                number = "0"; // if not store "0" and end the function
                return;
            }
        }
        // remove any trailing zeros
        int beg;
        for (beg = 0; beg < number.length(); beg++) {
            if (number.charAt(beg) != '0')
                break;
        }
        // beg has the index of the first non zero digit in the number
        this.number = number.substring(beg); // exclude the trailing zeros if any
        // uncomment the following code

        if ("".equals(this.number)) { // replace empty strings with a single zero
            this.number = "0";
        }

    }

    /**
     * Return the binary value of the variable
     *
     * @return the binary value in a string format.
     */
    public String getValue() {
        return this.number;
    }

    /**
     * Adding two binary variables. For more information, visit
     * <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers
     * </a>.
     *
     * @param num1 The first addend object
     * @param num2 The second addend object
     * @return A binary variable with a value of <i>num1+num2</i>.
     */
    public static Binary add(Binary num1, Binary num2) {
        // the index of the first digit of each number
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;
        // initial variable
        int carry = 0;
        String num3 = ""; // the binary value of the sum
        while (ind1 >= 0 || ind2 >= 0 || carry != 0) // loop until all digits are processed
        {
            int sum = carry; // previous carry
            if (ind1 >= 0) { // if num1 has a digit to add
                sum += (num1.number.charAt(ind1) == '1') ? 1 : 0; // convert the digit to int and add it to sum
                ind1--; // update ind1
            }
            if (ind2 >= 0) { // if num2 has a digit to add
                sum += (num2.number.charAt(ind2) == '1') ? 1 : 0; // convert the digit to int and add it to sum
                ind2--; // update ind2
            }
            carry = sum / 2; // the new carry
            sum = sum % 2; // the resultant digit
            num3 = ((sum == 0) ? "0" : "1") + num3; // convert sum to string and append it to num3
        }
        Binary result = new Binary(num3); // create a binary object with the calculated value.
        return result;

    }

    /**
     * Using the Bitwise Logical OR operation on two binary values.For more
     * information, visit <a href=
     * "http://www.java2s.com/example/cpp/operator/bitwise-logical-operators-and-truth-tables.html">
     * Bitwise Inclusive OR </a>.
     *
     * @param value1 The first binary value
     * @param value2 The second binary value
     * @return A binary variable with a value of the result from the OR operation
     */
    public static Binary bitwiseLogicalOR(Binary value1, Binary value2) {

        // get length of both binary values
        int value1Length = value1.number.length();
        int value2Length = value2.number.length();

        // set the binary values to string to update later if necessary
        String updatedValue1 = value1.number;
        String updatedValue2 = value2.number;

        // if the length of the first binary val is greater than the second one
        // it will subtract both values, and then using that result,
        // it will assign that resulted num of leading zeroes to the second binary value
        if (value1Length > value2Length) {
            int numOfZeroes = value1Length - value2Length;
            for (int i = 0; i < numOfZeroes; i++) {
                updatedValue2 = "0" + updatedValue2;
            }
        }

        // if the length of the second binary val is greater than the first one
        // it will subtract both values, and then using that result,
        // it will assign that resulted num of leading zeroes to the first binary value
        else if (value1Length < value2Length) {
            int numOfZeroes = value2Length - value1Length;
            for (int i = 0; i < numOfZeroes; i++) {
                updatedValue1 = "0" + updatedValue1;
            }
        }

        // empty variable to store result of logical OR
        String ORresult = "";

        // for loop to loop through each bit of both
        // binary values and perform logical OR
        // for loop condition uses the highest binary value length
        for (int i = 0; i < ((value1Length > value2Length) ? value1Length : value2Length); i++) {
            // checks each bit of val 1
            char value1Bit = updatedValue1.charAt(i);
            // checks each bit of val 2
            char value2Bit = updatedValue2.charAt(i);

            // logical OR conditions
            if (value1Bit == '0' && value2Bit == '0') {
                ORresult += "0";
            } else if ((value1Bit == '1' && value2Bit == '1') ||
                    (value1Bit == '0' && value2Bit == '1') ||
                    (value1Bit == '1' && value2Bit == '0')) {
                ORresult += "1";
            }
        }

        Binary result = new Binary(ORresult);
        return result;

    }

    /**
     * Using the Bitwise Logical AND operation on two binary values.For more
     * information, visit <a href=
     * "http://www.java2s.com/example/cpp/operator/bitwise-logical-operators-and-truth-tables.html">
     * Bitwise AND </a>.
     *
     * @param value1 The first binary value
     * @param value2 The second binary value
     * @return A binary variable with a value of the result from the AND operation
     */
    public static Binary bitwiseLogicalAND(Binary value1, Binary value2) {

        // get length of both binary values
        int value1Length = value1.number.length();
        int value2Length = value2.number.length();

        // set the binary values to string to update later if necessary
        String updatedValue1 = value1.number;
        String updatedValue2 = value2.number;

        // if the length of the first binary val is greater than the second one
        // it will subtract both values, and then using that result,
        // it will assign that resulted num of leading zeroes to the second binary value
        if (value1Length > value2Length) {
            int numOfZeroes = value1Length - value2Length;
            for (int i = 0; i < numOfZeroes; i++) {
                updatedValue2 = "0" + updatedValue2;
            }
        }

        // if the length of the second binary val is greater than the first one
        // it will subtract both values, and then using that result,
        // it will assign that resulted num of leading zeroes to the first binary value
        else if (value1Length < value2Length) {
            int numOfZeroes = value2Length - value1Length;
            for (int i = 0; i < numOfZeroes; i++) {
                updatedValue1 = "0" + updatedValue1;
            }
        }

        // empty variable to store result of logical AND
        String ANDresult = "";

        // for loop to loop through each bit of both
        // binary values and perform logical AND
        // for loop condition uses the highest binary value length
        for (int i = 0; i < ((value1Length > value2Length) ? value1Length : value2Length); i++) {
            // checks each bit of val 1
            char value1Bit = updatedValue1.charAt(i);
            // checks each bit of val 2
            char value2Bit = updatedValue2.charAt(i);

            // logical AND conditions
            if ((value1Bit == '0' && value2Bit == '0') ||
                    (value1Bit == '0' && value2Bit == '1') ||
                    (value1Bit == '1' && value2Bit == '0')) {
                ANDresult += "0";
            } else if (value1Bit == '1' && value2Bit == '1') {
                ANDresult += "1";
            }
        }

        Binary result = new Binary(ANDresult);
        return result;

    }

    /**
     * Using Binary Multiplication for two binary values.
     *
     * @param value1 The first binary value
     * @param value2 The second binary value
     * @return A binary variable with a value of the result from the multiply
     *         operation
     */
    public static Binary binaryMultiply(Binary value1, Binary value2) {
        // set the Binary values to strings
        String stringValue1 = value1.number;
        String stringValue2 = value2.number;

        // convert the binary strings to integer values using Integer class
        // and parseInt method with radix 2
        int intValue1 = Integer.parseInt(stringValue1, 2);
        int intValue2 = Integer.parseInt(stringValue2, 2);

        // create the result Binary value using Integer class
        // methoid toBinaryString which converts an integer to binary string
        // and return that result
        Binary result = new Binary(Integer.toBinaryString(intValue1 * intValue2));
        return result;
    }
}