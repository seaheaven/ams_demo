package com.yirun.asmplugin.util

import org.objectweb.asm.Opcodes

object OpcodesUtil : Opcodes {
    const val ASM_VERSION: Int = Opcodes.ASM9
    fun isSynthetic(access: Int): Boolean {
        return (access and Opcodes.ACC_SYNTHETIC) != 0
    }

    fun isPrivate(access: Int): Boolean {
        return (access and Opcodes.ACC_PRIVATE) != 0
    }

    fun isPublic(access: Int): Boolean {
        return (access and Opcodes.ACC_PUBLIC) != 0
    }

    fun isStatic(access: Int): Boolean {
        return (access and Opcodes.ACC_STATIC) != 0
    }

    fun isNative(access: Int): Boolean {
        return (access and Opcodes.ACC_NATIVE) != 0
    }

    fun isAbstract(access: Int): Boolean {
        return (access and Opcodes.ACC_ABSTRACT) != 0
    }

    /**
     * 是否是接口
     */
    fun isInterface(access: Int): Boolean {
        return (access and Opcodes.ACC_INTERFACE) != 0
    }

    /**
     * 是否是枚举类型
     */
    fun isEnum(access: Int): Boolean {
        return (access and Opcodes.ACC_ENUM) != 0
    }

    fun isInitMethod(name: String): Boolean {
        return name === "<init>"
    }
}
