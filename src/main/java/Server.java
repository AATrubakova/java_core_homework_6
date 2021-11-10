import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 1338;

    public static void main(String[] args) {
        Socket socket = null;
        try {
            ServerSocket serverSocket = new ServerSocket(Server.PORT);
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            String request = bufferedReader.readLine();
            if (request.equals("Собаки")) {
                printWriter.println("Картинки собак отправятся клиенту");
            }
            else if (request.equals("Кошки")) {
                printWriter.println("Картинки кошек отправятся клиенту");
            }
            bufferedReader.close();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
