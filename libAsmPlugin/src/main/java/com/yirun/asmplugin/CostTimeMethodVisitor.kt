package com.yirun.asmplugin

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Type
import org.objectweb.asm.commons.AdviceAdapter

/**
 * 2025-01-04 19:22:21.547 32425-32425 MethodTime              com.yirun.amsplugindemo              D  com/yirun/libtest/Test.<init> cost time:84
 * 2025-01-04 19:22:21.547 32425-32425 MethodTime              com.yirun.amsplugindemo              D  com/yirun/libtest/Test.<clinit> cost time:190167
 * 2025-01-04 19:22:22.040 32425-32425 MethodTime              com.yirun.amsplugindemo              D  com/yirun/libtest/Test.test cost time:493098125
 */
class CostTimeMethodVisitor(
    api: Int,
    mv: MethodVisitor,
    access: Int,
    name: String,
    descriptor: String,
    private val className: String,
): AdviceAdapter(api, mv, access, name, descriptor) {
    private val slotIndex = newLocal(Type.LONG_TYPE)
    private val slotIndex1 = newLocal(Type.getType(String::class.java))

    override fun visitCode() {
        println("${className}.${name} visitCode slotIndex:$slotIndex, slotIndex1:$slotIndex1")
        super.visitCode()
    }

    override fun visitEnd() {
        println("${className}.${name} visitEnd")
        super.visitEnd()
    }

    override fun visitJumpInsn(opcode: Int, label: Label?) {
        println("${className}.${name} visitJumpInsn opcode:$opcode,label:$label,")
        super.visitJumpInsn(opcode, label)

    }
    override fun onMethodEnter() {
        println("${className}.${name} onMethodEnter")
        super.onMethodEnter()
//        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false)
//        mv.visitVarInsn(LSTORE, slotIndex)

        mv.visitLdcInsn("${className}.${name}")
        mv.visitMethodInsn(INVOKESTATIC, "com/yirun/amsplugindemo/InjectImp", "s", "(Ljava/lang/String;)J", false)
        mv.visitVarInsn(LSTORE, slotIndex)
    }

    override fun onMethodExit(opcode: Int) {
        println("${className}.${name} onMethodExit opcode:$opcode")

//        mv.visitVarInsn(LLOAD, slotIndex)
//        mv.visitMethodInsn(INVOKESTATIC, "com/yirun/amsplugindemo/MethodCostTestJava", "log", "(J)V", false)

        mv.visitVarInsn(LLOAD, slotIndex)
        mv.visitLdcInsn("${className}.${name}")
        mv.visitMethodInsn(INVOKESTATIC, "com/yirun/amsplugindemo/InjectImp", "e", "(JLjava/lang/String;)V", false)
        super.onMethodExit(opcode)
    }
}