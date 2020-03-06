package com.adoph.test.annotation;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;

/**
 * todo: 描述
 *
 * @author tangqiandong
 * @version v1.0
 * @date 2020/3/4
 */
public class NameChecker {

    private final Messager messager;

    NameCheckScanner nameCheckScanner = new NameCheckScanner();

    public void checkNames(Element element) {
        nameCheckScanner.scan(element);
    }

    NameChecker(ProcessingEnvironment processingEnvironment) {
        this.messager = processingEnvironment.getMessager();
    }

    private class NameCheckScanner extends ElementScanner8<Void, Void> {
        @Override
        public Void visitVariable(VariableElement e, Void aVoid) {
            messager.printMessage(Diagnostic.Kind.WARNING, "变量名不能大写");
            return super.visitVariable(e, aVoid);
        }
    }
}
