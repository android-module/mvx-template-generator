package com.github.caldremch.mvxtemplategenerator.listeners

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import com.github.caldremch.mvxtemplategenerator.services.MyProjectService
import com.intellij.ide.plugins.DynamicPluginListener

internal class MyProjectManagerListener : ProjectManagerListener {

    override fun projectOpened(project: Project) {
        project.service<MyProjectService>()
    }
}
