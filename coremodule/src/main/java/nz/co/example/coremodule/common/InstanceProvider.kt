package nz.co.example.coremodule.common

interface InstanceProvider<T> {
    fun instance(): T
}