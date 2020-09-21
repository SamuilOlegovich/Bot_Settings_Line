public class Main {


    public static void main(String[] args) {
       stringSteepMartinTwo();
       stringSteepMartin();
    }



    // BalanceRestBuy = 20*40*60*120*240*480*960*2560*5120*10240@V
    // BalanceRestSell = 0,0001@V
    // Interval = oneMin
    // FreqUpdate = 2000
    // SellOnlyBought = False
    // WriteToFile = True
    // IsDirectionLong = True
    // StepRepresentEnter = 4*4,17*4,35*4,54*7,14*7,69*10,41*11,63*15,79@P
    // StepRepresentClose = 1,7*1,7*1,7*1,9*1,9*2*2*2,2*2,2*2,2*2,2@P
    private static void stringSteepMartin() {
        double value = 0.001;
        double steep = 0.1;
        double take = 0.6;
        int block = 100;
        int start = 1;

        StringBuilder stringBuilder = new StringBuilder("BalanceRestBuy = 0.0001@V\nBalanceRestSell = ");

        for (int i = 0; i < block; i++) {
            stringBuilder.append(start / 1000.00);
            if (i < block - 1) {
                stringBuilder.append("*");
            } else {
                stringBuilder.append("@V");
            }
            start++;
        }

        stringBuilder.append("\nInterval = oneMin\n" +
                "FreqUpdate = 2000\n" +
                "SellOnlyBought = False\n" +
                "WriteToFile = True\n" +
                "IsDirectionLong = True\n" +
                "StepRepresentEnter = ");

        for (int i = 0; i < block; i++) {
            stringBuilder.append("0.3");
            if (i < block - 1) {
                stringBuilder.append("*");
            } else {
                stringBuilder.append("@P");
            }
        }

        stringBuilder.append("\nStepRepresentClose = ");

        for (int i = 0; i < block; i++) {
            stringBuilder.append("0.8");
            if (i < block - 1) {
                stringBuilder.append("*");
            } else {
                stringBuilder.append("@P");
            }
        }
        System.out.println(stringBuilder.toString());
    }



    private static void stringSteepMartinTwo() {
        StringBuilder stringBuilder = new StringBuilder("AdditionalTrading1 = [");
        double value = 0.001;
        double steep = 0.1;
        double take = 0.6;
        int block = 100;
        int start = 1;

        for (int i = 0; i < block; i++) {
            stringBuilder.append("\"").append(start / 10.0)
                    .append("@P*").append(take)
                    .append("@P*").append(value)
                    .append("@V\"");
            if (i != block - 1) {
                stringBuilder.append(", ");
            } else {
                stringBuilder.append("]");
            }
            start++;
        }
        System.out.println(stringBuilder.toString());
    }
}
