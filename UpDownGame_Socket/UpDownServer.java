import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UpDownServer {
    public static void main(String[] args) throws Exception {
        System.out.println("UpDownGame서버가 실행중입니다.");
        int clientId = 0;
        ServerSocket ss = new ServerSocket(9100);
        try {
            while (true) {
                clientId++;
                Game t = new Game(ss.accept(), clientId);
                t.start();
            }
        } finally {
            ss.close();
        }
    }

    // 다중 클라이언트를 지원하기 위해 Thread생성
    private static class Game extends Thread {
        private Socket socket;
        private int myId;
        private int target;

        public Game(Socket socket, int clientId) {
            this.socket = socket;
            this.myId = clientId;
            this.target = (int) (Math.random() * 50); // 0 ~ 50
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                out.println("클라이언트 번호는 " + myId + "입니다.");
                out.println("숫자를 입력하세요 (0 ~ 50)");
                // out.println(target);
                while (true) {
                    String ans = in.readLine();
                    if (Integer.parseInt(ans) > 50 || Integer.parseInt(ans) < 0) {
                        out.println("범위를 벗어났습니다. 다시 입력해주세요.");
                        continue;
                    }
                    if (Integer.parseInt(ans) == target) {
                        out.println("CORRECT!");
                        break;
                    } else if (Integer.parseInt(ans) < target)
                        out.println("UP.");
                    else if (Integer.parseInt(ans) > target)
                        out.println("DOWN.");
                }
            } catch (IOException e) {
                System.out.println("클라이언드 번호: " + myId + "처리 실패" + e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("소켓 종료 오류" + e);
                }
                System.out.println("클라이언트 번호: " + myId + "처리 처리 종료");
            }
        }
    }
}