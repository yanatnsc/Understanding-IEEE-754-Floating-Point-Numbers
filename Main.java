//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Convert Decimal to IEEE 754
        System.out.println("1. Convert Decimal to IEEE 754 Format");
        System.out.println();

        float decimalNumber1 = 80.125f; // Using 'f' to indicate a float, otherwise there will be errors
        String ieee7541 = IEEEPractices.floatToIEEE754(decimalNumber1);
        System.out.println("Decimal number 1: " + decimalNumber1);
        System.out.println("IEEE 754: " + ieee7541);
        System.out.println();

        float decimalNumber2 = -0.8125f; // Using 'f' to indicate a float, otherwise there will be errors
        String ieee7542 = IEEEPractices.floatToIEEE754(decimalNumber2);
        System.out.println("Decimal number 2: " + decimalNumber2);
        System.out.println("IEEE 754: " + ieee7542);
        System.out.println();

        // Arithmetic Operations
        System.out.println("2. Arithmetic Operations");
        System.out.println();

        float additionResult = 0.1f + 0.2f;
        System.out.println("Decimal result of 0.1 + 0.2: " + additionResult);
        System.out.println("IEEE 754: " + IEEEPractices.floatToIEEE754(additionResult));
        System.out.println("Decimal result expected: 3.0");
        System.out.println();

        float divisionResult = 1.0f / 3.0f;
        System.out.println("Decimal result of 1.0 / 3.0: " + divisionResult);
        System.out.println("IEEE 754: " + IEEEPractices.floatToIEEE754(divisionResult));
        System.out.println("Decimal result expected: 0.33333333 (repeating 3)");
        System.out.println();

        // Special Values Handling
        System.out.println("3. Special Values Handling");
        System.out.println();

        System.out.println("Positive Infinity: " + Float.POSITIVE_INFINITY);
        System.out.println("Negative Infinity: " + Float.NEGATIVE_INFINITY);
        System.out.println("NaN: " + Float.NaN);
        System.out.println("Is NaN equal to itself? " + (Float.NaN == Float.NaN));
        System.out.println();

        // Rounding Modes
        System.out.println("4. Rounding Modes");
        System.out.println();

        float value1 = 80.125f;
        int decimals = 2;
        System.out.println("Original value 1: " + value1);

        float roundNearest1 = IEEEPractices.roundToNearest(value1, decimals);
        System.out.println("Rounding to nearest: " + roundNearest1);

        float roundZero1 = IEEEPractices.roundTowardsZero(value1, decimals);
        System.out.println("Rounding towards zero: " + roundZero1);

        float roundPosInfinity1 = IEEEPractices.roundTowardsPositiveInfinity(value1, decimals);
        System.out.println("Rounding towards positive infinity: " + roundPosInfinity1);

        float roundNegInfinity1 = IEEEPractices.roundTowardsNegativeInfinity(value1, decimals);
        System.out.println("Rounding towards negative infinity: " + roundNegInfinity1);
        System.out.println();

        float value2 = -0.8125f;
        System.out.println("Original value 2: " + value2);

        float roundNearest2 = IEEEPractices.roundToNearest(value2, decimals);
        System.out.println("Rounding to nearest: " + roundNearest2);

        float roundZero2 = IEEEPractices.roundTowardsZero(value2, decimals);
        System.out.println("Rounding towards zero: " + roundZero2);

        float roundPosInfinity2 = IEEEPractices.roundTowardsPositiveInfinity(value2, decimals);
        System.out.println("Rounding towards positive infinity: " + roundPosInfinity2);

        float roundNegInfinity2 = IEEEPractices.roundTowardsNegativeInfinity(value2, decimals);
        System.out.println("Rounding towards negative infinity: " + roundNegInfinity2);
        System.out.println();

        // Underflow and Overflow
        System.out.println("6. Underflow and Overflow");
        System.out.println();

        System.out.println("Original value 1: 1.0e-46f");
        System.out.println("Underflow result: " + 1e-45f / 10);
        System.out.println();

        System.out.println("Original value 2: 3e39f");
        System.out.println("Overflow result: " + 3e38f * 10);
        System.out.println();
    }
}