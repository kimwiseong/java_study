package struct.ex.score;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        int[] kors = new int[3];
        
        boolean flag = true;
        while(flag) {
            switch (inputMenu()) {
                case 1:
                    inputScore(kors);
                    break;
                case 2:
                    printScore(kors);
                    break;
                case 3:
                    flag = false;
                    break;
                default:break;
            }
        }

    }


    static int inputMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" 1. 성적입력\n 2. 성적출력\n 3. 종료메뉴\n 입력 >> ");
        int menu = scanner.nextInt();
        return menu;
    }

    static void printScore(int[] kors) {
        int total = 0;

        for (int i = 0; i < 3; i++) {
            total += kors[i];
            System.out.println(i + 1 + ": " + kors[i]);
        }

        double avg = total/3.0f;
        System.out.printf("총점 : %3d\n", total);
        System.out.printf("평균 : %3.2f\n", avg);
    }

    static void inputScore(int[] kors) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("<성적 입력>");
        for (int i = 0; i < 3; i++)
            kors[i] = scanner.nextInt();

    }
}
