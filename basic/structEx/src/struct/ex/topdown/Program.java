package struct.ex.topdown;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        int[][] lottos = null;
        int menu;
        boolean flag = true;

        while(flag) {
            menu = inputMenu();
            switch (menu) {
                case 1:
                    lottos = createLottosAuto();
                    break;
                case 2:
                    lottos = createLottosManual();
                    break;
                case 3:
                    printLottos(lottos);
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

    static int inputMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" 1. 로또자동생성 \n 2. 로또수동생성  \n 3. 로또출력 \n 4.종료 \n 입력 >> ");
        int menu = scanner.nextInt();
        return menu;
    }

    static int[][] createLottosAuto() {
        int[][] autoLottos = new int[3][6];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 6; j++)
                autoLottos[i][j] = (int)(Math.random()*45) + 1;
        return autoLottos;
    }

    static int[][] createLottosManual() {
        Scanner scanner = new Scanner(System.in);
        int[][] manualLottos = new int[3][6];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 6; j++)
                manualLottos[i][j] = scanner.nextInt();
        return manualLottos;
    }

    static void printLottos(int[][] lottos) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++)
                System.out.print(lottos[i][j] + " ");
            System.out.println();
        }

    }

}
