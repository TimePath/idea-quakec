package com.timepath.quakec.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.timepath.quakec.ide.file.QCFileType;

/**
 * @author TimePath
 */
public class QCElementFactory {
    public static QCFile createFile(Project project, String text) {
        String name = "dummy.qc";
        return (QCFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, QCFileType.INSTANCE, text);
    }

    public static <T> T create(Project project, String newName) {
        return (T) createFile(project, newName).getFirstChild();
    }

    public static PsiElement createIdentifier(PsiElement element, String newName) {
        QCVariableDeclaration variable = create(element.getProject(), "void " + newName + ";");
        return variable.getVariableList().get(0).getNameIdentifier();
    }
}
