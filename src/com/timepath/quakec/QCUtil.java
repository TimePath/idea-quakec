package com.timepath.quakec;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.timepath.quakec.psi.QCFile;
import com.timepath.quakec.psi.QCIdentifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author TimePath
 */
public class QCUtil {
    public static List<QCIdentifier> findIdentifiers(Project project, String key) {
        List<QCIdentifier> result = null;
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance()
                .getContainingFiles(FileTypeIndex.NAME, QCFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            QCFile QCFile = (QCFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (QCFile != null) {
                QCIdentifier[] idents = PsiTreeUtil.getChildrenOfType(QCFile, QCIdentifier.class);
                if (idents != null) {
                    for (QCIdentifier id : idents) {
                        if (key == null || key.equals(id.getText())) {
                            if (result == null) {
                                result = new ArrayList<QCIdentifier>();
                            }
                            result.add(id);
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.<QCIdentifier>emptyList();
    }
}
