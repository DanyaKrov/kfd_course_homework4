package org.example

import kotlin.random.Random
import kotlin.reflect.KClass
import kotlin.reflect.KParameter
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.javaType
import kotlin.reflect.jvm.jvmName

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun <T: Any>createRandomInstance(kClass: KClass<T>): T? {
    val constructor = kClass.primaryConstructor ?: return null
    val args = mutableListOf<Any?>()
    for (i: KParameter in constructor.parameters) {
        when (i.type.toString()) {
            Double::class.qualifiedName -> args.add(Random.nextDouble())
            Int::class.qualifiedName -> args.add(Random.nextInt())
            Boolean::class.qualifiedName -> args.add(Random.nextBoolean())
            String::class.qualifiedName -> args.add(String(CharArray(7) { ('a'..'z').random() }))
        }
    }
    return constructor.call(*args.toTypedArray())
}