package com.github.caldremch.mvxtemplategenerator.recipe



import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.github.caldremch.mvxtemplategenerator.template.code.mvvmActivityKt
import com.github.caldremch.mvxtemplategenerator.template.code.mvvmRepositoryKt
import com.github.caldremch.mvxtemplategenerator.template.code.mvvmViewModelKt
import com.github.caldremch.mvxtemplategenerator.template.code.mvvmXml

/**
 * Created by Leon on 2022/10/23
 */
fun RecipeExecutor.mvvmActivityRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    layoutName: String,
    packageName: String,
    language: Language
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = language.extension//projectData.language.extension
    generateManifest(
        moduleData = moduleData,
        activityClass = "${activityClass}Activity",
//            activityTitle = activityClass,
        packageName = "${packageName}.ui",
        isLauncher = false,
        hasNoActionBar = false,
        generateActivityTitle = true,
//            requireTheme = false,
//            useMaterial2 = false
    )

    if (language == Language.Kotlin){
        //applicationPackage
        val mvvmActivity = mvvmActivityKt(projectData.applicationPackage, activityClass, layoutName, packageName)
        // 保存Activity
        save(mvvmActivity, srcOut.resolve("ui/${activityClass}Activity.${ktOrJavaExt}"))
        // 保存xml
        save(mvvmXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
        // 保存viewmodel
        save(mvvmViewModelKt(packageName, activityClass), srcOut.resolve("viewmodel/${activityClass}ViewModel.${ktOrJavaExt}"))
        // 保存repository
        save(mvvmRepositoryKt(packageName, activityClass), srcOut.resolve("repository/${activityClass}Repository.${ktOrJavaExt}"))
    }else if (language == Language.Java){
//        //applicationPackage
//        val mvvmActivity = mvvmActivityJava(projectData.applicationPackage, activityClass, layoutName, packageName)
//        // 保存Activity
//        save(mvvmActivity, srcOut.resolve("ui/${activityClass}Activity.${ktOrJavaExt}"))
//        // 保存xml
//        save(mvvmXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
//        // 保存viewmodel
//        save(mvvmViewModelJava(packageName, activityClass), srcOut.resolve("viewmodel/${activityClass}ViewModel.${ktOrJavaExt}"))
//        // 保存repository
//        save(mvvmRepositoryJava(packageName, activityClass), srcOut.resolve("repository/${activityClass}Repository.${ktOrJavaExt}"))
//        //保存model
////    save(mvvmModel(packageName, activityClass), srcOut.resolve("model/${activityClass}Model.${ktOrJavaExt}"))
    }

}