public class Main {


    public static void main(String[] args) {
//       stringSteepMartinTwo();
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
        int cicle = 100;

        StringBuilder stringBuilder = new StringBuilder("BalanceRestBuy = 0.0001@V\nBalanceRestSell = ");

        for (int i = 0; i < cicle; i++) {
            stringBuilder.append(value);
            if (i < cicle - 1) {
                stringBuilder.append("*");
            } else {
                stringBuilder.append("@V");
            }
            value = value + 0.001;
        }

        stringBuilder.append("\nInterval = oneMin\n" +
                "FreqUpdate = 2000\n" +
                "SellOnlyBought = False\n" +
                "WriteToFile = True\n" +
                "IsDirectionLong = True\n" +
                "StepRepresentEnter = ");

        for (int i = 0; i < cicle; i++) {
            stringBuilder.append("0.3");
            if (i < cicle - 1) {
                stringBuilder.append("*");
            } else {
                stringBuilder.append("@P");
            }
        }

        stringBuilder.append("\nStepRepresentClose = ");

        for (int i = 0; i < cicle; i++) {
            stringBuilder.append("0.8");
            if (i < cicle - 1) {
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
        double plus = 0.10;
        double take = 0.6;
        int block = 100;

        for (int i = 0; i < block; i++) {
            String[] strings = ("" + steep).split("\\.");
            String string = strings[0] + "." + strings[1].substring(0, strings[1].length() == 1 ? 1 : 2);

            stringBuilder.append("\"").append(string)
                    .append("@P*").append(take)
                    .append("@P*").append(value)
                    .append("@V\"");
            if (i != block - 1) {
                stringBuilder.append(", ");
            } else {
                stringBuilder.append("]");
            }
            steep = Double.parseDouble(string) + plus;
        }
        System.out.println(stringBuilder.toString());
    }
}
