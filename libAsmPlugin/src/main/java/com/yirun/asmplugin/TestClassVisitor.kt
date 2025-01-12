package com.yirun.asmplugin

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Opcodes.ACC_PUBLIC
import org.objectweb.asm.Opcodes.ACC_STATIC
import org.objectweb.asm.Opcodes.ARETURN

class TestClassVisitor(classVisitor: ClassVisitor): ClassVisitor(Opcodes.ASM7, classVisitor) {
    private var className: String? = null
    private val mAccess = ACC_PUBLIC + ACC_STATIC
    private val mMethodName = "getDeviceId"
    private val mMethodDesc = "(Landroid/content/Context;)Ljava/lang/String;"
    override fun visit(
        version: Int,
        access: Int,
        name: String?,
        signature: String?,
        superName: String?,
        interfaces: Array<out String>?
    ) {
        super.visit(version, access, name, signature, superName, interfaces)
        className = name
    }
    override fun visitMethod(
        access: Int,
        name: String?,
        descriptor: String?,
        signature: String?,
        exceptions: Array<out String>?
    ): MethodVisitor? {

        if(className == "com/otherlib/util/DeviceUtil"){
            //移除整个方法
            if(name == mMethodName && (descriptor == mMethodDesc)){
                println("---------移除 getDeviceId 方法------------")
                return null
            }
            val methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions)
            return ReplaceMethodVisitor(api, methodVisitor, access, name?:"", descriptor?:"", className?:"")
        }else {
            val methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions)
            return CostTimeMethodVisitor(api, methodVisitor, access, name?:"", descriptor?:"", className?:"")
        }
    }

    override fun visitEnd() {
        if(className == "com/otherlib/util/DeviceUtil"){
            val methodVisitor = cv.visitMethod(mAccess, mMethodName, mMethodDesc, null, null)
            methodVisitor.visitLdcInsn("")
            methodVisitor.visitInsn(ARETURN)
            methodVisitor.visitEnd()
        }
        super.visitEnd()
    }
}