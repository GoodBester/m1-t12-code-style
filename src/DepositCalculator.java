import java.util.Scanner;


public class DepositCalculator {
    double calculateComplexPercent(double amount, double doubleYearRate, int depositPeriod ) {
        double pay = amount * Math.pow((1 + doubleYearRate / 12), 12 * depositPeriod);

        return roundValue(pay, 2);
  }
    double calculateSimplePercent(double amount, double doubleYearRate, int depositPeriod) {
        return roundValue(amount + amount * doubleYearRate * depositPeriod, 2);
    }
    double roundValue(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
}
    void printFunctions() {
        int period;
        int action;
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scan.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scan.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scan.nextInt();
        double money = 0;
        if (action ==1) {
            money = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            money = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + money);
    }

    public static void main(String[] args) {
        new DepositCalculator().printFunctions();
}


}
