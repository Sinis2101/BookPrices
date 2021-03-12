import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        int[] prices = {10, 2, 6, 8, 4};
        int money = 10;
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

        System.out.println("Peter should buy books whose prices are " + price1 + " and " + price2);

    }

}
