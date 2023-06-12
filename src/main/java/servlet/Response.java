package servlet;

import java.io.OutputStream;

public class Response {
    OutputStream outputStream;

    public Response(OutputStream out) {
        this.outputStream = out;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
}
