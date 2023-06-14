package servlet;

import java.io.*;
import java.net.Socket;

public class MyServlet implements Servlet {
    @Override
    public void doGet(Request req, Response res) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(res.getOutputStream()));

        String readLine = reader.readLine();
        System.out.println(readLine);
        String method = readLine.split(" ")[0];
        String result = readLine.split(" ")[1];
        System.out.println(result);
        if (result.equals("/res")) {
            writer.write("HTTP/1.1 302");
            writer.newLine();
            writer.write("Location: /abc");
            writer.newLine();
            writer.newLine();
            writer.write("<html><body>302 Found</body></html>");
            writer.flush();
        } else {
            writer.write("HTTP/1.1 200");
            writer.newLine();
            writer.newLine();
            writer.write("<html><body>Hello Hello</body></html>");
            writer.flush();
        }
    }
    @Override
    public void doPost(Request req, Response res) throws IOException {

    }

}
