package com.mayzhou.compiler;

import javax.tools.SimpleJavaFileObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * @author MayZhou
 */
public class ByteArrayJavaClass extends SimpleJavaFileObject {

    private ByteArrayOutputStream stream;

    public ByteArrayJavaClass(String name) {
        super(URI.create("bytes:///" + name),Kind.CLASS);
        stream = new ByteArrayOutputStream();
    }

    public OutputStream openOutStream() throws IOException{
        return stream;
    }

    public byte[] getBytes(){
        return stream.toByteArray();
    }
}
