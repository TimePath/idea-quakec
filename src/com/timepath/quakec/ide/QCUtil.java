package com.timepath.quakec.ide;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.timepath.quakec.ide.file.QCFileType;
import com.timepath.quakec.psi.QCFile;
import com.timepath.quakec.psi.QCNamedElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author TimePath
 */
public class QCUtil {

    public static <T extends QCNamedElement> List<QCNamedElement> find(Project project, String key, Class<T> clazz) {
        List<QCNamedElement> result = null;
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, QCFileType.INSTANCE,
                GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            QCFile QCFile = (QCFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (QCFile != null) {
                T[] properties = PsiTreeUtil.getChildrenOfType(QCFile, clazz);
                if (properties != null) {
                    for (T property : properties) {
                        if (key == null || key.equals(property.getName())) {
                            if (result == null) {
                                result = new ArrayList<QCNamedElement>();
                            }
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.<QCNamedElement>emptyList();
    }
}
