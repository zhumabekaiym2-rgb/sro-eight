package kz.kaznu.aiym.first;

public class MainApp {
    public static void main(String[] args) {

        double R = 8.314;
        double a = 0.364;
        double b = 0.000427;

        double P = 5000000.0;
        double T = 300.0;
        double eps = 0.000001;


        double xLeft = b + 0.00001;
        double xRight = (R * T) / P + b;

        double xMiddle = 0;
        int iterations = 0;


        while ((xRight - xLeft) / 2.0 > eps) {
            xMiddle = (xLeft + xRight) / 2.0;

            double fLeft = (P + a / (xLeft * xLeft)) * (xLeft - b) - R * T;
            double fMiddle = (P + a / (xMiddle * xMiddle)) * (xMiddle - b) - R * T;


            if (fLeft * fMiddle < 0) {
                xRight = xMiddle;
            } else {
                xLeft = xMiddle;
            }
            iterations++;
        }


        System.out.println("Молярный объем V = " + xMiddle + " м3/моль");
        System.out.println("Количество итераций: " + iterations);
    }
}