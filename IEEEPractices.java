public class IEEEPractices {
    // Converts a float to its IEEE 754 32-bit binary representation
    public static String floatToIEEE754(float value) {
        int intBits = Float.floatToIntBits(value);
        String binaryString = String.format("%32s", Integer.toBinaryString(intBits)).replace(' ', '0');

        // Extract the sign, exponent, and mantissa from the binary string
        String sign = binaryString.substring(0, 1);
        String exponent = binaryString.substring(1, 9);
        String mantissa = binaryString.substring(9);

        return sign + " | " + exponent + " | " + mantissa;

//        // Getting the sign bit
//        int sign = (value < 0) ? 1 : 0;
//
//        // Getting the integer part and the fractional part
//        value = Math.abs(value);
//        int integerPart = (int) value;
//        float fractionalPart = value - integerPart;
//
//        // Converting integer part to binary
//        String integerPartBinary = Integer.toBinaryString(integerPart);
//
//        // Converting fractional part to binary
//        StringBuilder fractionalPartBinary = new StringBuilder();
//        while (fractionalPart > 0 && fractionalPartBinary.length() < 23) { // Limiting to 23 bits for the significand
//            fractionalPart *= 2;
//            if (fractionalPart >= 1) {
//                fractionalPartBinary.append(1);
//                fractionalPart -= 1;
//            } else {
//                fractionalPartBinary.append(0);
//            }
//        }
//
//        // Combining integer and fractional parts
//        String mantissaBinary = integerPartBinary + fractionalPartBinary.toString();
//
//        // Normalizing the binary representation
//        int exponent = 127; // Bias for single-precision floating-point
//        int firstOneIndex = mantissaBinary.indexOf('1'); // Finding the first 1
//        if (firstOneIndex > -1) {
//            exponent += integerPartBinary.length() - firstOneIndex - 1; // Shifting the binary point to the correct position and do the bias
//            mantissaBinary = mantissaBinary.substring(firstOneIndex + 1); // Dropping the first 1
//        }
//
//        // Making sure the mantissa is 23 bits
//        if (mantissaBinary.length() > 23) {
//            mantissaBinary = mantissaBinary.substring(0, 23);
//        } else {
//            while (mantissaBinary.length() < 23) {
//                mantissaBinary += "0";
//            }
//        }
//
//        // Converting exponent to binary
//        String exponentBinary = Integer.toBinaryString(exponent);
//        while (exponentBinary.length() < 8) {
//            exponentBinary = "0" + exponentBinary;
//        }
//
//        // Combining sign, exponent, and mantissa to get the final IEEE 754 representation
//        return sign + " | " + exponentBinary + " | " + mantissaBinary;
    }

//    // Converts IEEE 754 32-bit binary representation back to a float decimal number
//    public static float iEEE754ToFloat(String ieee754) {
//        // Splitting the IEEE 754 format into its components
//        String[] parts = ieee754.split("\\|");
//
//        // Extracting sign bit, exponent binary, and mantissa binary
//        int sign = Integer.parseInt(parts[0].trim());
//        String exponentBinary = parts[1].trim();
//        String mantissaBinary = parts[2].trim();
//
//        // Converting exponent from binary to integer
//        int exponent = Integer.parseInt(exponentBinary, 2);
//
//        // Converting mantissa from binary to decimal
//        float mantissa = 1.0f; // Start with implicit 1
//        for (int i = 0; i < mantissaBinary.length(); i++) {
//            if (mantissaBinary.charAt(i) == '1') {
//                mantissa += Math.pow(2, -(i + 1));
//            }
//        }
//
//        // Adjusting exponent with bias
//        exponent -= 127;
//
//        // Building the final float value
//        float result = (float) (sign == 0 ? 1 : -1) * mantissa * (float) Math.pow(2, exponent);
//
//        return result;
//    }


    // Rounds a float to the nearest value with the specified number of decimal places
    public static float roundToNearest(float value, int decimals) {
        float scale = (float) Math.pow(10, decimals);
        return Math.round(value * scale) / scale;
    }

    // Rounds a float towards zero with the specified number of decimal places
    public static float roundTowardsZero(float value, int decimals) {
        float scale = (float) Math.pow(10, decimals);
        return (value >= 0) ? (float) Math.floor(value * scale) / scale : (float) Math.ceil(value * scale) / scale;
    }

    // Rounds a float towards positive infinity with the specified number of decimal places
    public static float roundTowardsPositiveInfinity(float value, int decimals) {
        float scale = (float) Math.pow(10, decimals);
        return (float) Math.ceil(value * scale) / scale;
    }

    // Rounds a float towards negative infinity with the specified number of decimal places
    public static float roundTowardsNegativeInfinity(float value, int decimals) {
        float scale = (float) Math.pow(10, decimals);
        return (float) Math.floor(value * scale) / scale;
    }

}
