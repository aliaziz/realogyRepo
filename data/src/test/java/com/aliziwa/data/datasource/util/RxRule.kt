package com.aliziwa.data.datasource.util

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class RxRule : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                RxAndroidPlugins.setInitMainThreadSchedulerHandler { TrampolineScheduler.instance() }
                RxJavaPlugins.setComputationSchedulerHandler { TrampolineScheduler.instance() }
                RxJavaPlugins.setIoSchedulerHandler { TrampolineScheduler.instance() }

                try {
                    base.evaluate()
                } finally {
                    RxAndroidPlugins.reset()
                    RxJavaPlugins.reset()
                }
            }
        }
    }

}
