package Transpiler;

import Transpiler.java.SourceClassVisitor;
import org.objectweb.asm.ClassVisitor;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ClassVisitor visitor = new SourceClassVisitor(2);

    }
}
