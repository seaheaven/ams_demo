package com.yirun.asmplugin

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.commons.AdviceAdapter

class ReplaceMethodVisitor(
    api: Int,
    mv: MethodVisitor,
    access: Int,
    name: String,
    descriptor: String,
    private val className: String,
): AdviceAdapter(api, mv, access, name, descriptor) {
    private val mMethodOwner = "android/telephony/TelephonyManager"
    private val mMethodName = "getDeviceId"
    private val mMethodDesc = "()Ljava/lang/String;"
    private val mMethodDesc1 = "(I)Ljava/lang/String;"

    private val mNewOpcode = INVOKESTATIC
    private val mNewMethodOwner = "com/yirun/util/ReplaceTelephonyManagerUtil"
    private val mNewMethodName = "getDeviceId"
    private val mNewMethodDesc = "(Landroid/telephony/TelephonyManager;)Ljava/lang/String;"
    private val mNewMethodDesc1 = "(Landroid/telephony/TelephonyManager;I)Ljava/lang/String;"
    override fun visitMethodInsn(
        opcodeAndSource: Int,
        owner: String?,
        name: String?,
        descriptor: String?,
        isInterface: Boolean
    ) {
        println("visitMethodInsn  className:$className name:$name owner:$owner,name:$name,desc:$descriptor")
        if(owner == mMethodOwner && name == mMethodName){
            if(descriptor == mMethodDesc){
                super.visitMethodInsn(mNewOpcode, mNewMethodOwner, mNewMethodName, mNewMethodDesc, false)
            }else if(descriptor == mMethodDesc1){
                super.visitMethodInsn(mNewOpcode, mNewMethodOwner, mNewMethodName, mNewMethodDesc1, false)
            }else {
                super.visitMethodInsn(opcodeAndSource, owner, name, descriptor, isInterface)
            }
        }else {
            super.visitMethodInsn(opcodeAndSource, owner, name, descriptor, isInterface)
        }
    }

    override fun onMethodEnter() {
        println("onMethodEnter className:$className name:$name")
        super.onMethodEnter()
    }
}