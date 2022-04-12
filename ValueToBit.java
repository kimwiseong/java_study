
public class ValueToBit {

    public static void valueToBit(byte value) {
        for (int i = 1; i <= 8; i++) {
            System.out.print((value >> (8 - i)) & 1);
            if (i % 4 == 0)
                System.out.print(" ");
        }
        System.out.println();
    }

    public static void valueToBit(short value) {
        for (int i = 1; i <= 16; i++) {
            System.out.print((value >> (16 - i)) & 1);
            if (i % 4 == 0)
                System.out.print((i % 8 == 0 && i != 16) ? " / " : " ");
        }
        System.out.println();
    }

    public static void valueToBit(int value) {
        for (int i = 1; i <= 32; i++) {
            System.out.print((value >> (32 - i)) & 1);
            if (i % 4 == 0)
                System.out.print((i % 8 == 0 && i != 32) ? " / " : " ");
        }
        System.out.println();
    }

    public static void valueToBit(long value) {
        for (int i = 1; i <= 64; i++) {
            System.out.print((value >> (64 - i)) & 1);
            if (i % 4 == 0)
                System.out.print((i % 8 == 0 && i != 64) ? " / " : " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 맨 앞의 비트는 부호비트
        valueToBit((byte) 127);
        valueToBit((short) 32767);
        valueToBit((int) 2147483647);
        valueToBit((long) 2147483647);
    }
}