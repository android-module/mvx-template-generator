package com.github.caldremch.mvxtemplategenerator.template.code

/**
 * Created by Leon on 2022/10/23
 */

fun mvvmViewModelKt(
    packageName:String,
    clazz:String
)="""
package ${packageName}.viewmodel

import ${packageName}.repository.${clazz}Repository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ${clazz}ViewModel : ViewModel() {
    private val repository by lazy { ${clazz}Repository() }
    private val _loadDataSuccess = MutableLiveData<Boolean>()
    val loadDataSuccess: LiveData<Boolean>
        get() = _loadDataSucces
}
"""