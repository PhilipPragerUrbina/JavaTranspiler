package Transpiler.io;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Represents java source classes
 */
public class SourceClass {
    private ClassReader reader; //Read jar file using ASM

    /**
     * Read a java source class file
     * @param class_file .class java bytecode
     * @throws IOException Problem reading file
     */
    public SourceClass(File class_file) throws IOException {
        //Validate
        if(!class_file.exists()){throw new IOException("Source file does not exist: " + class_file.getName());}
        if(!getExtension(class_file).equals("class")){
            throw new IOException("Source file is not java class file: " + class_file.getName());
        }

        InputStream stream = new FileInputStream(class_file); //Get byte input stream

        reader = new ClassReader(stream); //Create class reader

    }

    /**
     * Parse the class using a class visitor
     * @param visitor Processes class information
     */
    public void parse(ClassVisitor visitor){
        reader.accept(visitor,0); //Accept with no flags
    }


    /**
     * Get the file extension of a file
     * @return Extension without '.'
     */
    private static String getExtension(File file){
        int index = file.getName().lastIndexOf(".");
        if(index == -1){return "";}
        return file.getName().substring(index + 1);
    }
}
