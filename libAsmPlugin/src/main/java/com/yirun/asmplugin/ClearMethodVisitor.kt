package com.yirun.asmplugin

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.commons.AdviceAdapter

class ClearMethodVisitor(
    api: Int,
    mv: MethodVisitor,
    access: Int,
    private val name: String,
    private val descriptor: String,
    private val className: String,
): AdviceAdapter(api, mv, access, name, descriptor) {

    private val mMethodName = "getDeviceId"
    private val mMethodDesc = "(Landroid/content/Context;)Ljava/lang/String;"

    override fun visitCode() {
        println("---visitCode----mName:$name")
        super.visitCode()
        if(this.name == mMethodName && this.descriptor == mMethodDesc){
            visitInsn(ACONST_NULL)
            visitInsn(ARETURN)
            visitMaxs(0, 0)
        }
    }

}