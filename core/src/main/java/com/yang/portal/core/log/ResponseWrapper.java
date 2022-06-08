package com.yang.portal.core.log;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class ResponseWrapper extends HttpServletResponseWrapper {

    private ByteArrayOutputStream byteArrayOutputStream;
    private ServletOutputStream servletOutputStream;

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
        byteArrayOutputStream = new ByteArrayOutputStream();
        servletOutputStream = new ServletOutputStreamWrapper(byteArrayOutputStream);
    }

    @Override
    public ServletOutputStream getOutputStream() {
        return servletOutputStream;
    }

    @Override
    public PrintWriter getWriter() {
        return new PrintWriter(new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8));
    }

    @Override
    public void flushBuffer() {
        if (servletOutputStream != null) {
            try {
                servletOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public byte[] getContent() {
        flushBuffer();
        // response中的数据
        return byteArrayOutputStream.toByteArray();
    }

    public String getContentAsString() {
        return new String(getContent(), StandardCharsets.UTF_8);
    }

    public static class ServletOutputStreamWrapper extends ServletOutputStream {
        // 把response输出流中的数据写入字节流中
        private ByteArrayOutputStream byteArrayOutputStream;

        public ServletOutputStreamWrapper(ByteArrayOutputStream byteArrayOutputStream) {
            this.byteArrayOutputStream = byteArrayOutputStream;
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setWriteListener(WriteListener listener) {
        }

        @Override
        public void write(int b) {
            byteArrayOutputStream.write(b);
        }
    }
}
