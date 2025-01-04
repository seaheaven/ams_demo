package com.yirun.asmplugin

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.commons.AdviceAdapter
import org.objectweb.asm.Type

/**
 * 2025-01-04 19:17:39.340 31867-31867 MethodLog               com.yirun.amsplugindemo              D  com/yirun/libtest/Test.<clinit> hello!
 * 2025-01-04 19:17:39.340 31867-31867 MethodLog               com.yirun.amsplugindemo              D  com/yirun/libtest/Test.<init> hello!
 * 2025-01-04 19:17:39.340 31867-31867 MethodLog               com.yirun.amsplugindemo              D  com/yirun/libtest/Test.<init> bye bye!
 * 2025-01-04 19:17:39.340 31867-31867 MethodLog               com.yirun.amsplugindemo              D  com/yirun/libtest/Test.<clinit> bye bye!
 * 2025-01-04 19:17:39.340 31867-31867 MethodLog               com.yirun.amsplugindemo              D  com/yirun/libtest/Test.test hello!
 * 2025-01-04 19:17:39.834 31867-31867 MethodLog               com.yirun.amsplugindemo              D  com/yirun/libtest/Test.test bye bye!
 */
class LogMethodVisitor(
    api: Int,
    mv: MethodVisitor,
    access: Int,
    name: String,
    descriptor: String,
    private val className: String,
): AdviceAdapter(api, mv, access, name, descriptor) {
    private val slotIndex = newLocal(Type.LONG_TYPE)
    override fun onMethodEnter() {
        println("onMethodEnter")
        super.onMethodEnter()
        mv.visitLdcInsn("MethodLog")
        mv.visitLdcInsn("${className}.${name} hello!")
        mv.visitMethodInsn(INVOKESTATIC, "android/util/Log", "d", "(Ljava/lang/String;Ljava/lang/String;)I", false)
        mv.visitInsn(POP)
    }

    override fun onMethodExit(opcode: Int) {
        mv.visitLdcInsn("MethodLog")
        mv.visitLdcInsn("${className}.${name} bye bye!")
        mv.visitMethodInsn(INVOKESTATIC, "android/util/Log", "d", "(Ljava/lang/String;Ljava/lang/String;)I", false)
        mv.visitInsn(POP)
        super.onMethodExit(opcode)
    }
}