package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.GameObject;

public class ClassLoaderTest {
   private static String name;
    private static String Url;
    public static void setName(String name) {
        ClassLoaderTest.name = name;
    }

    public static void setUrl(String url) {
        Url = url;
    }

    public static Class loadclass() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {

        ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
        MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
        Class myObjectClass = classLoader.loadClass(name,Url);

           GameObject object1 =
                (GameObject) myObjectClass.newInstance();



        //create new class loader so classes can be reloaded.
        classLoader = new MyClassLoader(parentClassLoader);
        myObjectClass = classLoader.loadClass(name);
        return myObjectClass;
    }
}
