import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private static final String host = "localhost";
    private static final int port = 8889;
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
        {
            String response = in.readLine();
            System.out.println(response);

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            out.println(name);

            response = in.readLine();
            System.out.println(response);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
