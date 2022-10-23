package com.github.caldremch.mvxtemplategenerator.template.code

/**
 * Created by Leon on 2022/10/23
 */

fun mvvmActivityKt(
    applicationPackage:String?,
    activityClass:String,
    layoutName:String,
    packageName:String
)="""
package ${packageName}.ui

import ${applicationPackage}.R
import ${applicationPackage}.databinding.Activity${activityClass}Binding
import ${applicationPackage}.mvvm.viewmodel.${activityClass}ViewModel

class ${activityClass}Activity : BaseActivity<Activity${activityClass}Binding,${activityClass}ViewModel>() {
     override val layoutId: Int
        get() = R.layout.${layoutName}
} 
"""
