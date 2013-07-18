package com.fanaifan.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class BufferedRequestWrapper extends HttpServletRequestWrapper {

    ByteArrayInputStream bais;

    BufferedServletInputStream bsis;

    byte[] buffer;

    public BufferedRequestWrapper(HttpServletRequest req,int length) throws IOException {
        super(req);
        // Read InputStream and store its content in a buffer.
        InputStream is = req.getInputStream();
        buffer = new byte[length];

        int pad = 0;
        while(pad < length){
            pad += is.read(buffer, pad, length);
        }
    }

    public ServletInputStream getInputStream() {
        try {
            // Generate a new InputStream by stored buffer
            bais = new ByteArrayInputStream(buffer);
            // Istantiate a subclass of ServletInputStream
            // (Only ServletInputStream or subclasses of it are accepted by the
            // servlet engine!)
            bsis = new BufferedServletInputStream(bais);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return bsis;
    }

}