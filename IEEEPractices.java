public class IEEEPractices {

    // Converts a float to its IEEE 754 32-bit binary representation
    public static String floatToIEEE754(float value) {
        // Getting the sign bit
        int sign = 0;
        if (value < 0) {
            sign = 1;
        }

        // Getting the integer part and the fractional part
        value = Math.abs(value);
        int integerPart = (int) value;
        float fractionalPart = value - integerPart;

        // Converting integer part to binary
        String integerPartBinary = Integer.toBinaryString(integerPart);

        // Converting fractional part to binary
        StringBuilder fractionalPartBinary = new StringBuilder();
        while (fractionalPart > 0 && fractionalPartBinary.length() <= 24) {
            // Should limiting to 23 bits, however need to generate extra bits here for precision (e.g., if I use 23, 1.0/3.0 would be converted to wrong result)
            fractionalPart *= 2;
            if (fractionalPart >= 1) {
                fractionalPartBinary.append(1);
                fractionalPart -= 1;
            } else {
                fractionalPartBinary.append(0);
            }
        }

        // Combining integer and fractional parts
        String mantissaBinary = integerPartBinary + fractionalPartBinary.toString();

        // Normalizing the binary representation
        int exponent = 127; // Bias for single-precision floating-point
        int firstOneIndex = mantissaBinary.indexOf('1'); // Finding the first 1
        if (firstOneIndex > -1) {
            exponent += integerPartBinary.length() - firstOneIndex - 1; // Shifting the binary point to the correct position and do the bias
            mantissaBinary = mantissaBinary.substring(firstOneIndex + 1); // Dropping the first 1
        }

        // Making sure the mantissa is 23 bits
        if (mantissaBinary.length() > 23) {
            mantissaBinary = mantissaBinary.substring(0, 23);
        } else {
            while (mantissaBinary.length() < 23) {
                mantissaBinary += "0";
            }
        }

        // Converting exponent to binary
        String exponentBinary = Integer.toBinaryString(exponent);
        while (exponentBinary.length() < 8) {
            exponentBinary = "0" + exponentBinary;
        }

        // Combining sign, exponent, and mantissa to get the final IEEE 754 representation
        return sign + " | " + exponentBinary + " | " + mantissaBinary;
    }

    // Translate back to decimal
    public static float iEEE754ToFloat(String ieee754) {
        // Split the input string into sign, exponent, and mantissa parts
        String[] parts = ieee754.split("\\|");

        // Extract and parse the sign bit (0 for positive, 1 for negative)
        int sign = Integer.parseInt(parts[0].trim());

        // If sign is 1, set the signMultiplier to -1, otherwise set it to 1
        int signMultiplier = 1;
        if (sign == 1) {
            signMultiplier = -1;
        }

        // Extract the exponent part (in binary) and convert it to an integer
        String exponentBinary = parts[1].trim();
        int exponent = 0;
        for (int i = 0; i < exponentBinary.length(); i++) {
            exponent = exponent * 2 + (exponentBinary.charAt(i) - '0');
        }

        // Subtract the bias (127) from the exponent
        exponent = exponent - 127;

        // Extract the mantissa part (in binary) and calculate the decimal value
        String mantissaBinary = parts[2].trim();
        float mantissa = 1.0f; // Start with an implicit 1
        float fraction = 0.5f; // Start with the fraction representing 2^-1
        for (int i = 0; i < mantissaBinary.length(); i++) {
            if (mantissaBinary.charAt(i) == '1') {
                mantissa = mantissa + fraction;
            }
            fraction = fraction / 2; // Move to the next fraction 2^-(i+2)
        }

        // Calculate the final float value: signMultiplier * mantissa * 2^exponent
        float result = signMultiplier * mantissa * (float) Math.pow(2, exponent);

        return result;
    }


    // Adds two float numbers
    public static float add(float num1, float num2) {
        return num1 + num2;
    }

    // Divides two float numbers
    public static float divide(float num1, float num2) {
        return num1 / num2;
    }

    // Generates positive infinity
    public static float generatePositiveInfinity() {
        return Float.POSITIVE_INFINITY;
    }

    // Generates negative infinity
    public static float generateNegativeInfinity() {
        return Float.NEGATIVE_INFINITY;
    }

    // Generates NaN (Not a Number)
    public static float generateNaN() {
        return Float.NaN;
    }

    // Checks if a float value is NaN
    public static boolean isNaN(float value) {
        return Float.isNaN(value);
    }

    // Rounds a float-point number using the specified rounding mode
    public static float roundToNearest(float value) {
        return Math.round(value);
    }

    public static float roundTowardsZero(float value) {
        if (value > 0) {
            return (float) Math.floor(value); // Return the truncated value for positive numbers
        } else if (value < 0) {
            return (float) Math.ceil(value); // For negative numbers, the truncated value is already towards zero
        } else {
            return 0.0f; // If the value is 0, return 0
        }
    }

    public static float roundTowardsPositiveInfinity(float value) {
        return (float) Math.ceil(value);
    }

    public static float roundTowardsNegativeInfinity(float value) {
        return (float) Math.floor(value);
    }

    // Demonstrates underflow
    public static float underflow() {
        return 1.4e-45f / 10; // Directly putting in the numbers will cause error
    }

    // Demonstrates overflow
    public static float overflow() {
        return 3.4e38f * 10;
    }
}
