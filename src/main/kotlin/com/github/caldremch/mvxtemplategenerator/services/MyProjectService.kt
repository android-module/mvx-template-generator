package com.github.caldremch.mvxtemplategenerator.services

import com.intellij.openapi.project.Project
import com.github.caldremch.mvxtemplategenerator.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))

    }
}
