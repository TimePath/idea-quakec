package com.timepath.quakec.ide.file

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory

/**
 * @author TimePath
 */
public class QCFileTypeFactory : FileTypeFactory() {
    override fun createFileTypes(fileTypeConsumer: FileTypeConsumer) {
        fileTypeConsumer.consume(QCFileType, "qc")
        fileTypeConsumer.consume(QCFileType, "qh")
    }
}
