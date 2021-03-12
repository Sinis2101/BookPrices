import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static String getBestPrices(int[] prices, int money) {

        boolean flag = true;
        int minDiff = 0;
        int price1 = 0;
        int price2 = 0;

        for (int i = 0; i < prices.length ; i++) {
            for (int j = i+1; j < prices.length; j++) {

                if(prices[i]+prices[j]==money) {

                    int difference = Math.abs(prices[i]-prices[j]);

                    price1 = prices[i];
                    price2 = prices[j];

                    if(flag) {
                        minDiff = difference;
                        flag = false;
                    }

                    if(difference<minDiff) {

                        minDiff = difference;

                        if(prices[i]<prices[j]) {
                            price1 = prices[i];
                            price2 = prices[j];
                        } else {
                            price1 = prices[j];
                            price2 = prices[i];
                        }

                    }

                }

            }

        }

        return "Peter should buy books whose prices are " + price1 + " and " + price2 + "\n";

    }

    public static void main(String[] args) throws IOException {

        String line;
        int[] prices;

        do{

            line = br.readLine();
            int books = Integer.parseInt(line);

            prices = new int[books];

            line = br.readLine();
            String[] parts = line.split(" ");

            for(int i = 0; i < parts.length; i++) {

                prices[i] = Integer.parseInt(parts[i]);

            }

            line = br.readLine();
            int money = Integer.parseInt(line);

            bw.write(getBestPrices(prices, money));

            line = br.readLine();

        }while(line != null);

        br.close();
        bw.close();

    }

}
