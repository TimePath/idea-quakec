package com.timepath.quakec.ide.file

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory

public class QCFileTypeFactory : FileTypeFactory() {
    override fun createFileTypes(consumer: FileTypeConsumer) {
        consumer.consume(QCFileType, "qc")
        consumer.consume(QCFileType, "qh")
    }
}
