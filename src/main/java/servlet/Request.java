package servlet;

import java.io.InputStream;

public class Request {
    InputStream inputStream;

    public Request(InputStream in) {
        this.inputStream = in;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
