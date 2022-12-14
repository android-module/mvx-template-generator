package com.github.caldremch.mvxtemplategenerator.mvvm.template

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.github.caldremch.mvxtemplategenerator.recipe.mvvmActivityRecipe

/**
 * Created by Leon on 2022/10/23
 */

val mvvmActivityTemplate get() = template {
//    revision = 1
    name = "android-common mvvm"
    description = "适用于https://github.com/android-module/android-common"
    minApi = MIN_API
    category = Category.Activity
    formFactor = FormFactor.Mobile
    screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

    val activityClass = stringParameter {
        name = "Activity Name"
        default = "Main"
        help = "只输入名字，不要包含Activity"
        constraints = listOf(Constraint.NONEMPTY)
    }

    val layoutName = stringParameter {
        name = "Layout Name"
        default = "activity_main"
        help = "请输入布局的名字"
        constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
        suggest = { activityToLayout(createLayoutName(activityClass.value)) }
    }

    val packageName = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.android.app"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }

    val language= enumParameter<Language> {
        name = "Source Language"
        help = "请选择语言"
        default = Language.Kotlin
    }

    widgets(
        TextFieldWidget(activityClass),
        TextFieldWidget(layoutName),
        PackageNameWidget(packageName),
        EnumWidget(language),
    )
//        thumb { File("logo.png") }
    recipe = { data: TemplateData ->
        mvvmActivityRecipe(
            data as ModuleTemplateData,
            activityClass.value,
            layoutName.value,
            packageName.value,
            language.value,
        )
    }
}

fun createLayoutName(className:String):String{
    val array=className.toCharArray()
    val string= StringBuilder()
    array.forEach {
        if (it.isUpperCase()){
            //第一个首字母大写的话 不加下划线
            if (string.isNotEmpty()){
                string.append("_")
            }
            string.append(it.toLowerCase())
        }else {
            string.append(it)
        }
    }
    return string.toString()
}
