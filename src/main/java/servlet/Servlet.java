package servlet;

import java.io.IOException;

public interface Servlet {
    void doGet(Request req,Response res) throws IOException;
    void doPost(Request req,Response res)throws IOException;

}
