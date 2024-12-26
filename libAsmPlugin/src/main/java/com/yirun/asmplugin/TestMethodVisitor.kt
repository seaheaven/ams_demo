package com.yirun.asmplugin

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.commons.AdviceAdapter
import org.objectweb.asm.Type

class TestMethodVisitor(
    api: Int,
    methodVisitor: MethodVisitor,
    access: Int,
    name: String,
    descriptor: String,
    private val className: String,
): AdviceAdapter(api, methodVisitor, access, name, descriptor) {
    private val slotIndex = newLocal(Type.LONG_TYPE)
    override fun onMethodEnter() {
        println("onMethodEnter")
        super.onMethodEnter()
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false)
        mv.visitVarInsn(LSTORE, slotIndex)
//        mv.visitLdcInsn("Test.class")
////        mv.visitLdcInsn("${className}.${name}aaa start")
//        mv.visitLdcInsn("${name} aaa start")
//        mv.visitMethodInsn(
//            INVOKESTATIC, "android/util/Log", "d",
//            "(Ljava/lang/String;Ljava/lang/String;)I", false
//        )
//        mv.visitInsn(POP)
    }

    override fun onMethodExit(opcode: Int) {
        mv.visitLdcInsn("MethodTime")
        mv.visitTypeInsn(NEW, "java/lang/StringBuilder")
        mv.visitInsn(DUP)
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false)
        mv.visitLdcInsn("${className}.${name} time cost:")
//        mv.visitLdcInsn("${name} time cost:")
        mv.visitMethodInsn(
            INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false)
        mv.visitVarInsn(LLOAD, slotIndex)
        mv.visitInsn(LSUB)
        mv.visitMethodInsn(
            INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(J)Ljava/lang/StringBuilder;",
            false
        )
        mv.visitMethodInsn(
            INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "toString",
            "()Ljava/lang/String;",
            false
        )
        mv.visitMethodInsn(
            INVOKESTATIC,
            "android/util/Log",
            "d",
            "(Ljava/lang/String;Ljava/lang/String;)I",
            false
        )
        mv.visitInsn(POP)
//        mv.visitLdcInsn("Test.class")
//        mv.visitLdcInsn("${name} aaa end")
//        mv.visitMethodInsn(
//            INVOKESTATIC, "android/util/Log", "d",
//            "(Ljava/lang/String;Ljava/lang/String;)I", false
//        )
//        mv.visitInsn(POP)
        super.onMethodExit(opcode)
    }
}