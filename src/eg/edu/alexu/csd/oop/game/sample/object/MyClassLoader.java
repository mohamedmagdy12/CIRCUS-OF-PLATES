package eg.edu.alexu.csd.oop.game.sample.object;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyClassLoader extends ClassLoader{

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public Class loadClass(String name,String Url) throws ClassNotFoundException {
        /*if(!name.equals(name))
            return super.loadClass(name);*/

        try {
            String url = Url;
            URL myUrl = null;
            try {
                myUrl = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            URLConnection connection = null;
            try {
                connection = myUrl.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            InputStream input = connection.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = input.read();

            while(data != -1){
                buffer.write(data);
                data = input.read();
            }

            input.close();

            byte[] classData = buffer.toByteArray();

            return defineClass(name,
                    classData, 0, classData.length);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}