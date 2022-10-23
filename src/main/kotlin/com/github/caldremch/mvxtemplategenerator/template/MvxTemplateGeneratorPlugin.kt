/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.github.caldremch.mvxtemplategenerator.template

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.caldremch.mvxtemplategenerator.mvvm.template.mvvmActivityTemplate

/**
 * A simple 'hello world' plugin.
 */
class MvxTemplateGeneratorPlugin: WizardTemplateProvider() {
    override fun getTemplates(): List<Template> {
        return listOf(mvvmActivityTemplate)
    }

}