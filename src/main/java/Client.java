import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String request = scanner.nextLine();
        Socket socket;

        try {
            socket = new Socket("localhost",Server.PORT);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            printWriter.println(request);
            System.out.println(bufferedReader.readLine());

            bufferedReader.close();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
