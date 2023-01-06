import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
public class hamming {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String nums = s.nextLine();
        String[] message = nums.split("");
        System.out.println("Полученное сообщение: " +
                message[0] + message[1] + message[2] + message[3] +
                message[4] + message[5] + message[6]);
//Найдем контрольные суммы:
        String sum1 = message[0] + message[2] + message[4]
                + message[6];
        int numberOfOnes1 = 0;
        for (char element : sum1.toCharArray()) {
            if (element == '1') numberOfOnes1++;
        }
        String ostSum1 = "" + (numberOfOnes1 % 2);
        String Sum2 = message[1] + message[2] + message[5]
                + message[6];
        int numberOfOnes2 = 0;
        for (char element : Sum2.toCharArray()) {
            if (element == '1') numberOfOnes2++;
        }
        String ostSum2 = "" + (numberOfOnes2 % 2);
        String sum3 = message[3] + message[4] + message[5]
                + message[6];
        int numberOfOnes3 = 0;
        for (char element : sum3.toCharArray()) {
            if (element == '1') numberOfOnes3++;
        }
        String ostSum3 = "" + (numberOfOnes3 % 2);
//Синдром S:
        String SindromS = (ostSum1 + ostSum2 + ostSum3);
        System.out.println("Синдром S равен: " +
                SindromS);
//Устранение ошибок:
        if (Objects.equals(SindromS, "000")) {
            System.out.println("Ошибок не выявлено");
            System.out.println("Исходный код: " +
                    message[2] + message[4] + message[5] + message[6]);
        } else if (Objects.equals(SindromS, "001")) {
            System.out.println("Ошибка в бите четности - r3");
            System.out.println("Исходный код: " +
                    message[2] + message[4] + message[5] + message[6]);
        } else if (Objects.equals(SindromS, "010")) {
            System.out.println("Ошибка в бите четности - r2");
            System.out.println("Исходный код: " +
                    message[2] + message[4] + message[5] + message[6]);
        } else if (Objects.equals(SindromS, "100")) {
            System.out.println("Ошибка в бите четности - r1");
            System.out.println("Исходный код: " +
                    message[2] + message[4] + message[5] + message[6]);
        } else if (Objects.equals(SindromS, "011")) {
            System.out.println("Ошибка в информационном бите - i3");
            if (Objects.equals(message[5], "0")) {
//int i = 5;
                message[5] = message[5].replace('0', '1');
                System.out.println("Исходный код: " +
                        message[2] + message[4] + message[5] + message[6]);
            } else if (Objects.equals(message[5], "1")) {
                message[5] = message[5].replace('1', '0');
                System.out.println("Исходный код: " +
                        message[2] + message[4] + message[5] + message[6]);
            }
        } else if (Objects.equals(SindromS, "101")) {
            System.out.println("Ошибка в информационном бите - i2");
            if (Objects.equals(message[4], "0")) {
                message[4] = message[4].replace('0', '1');
                System.out.println("Исходный код: " +
                        message[2] + message[4] + message[5] + message[6]);
            } else if (Objects.equals(message[4], "1")) {
                message[4] = message[4].replace('1', '0');
                System.out.println("Исходный код: " +
                        message[2] + message[4] + message[5] + message[6]);
            }
        } else if (Objects.equals(SindromS, "110")) {
            System.out.println("Ошибка в информационном бите - i1");
            if (Objects.equals(message[2], "0")) {
                message[2] = message[2].replace('0', '1');
                System.out.println("Исходный код: " +
                        message[2] + message[4] + message[5] + message[6]);
            } else if (Objects.equals(message[2], "1")) {
                message[2] = message[2].replace('1', '0');
                System.out.println("Исходный код: " +
                        message[2] + message[4] + message[5] + message[6]);
            }
        } else if (Objects.equals(SindromS, "111")) {
            System.out.println("Ошибка в информационном бите - i4");
            if (Objects.equals(message[6], "0")) {
                message[6] = message[6].replace('0', '1');
                System.out.println("Исходный код: " +
                        message[2] + message[4] + message[5] + message[6]);
            } else if (Objects.equals(message[6], "1")) {
                message[6] = message[6].replace('1', '0');
                System.out.println("Исходный код: " +
                        message[2] + message[4] + message[5] + message[6]);
            }
        }
    }
}
