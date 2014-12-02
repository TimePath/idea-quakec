package com.timepath.quakec.ide;

import com.intellij.lang.Language;

/**
 * @author TimePath
 */
public class QCLanguage extends Language {
    public static final QCLanguage INSTANCE = new QCLanguage();

    private QCLanguage() {
        super("QuakeC");
    }
}
