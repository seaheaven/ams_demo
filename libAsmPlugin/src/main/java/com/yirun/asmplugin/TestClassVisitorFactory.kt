package com.yirun.asmplugin

import com.android.build.api.instrumentation.AsmClassVisitorFactory
import com.android.build.api.instrumentation.ClassContext
import com.android.build.api.instrumentation.ClassData
import org.objectweb.asm.ClassVisitor

abstract class TestClassVisitorFactory: AsmClassVisitorFactory<AsmParameters> {

    override fun createClassVisitor(
        classContext: ClassContext,
        nextClassVisitor: ClassVisitor
    ): ClassVisitor {
        return TestClassVisitor(nextClassVisitor)
    }

    override fun isInstrumentable(classData: ClassData): Boolean {
        val className = classData.className
        if(className.startsWith("android")
            || className.startsWith("org")
            || className.startsWith("kotlin")
            || className.startsWith("_COROUTINE")
            || className.startsWith("com.google")
            || className.endsWith(".R")
            || className.contains("$")
            ){
            return false
        }
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