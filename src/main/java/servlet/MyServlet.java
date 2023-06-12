package servlet;

import java.io.*;

public class MyServlet implements Servlet{
    @Override
    public void doGet(Request req, Response res) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(req.getInputStream()));
        BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(res.getOutputStream()));

        String s = reader.readLine();
        System.out.println(s);

        writer.write("Hello "+s);
        writer.flush();
    }

    @Override
    public void doPost(Request req, Response res) throws IOException{

    }
}
