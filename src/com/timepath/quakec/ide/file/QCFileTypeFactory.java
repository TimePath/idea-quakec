package com.timepath.quakec.ide.file;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @author TimePath
 */
public class QCFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(QCFileType.INSTANCE, "qc");
        fileTypeConsumer.consume(QCFileType.INSTANCE, "qh");
        fileTypeConsumer.consume(QCFileType.INSTANCE, "c");
        fileTypeConsumer.consume(QCFileType.INSTANCE, "h");
    }
}
