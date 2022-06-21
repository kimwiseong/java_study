package struct.ex.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamProgram {

    public static void main(String[] args) {

        Exam[] exams = new Exam[3];
        boolean flag = true;
        int current = 0;

        while(flag) {
            switch (inputMenu()) {
                case 1:
                    inputList(exams, current);
                    break;
                case 2:
                    printList(exams);
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

    private static void inputList(Exam[] exams, int current)  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------- 성적 입력 -------");

        List<Exam> exam = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            exams[i] = new Exam();
            exams[i].kor = scanner.nextInt();
            exams[i].eng = scanner.nextInt();
            exams[i].math = scanner.nextInt();
        }
    }

    private static void printList(Exam[] exams)  {
        System.out.println("------- 성적 출력 -------");


        int korTotal = 0, engTotal = 0, mathTotal = 0;
        for (int i = 0; i < 3; i++) {
            korTotal += exams[i].kor;
            System.out.printf("국어 :%3d", exams[i].kor);
            engTotal += exams[i].eng;
            System.out.printf("\t영어 :%3d", exams[i].eng);
            mathTotal += exams[i].math;
            System.out.printf("\t수학 :%3d", exams[i].math);
            System.out.println();
        }

        double korAvg = korTotal/3.0f;
        double engAvg = engTotal/3.0f;
        double mathAvg = mathTotal/3.0f;


        System.out.println();
        System.out.printf("국어총점 :%2d, 영어총점 :%2d, 수학총점 :%2d\n", korTotal, engTotal, mathTotal);
        System.out.printf("국어평균 : %3.1f, 영어평균 : %3.1f, 수학평균 : %3.1f\n", korAvg, engAvg, mathAvg);
    }

}

