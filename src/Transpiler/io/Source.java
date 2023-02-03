package Transpiler.io;

import org.objectweb.asm.ClassVisitor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * A collection of classes that make up a program
 */
public class Source {
    private ArrayList<SourceClass> classes;

    /**
     * Create empty source
     */
    public Source(){
        classes = new ArrayList<>();
    }

    /**
     * Add a .class file to the source
     * @param path Path to class file
     * @exception IOException Problem reading class
     */
    void addClass(String path) throws IOException {
        classes.add(new SourceClass(new File(path)));
    }

    /**
     * Add a class to the source
     */
    void addClass(SourceClass source_class){
        classes.add(source_class);
    }

    /**
     * Apply an operation on each of the source classes
     * @param method Operation to run
     */
    void forEach(Consumer<SourceClass> method){
        for (SourceClass source_class: classes) {
            method.accept(source_class);
        }
    }

    /**
     * Visit all the classes in the source with a visitor
     */
    void visitClasses(ClassVisitor visitor){
        for (SourceClass source_class: classes) {
            source_class.parse(visitor);
        }
    }
}
