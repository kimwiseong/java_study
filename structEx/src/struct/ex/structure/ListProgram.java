package struct.ex.structure;

import java.util.Scanner;

public class ListProgram {
    public static void main(String[] args) {
        boolean flag = true;

        ExamList list = new ExamList();
        list.exams = new Exam[3];
        list.current = 0;

        while(flag) {
            switch (inputMenu()) {
                case 1:
                    input(list);
                    break;
                case 2:
                    print(list);
                    break;
                case 3:
                    //ex) n = 2
                    print(list, 2);
                    break;
                case 4:
                    //ex) n1 = 1, n2 = 2
                    print(list, 1,2);
                    break;
                case 5:

                    flag = false;
                    break;

                default:break;
            }
        }

    }


    static int inputMenu() {
        System.out.println();
        System.out.println("----------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print(" 1. 성적입력\n 2. 성적출력\n 3. 0~n출력\n 4. s부터 n개 출력\n 출력 5. 종료메뉴\n 입력 >> ");
        int menu = scanner.nextInt();

        System.out.println();
        return menu;
    }

    private static void input(ExamList list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------- 성적 입력 -------");

        Exam exam = new Exam();

        int kor = scanner.nextInt();
        int eng = scanner.nextInt();
        int math = scanner.nextInt();

        exam.kor = kor;
        exam.eng = eng;
        exam.math = math;

        Exam[] exams = list.exams;
        int size = list.current;

        if(exams.length == size) {
            Exam[] temp = new Exam[size+ 5];
            for (int i = 0; i < size; i++)
                temp[i] = exams[i];

            list.exams = temp;

        }
        list.exams[list.current++] = exam;
    }

    private static void print(ExamList list)  {
        print(list, list.current);
    }

    private static void print(ExamList list, int length) {
        print(list, 0, length);
    }

    private static void print(ExamList list, int offset, int length) {
        System.out.println("------- 성적 출력 -------");

        Exam[] exams = list.exams;
        int korTotal = 0, engTotal = 0, mathTotal = 0;
        for (int i = offset; i < length+offset; i++) {
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