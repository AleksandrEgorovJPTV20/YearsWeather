package yearsweather;

import java.util.Random;
import java.util.Scanner;

public class YearsWeather {
    static enum Month{
        Январь, Февраль, Март, Апрель, Май, Июнь, Июль, Август, Сентябрь, Октябрь, Ноябрь, Декабрь
    }
    public static void main(String[] args) {
        //Создаем min и max, переменные минимальной и максимальной температуры
        int min=-30, max=30;
        //Создаем зубчатый массив из 12 строк
        int[][] dayTempYear = new int[12][];
        //Заполняем массив (Кол-вом дней в каждом месяце)
        Random random = new Random();
        for(int i = 0; i < dayTempYear.length; i++) {
            int n = 0; //Переменная, хранящая данные об кол-во дней в месяце
            switch(i) {
                case 2: min = -5; max = 15;n = 31;break; // Март
                case 3: min = -5; max = 15;n = 30;break; // Апрель
                case 4: min = -5; max = 15;n = 31;break; // Май
                case 5: min = 5;  max = 30;n = 30;break; // Июнь
                case 6: min = 5;  max = 30;n = 31;break; // Июль
                case 7: min = 5;  max = 30;n = 31;break; // Август
                case 8: min = -10;max = 10;n = 30;break; // Сентябрь
                case 9: min = -10;max = 10;n = 31;break; // Октябрь
                case 10:min = -10;max = 10;n = 30;break; // Ноябрь
                case 11:min = -30;max = 0; n = 31;break; // Декабрь
                case 0: min = -30;max = 0; n = 31;break; // Январь
                case 1: min = -30;max = 0; n = 28;break; // Февраль
            }
            //Цикл,к каждому дню месяца даём случайное значение температуры,  пока в каждом дне месяца не будет температура.
            dayTempYear[i] = new int[n];
            for(int j = 0;j < dayTempYear[i].length; j++) {
                dayTempYear[i][j] = random.nextInt(max - min + 1)+min; // Массив заполняется случайными значениеми температуры для дней в месяце
            }
        }
         //Циклы вывода месяца и температуры каждого дня в каждом месяце. Не выведится на экран полностью.
        for(int i = 0; i < dayTempYear.length; i++) {
            System.out.printf("%8s:",Month.values()[i]); //Выводит название месяца по индексу из списка enum month
            for(int j = 0; j < dayTempYear[i].length; j++) {
                System.out.printf("%4d", dayTempYear[i][j]); //Вывод температуры каждого дня в месяце
            }
            System.out.println();
        }
        //Средняя арифметическая каждого месяца
        double[] averageTempMonth = new double[12]; //Создали массив для средней температуры
        for(int i = 0; i < dayTempYear.length; i++) { //Цикл работает пока массив не заполнится средней температурой.
            int daysInMonth=0; //Переменная дней месяцев
            for(int j = 0; j < dayTempYear[i].length; j++) {
                averageTempMonth[i] += (double)dayTempYear[i][j]; // Температура всех дней месяца в массиве складывается, пока дни не закончится.
                daysInMonth=j+1; 
            }
            averageTempMonth[i] = averageTempMonth[i]/daysInMonth; //Сумму температуры всех дней месяца делим на кол-во дней месяца.
        }
        System.out.println("\nСредняя температура по месяцам: ");
        for(int i = 0; i < averageTempMonth.length; i++) {
            System.out.printf("%8s: %-4.2f%n",Month.values()[i], averageTempMonth[i]); //Вывод средней температуры месяцев
        }
        //Погода по дате. День и Месяц.
        //String массив строк с месяцами 0-11 индекс.
        String[] months = {"января", "февраля", "марта", "апреля", "мая", "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря"};
        System.out.print("\nВведите день: "); //Вводим число дня месяца
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        System.out.print("Число месяца: ");
        int month = scanner.nextInt(); //Вводим индекс месяца 0-11
        System.out.println(day + " " + months[month-1] + " погода составляла " + dayTempYear[month-1][day-1] + " °C");
        
        //Теплая и холодная температура
        int maxTemp = 0;
        int minTemp = 0;
        int maxDayTemp = 0 ;
        int monthMaxTemp = 0;
        int minDayTemp = 0;
        int minMonthTemp = 0;
        //Цикл ищёт в массиве наибольшую температуру и наименьшую температуру в массиве dayTempYear
        for(int i = 0; i < dayTempYear.length; i++) {
            for(int j = 0; j < dayTempYear[i].length; j++) {
                if(dayTempYear[i][j] > maxTemp) { //Если DayTempYear > maxTemp, то есть температура дня больше 0 то присваеваем перменной температуру этого дня.
                    maxTemp = dayTempYear[i][j]; //Индекс i месяц, j день.
                    monthMaxTemp = i;
                    maxDayTemp = j;
                }
                // Точно также как с максимальной, но минимальная.
                if(dayTempYear[i][j] < minTemp) {
                    minTemp = dayTempYear[i][j];
                    minDayTemp = j; 
                    minMonthTemp = i;
                }
            }
        }
        System.out.println("Максимальная температура: " + maxTemp + " °C"+ " была она и" + maxDayTemp + " " + months[monthMaxTemp]);
        System.out.println("Минимальная температура: " + minTemp + " °C" + " была она " + minDayTemp + " " + months[minMonthTemp]);
    }
}