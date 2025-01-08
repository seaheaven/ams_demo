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

    override fun visitCode() {
        println("${className}.${name} visitCode")
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
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false)
        mv.visitVarInsn(LSTORE, slotIndex)
    }

    override fun onMethodExit(opcode: Int) {
        println("${className}.${name} onMethodExit opcode:$opcode")
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false)
        mv.visitVarInsn(LLOAD, slotIndex)
        mv.visitInsn(LSUB)
        mv.visitVarInsn(LSTORE, slotIndex)

        mv.visitVarInsn(LLOAD, slotIndex)
        mv.visitLdcInsn(500L)
        mv.visitInsn(LCMP)

        val label3 = Label()
        mv.visitJumpInsn(IFLT, label3)

        mv.visitLdcInsn("MethodTime")
        mv.visitTypeInsn(NEW, "java/lang/StringBuilder")
        mv.visitInsn(DUP)
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false)
        mv.visitLdcInsn("${className}.${name} cost time:")
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false)
        mv.visitVarInsn(LLOAD, slotIndex)
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false)
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false)
        mv.visitMethodInsn(INVOKESTATIC, "android/util/Log", "e", "(Ljava/lang/String;Ljava/lang/String;)I", false)
        mv.visitInsn(POP)

        val label5 = Label()
        mv.visitJumpInsn(GOTO, label5)
        mv.visitLabel(label3)

        mv.visitVarInsn(LLOAD, slotIndex)
        mv.visitLdcInsn(200L)
        mv.visitInsn(LCMP)

        val label6 = Label()
        mv.visitJumpInsn(IFLT, label6)

        mv.visitLdcInsn("MethodTime")
        mv.visitTypeInsn(NEW, "java/lang/StringBuilder")
        mv.visitInsn(DUP)
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false)
        mv.visitLdcInsn("${className}.${name} cost time:")
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false)
        mv.visitVarInsn(LLOAD, slotIndex)
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false)
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false)
        mv.visitMethodInsn(INVOKESTATIC, "android/util/Log", "w", "(Ljava/lang/String;Ljava/lang/String;)I", false)
        mv.visitInsn(POP)

        mv.visitJumpInsn(GOTO, label5)
        mv.visitLabel(label6)

        mv.visitVarInsn(LLOAD, slotIndex)
        mv.visitLdcInsn(100L)
        mv.visitInsn(LCMP)

        val label8 = Label()
        mv.visitJumpInsn(IFLT, label8)

        mv.visitLdcInsn("MethodTime")
        mv.visitTypeInsn(NEW, "java/lang/StringBuilder")
        mv.visitInsn(DUP)
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false)
        mv.visitLdcInsn("${className}.${name} cost time:")
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false)
        mv.visitVarInsn(LLOAD, slotIndex)
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false)
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false)
        mv.visitMethodInsn(INVOKESTATIC, "android/util/Log", "i", "(Ljava/lang/String;Ljava/lang/String;)I", false)
        mv.visitInsn(POP)

        mv.visitJumpInsn(GOTO, label5)
        mv.visitLabel(label8)

        mv.visitVarInsn(LLOAD, slotIndex)
        mv.visitLdcInsn(10L)
        mv.visitInsn(LCMP)

        val label10 = Label()
        mv.visitJumpInsn(IFLT, label10)

        mv.visitLdcInsn("MethodTime")
        mv.visitTypeInsn(NEW, "java/lang/StringBuilder")
        mv.visitInsn(DUP)
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false)
        mv.visitLdcInsn("${className}.${name} cost time:")
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false)
        mv.visitVarInsn(LLOAD, slotIndex)
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false)
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false)
        mv.visitMethodInsn(INVOKESTATIC, "android/util/Log", "d", "(Ljava/lang/String;Ljava/lang/String;)I", false)
        mv.visitInsn(POP)

        mv.visitJumpInsn(GOTO, label5)
        mv.visitLabel(label10)

        mv.visitVarInsn(LLOAD, slotIndex)
        mv.visitInsn(LCONST_1)
        mv.visitInsn(LCMP)

        mv.visitJumpInsn(IFLT, label5)

        mv.visitLdcInsn("MethodTime")
        mv.visitTypeInsn(NEW, "java/lang/StringBuilder")
        mv.visitInsn(DUP)
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false)
        mv.visitLdcInsn("${className}.${name} cost time:")
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false)
        mv.visitVarInsn(LLOAD, slotIndex)
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false)
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false)
        mv.visitMethodInsn(INVOKESTATIC, "android/util/Log", "v", "(Ljava/lang/String;Ljava/lang/String;)I", false)
        mv.visitInsn(POP)
        mv.visitLabel(label5)

        super.onMethodExit(opcode)
    }
}