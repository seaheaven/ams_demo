package com.yirun.asmplugin

import com.android.build.api.instrumentation.AsmClassVisitorFactory
import com.android.build.api.instrumentation.ClassContext
import com.android.build.api.instrumentation.ClassData
import org.objectweb.asm.ClassVisitor

abstract class TestClassVistorFactory: AsmClassVisitorFactory<AsmParameters> {

    override fun createClassVisitor(
        classContext: ClassContext,
        nextClassVisitor: ClassVisitor
    ): ClassVisitor {
        return TestClassVisitor(nextClassVisitor)
    }

    override fun isInstrumentable(classData: ClassData): Boolean {
        println("isInstrumentable classData ${classData.className}")
        parameters.get().specificClass.get().forEach {
            if (classData.className.contains(it)) {
                println("isInstrumentable classData true")
                return true
            }
        }
        return false
    }
}