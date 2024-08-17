//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {
        // Convert Decimal to IEEE 754
        float decimalNumber1 = 85.125F; // Will get error if the F is skipped
        String ieee7541 = IEEEPractices.floatToIEEE754(decimalNumber1);
        System.out.println("Decimal: " + decimalNumber1);
        System.out.println("IEEE 754: " + ieee7541);
        System.out.println();
        float decimalNumber2 = -0.85125F; // Will get error if the F is skipped
        String ieee7542 = IEEEPractices.floatToIEEE754(decimalNumber2);
        System.out.println("Decimal: " + decimalNumber2);
        System.out.println("IEEE 754: " + ieee7542);
        System.out.println();

        // Arithmetic Operations
        float num1 = 0.1F;
        float num2 = 0.2F;
        float additionResult = IEEEPractices.add(num1, num2);
        System.out.println("0.1 + 0.2");
        System.out.println("Decimal result: " + additionResult);
        System.out.println("IEEE 754 translate: " + IEEEPractices.floatToIEEE754(additionResult));
        System.out.println("Back to decimal: " + IEEEPractices.iEEE754ToFloat(IEEEPractices.floatToIEEE754(additionResult)));
        System.out.println();
        // Validation: https://www.h-schmidt.net/FloatConverter/IEEE754.html

        float num3 = 1.0F;
        float num4 = 3.0F;
        float divisionResult = IEEEPractices.divide(num3, num4);
        System.out.println("1.0 / 3.0");
        System.out.println("Decimal result: " + divisionResult);
        System.out.println("IEEE 754 translate: " + IEEEPractices.floatToIEEE754(divisionResult));
        System.out.println("Back to decimal: " + IEEEPractices.iEEE754ToFloat(IEEEPractices.floatToIEEE754(divisionResult)));
        System.out.println();

        // Special Values Handling
        float posInf = IEEEPractices.generatePositiveInfinity();
        float negInf = IEEEPractices.generateNegativeInfinity();
        float nan = IEEEPractices.generateNaN();
        System.out.println("Positive Infinity: " + posInf);
        System.out.println("Negative Infinity: " + negInf);
        System.out.println("NaN: " + nan);
        System.out.println("Does NaN equal to itself? " + (nan == nan));
        System.out.println();

        // Rounding Modes
        float value1 = 85.125F;
        System.out.println("Original value: " + value1);
        float roundNearest1 = IEEEPractices.roundToNearest(value1);
        System.out.println("Rounding to nearest: " + roundNearest1);
        float roundZero1 = IEEEPractices.roundTowardsZero(value1);
        System.out.println("Rounding towards zero: " + roundZero1);
        float roundPosInfinity1 = IEEEPractices.roundTowardsPositiveInfinity(value1);
        System.out.println("Rounding towards positive infinity: " + roundPosInfinity1);
        float roundNegInfinity1 = IEEEPractices.roundTowardsNegativeInfinity(value1);
        System.out.println("Rounding towards negative infinity: " + roundNegInfinity1);

        System.out.println();

        float value2 = -0.85125F;
        System.out.println("Original value: " + value2);
        float roundNearest2 = IEEEPractices.roundToNearest(value2);
        System.out.println("Rounding to nearest: " + roundNearest2);
        float roundZero2 = IEEEPractices.roundTowardsZero(value2);
        System.out.println("Rounding towards zero: " + roundZero2);
        float roundPosInfinity2 = IEEEPractices.roundTowardsPositiveInfinity(value2);
        System.out.println("Rounding towards positive infinity: " + roundPosInfinity2);
        float roundNegInfinity2 = IEEEPractices.roundTowardsNegativeInfinity(value2);
        System.out.println("Rounding towards negative infinity: " + roundNegInfinity2);

        System.out.println();

        // Underflow and Overflow
        float underflowResult = IEEEPractices.underflow();
        float overflowResult = IEEEPractices.overflow();
        System.out.println("Underflow result: " + underflowResult);
        System.out.println("Overflow result: " + overflowResult);
    }
}
