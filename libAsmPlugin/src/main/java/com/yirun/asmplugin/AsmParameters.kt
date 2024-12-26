package com.yirun.asmplugin

import com.android.build.api.instrumentation.InstrumentationParameters
import org.gradle.api.provider.ListProperty
import org.gradle.api.tasks.Internal

interface AsmParameters: InstrumentationParameters {

    @get: Internal
    val specificClass: ListProperty<String>
}