
package yearsweather;

import java.util.Arrays;
import java.util.Random;

public class YearsWeather {
    static enum Month{
        January, February, March, April, May, June, July, August, September, October, November, December
    }
    
    public static void main(String[] args) {
        // min и max
        int min=-30, max=30;
        //Зубчатый массив из 12 строк
        int[][] dayTempYear = new int[12][];
//        dayTempYear[0] = new int[31]; //January
//        dayTempYear[1] = new int[28]; //February
//        dayTempYear[2] = new int[31]; //March
//        dayTempYear[3] = new int[30]; //April
//        dayTempYear[4] = new int[31]; //May
//        dayTempYear[5] = new int[30]; //June
//        dayTempYear[6] = new int[31]; //July
//        dayTempYear[7] = new int[31]; //August
//        dayTempYear[8] = new int[30]; //September
//        dayTempYear[9] = new int[31]; //October
//        dayTempYear[10] = new int[30]; //November
//        dayTempYear[11] = new int[31]; //December
        Random random = new Random();
        for(int i=0;i<dayTempYear.length;i++){
            int n = 0;
            switch(i){                  
                case 2:min = -5; max = 15; n = 31; break;
                case 3:min = -5; max = 15; n = 30; break;
                case 4:min = -5; max = 15; n = 31; break;
                case 5:min = 5; max = 30; n = 30; break;
                case 6:min = 5; max = 30; n = 31; break;
                case 7:min = 5; max = 30; n = 31; break;
                case 8:min = -10; max = 10; n = 30; break;
                case 9:min = -10; max = 10; n = 31; break;
                case 10:min = -10; max = 10; n = 30; break;
                case 11:min = -30; max = 0; n = 31; break;
                case 0:min = -30; max = 0; n = 31; break;
                case 1:min = -30; max = 0; n = 28; break; 
            }
            dayTempYear[i] = new int[n];
            for(int j = 0;j<dayTempYear[i].length;j++){
                dayTempYear[i][j] = random.nextInt(max-min+1)+min;   
            }
        }
//            for(int j=0; j < dayTempYear[i].length;j++){
//                if(i==11 || i == 0 || i == 1){
//                    min = -30;
//                    max = 0;
//                }else if (i==2 || i == 3 || i == 4){
//                    min = -5;
//                    max = 15;
//                }else if (i==5 || i == 6 || i == 7) {
//                    min = 5;
//                    max = 30;
//                }else if (i==8 || i == 9 || i == 10){
//                    min = -10;
//                    max = 10;
//                }
//                dayTempYear[i][j] = random.nextInt(max-min+1)+min;
//                
//            }            
//        for(int i=0;i<dayTempYear.length;i++){
//            System.out.println(Arrays.toString(dayTempYear[i]));
        for(int i=0;i<dayTempYear.length;i++){
            System.out.printf("%-8s: ",Month.values()[i]);
            for(int j=0; j < dayTempYear[i].length;j++){         
                System.out.printf("%4d", dayTempYear[i][j]);
            }
            System.out.println();
        }
        double[] averageMonthTemp = new double[12];
        for(int i = 0;i<dayTempYear.length;i++){
            int daysMonth = 0;
            for(int j=0; j < dayTempYear[i].length;j++){
                averageMonthTemp[i] += (double)dayTempYear[i][j];
                daysMonth = j+1;
            }
            averageMonthTemp[i]=averageMonthTemp[i]/daysMonth;
        }
        System.out.println("\nAverage Temperature by months: ");
        for (int i=0;i<averageMonthTemp.length;i++){
            System.out.printf("%-8s: %-4.2f%n", Month.values()[i], averageMonthTemp[i]);
//            switch(i) {
//                case 0:
//                    System.out.printf("January: %-4.2f%n",averageMonthTemp[i]);
//                    break;
//                case 1:
//                    System.out.printf("February: %-4.2f%n",averageMonthTemp[i]);
//                    break;
//                case 2:
//                    System.out.printf("March: %-4.2f%n",averageMonthTemp[i]);
//                    break;
//                case 3:
//                    System.out.printf("April: %-4.2f%n",averageMonthTemp[i]);
//                    break;
//                case 4:
//                    System.out.printf("May: %-4.2f%n",averageMonthTemp[i]);
//                    break;
//                case 5:
//                    System.out.printf("June: %-4.2f%n",averageMonthTemp[i]);
//                    break;
//                case 6:
//                    System.out.printf("July: %-4.2f%n",averageMonthTemp[i]);
//                    break;
//                case 7:
//                    System.out.printf("August: %-4.2f%n",averageMonthTemp[i]);
//                    break;
//                case 8:
//                    System.out.printf("September: %-4.2f%n",averageMonthTemp[i]);
//                    break;
//                case 9:
//                    System.out.printf("October: %-4.2f%n",averageMonthTemp[i]);
//                    break;
//                case 10:
//                    System.out.printf("November: %-4.2f%n",averageMonthTemp[i]);
//                    break;
//                case 11:
//                    System.out.printf("December: %-4.2f%n",averageMonthTemp[i]);
//                    break;
//            }
        }
    }
    
}
