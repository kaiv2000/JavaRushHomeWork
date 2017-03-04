package com.javarush.test.level35.lesson10.bonus01;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/* ClassLoader - что это такое?
Реализуйте логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals("C://pathToClasses/");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {

        Set<Animal> setAnimal = new HashSet<>();

        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/"))
            pathToAnimals = pathToAnimals + "/";
        File dir = new File(pathToAnimals);
        String[] classes = dir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });

        for (String m : classes) {
            try {
                final String finalPathToAnimals = pathToAnimals;
                ClassLoader loader = new ClassLoader() {
                    @Override
                    public Class<?> findClass(String className) throws ClassNotFoundException {
                        try {
                            byte b[] = findClassFromDisk(finalPathToAnimals + className + ".class");
                            return defineClass(null, b, 0, b.length);
                        }
                        catch (FileNotFoundException ex) {
                            return super.findClass(className);
                        }
                        catch (IOException ex) {
                            return super.findClass(className);
                        }
                    }
                };

                String mName = m.substring(0, m.length()-6);
                Class clazz = loader.loadClass(mName);
                boolean hasInterface = false;
                Class[] interfaces = clazz.getInterfaces();
                for(Class i : interfaces) {
                    if(Animal.class.equals(i)) {
                        hasInterface = true;
                        break;
                    }
                }

                if(! hasInterface ) continue;
                boolean hasConstructor = false;
                Constructor[] constructors = clazz.getConstructors();
                for (Constructor c : constructors) {
                    if( Modifier.isPublic(c.getModifiers()) && c.getParameterTypes().length==0 ) {
                        hasConstructor = true;
                        break;
                    }
                }

                if(!hasConstructor) continue;
                setAnimal.add((Animal) clazz.newInstance());
            }
            catch (Exception e) { }
        }
        return setAnimal;
    }

    private static byte[] findClassFromDisk(String path) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(new File(path));
        long length = new File(path).length();
        if (length > Integer.MAX_VALUE) {
        }
        byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + path);
        }
        is.close();
        return bytes;
    }

}
