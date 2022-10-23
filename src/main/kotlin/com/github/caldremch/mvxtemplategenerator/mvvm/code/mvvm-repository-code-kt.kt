package com.github.caldremch.mvxtemplategenerator.template.code

/**
 * Created by Leon on 2022/10/23
 */

fun mvvmRepositoryKt(
    packageName:String,
    clazz:String
)="""
package ${packageName}.repository

class ${clazz}Repository(){

}
"""