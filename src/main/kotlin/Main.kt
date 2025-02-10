package org.example

import kotlin.random.Random
import kotlin.reflect.KClass
import kotlin.reflect.KParameter
import kotlin.reflect.full.primaryConstructor

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
inline fun <reified T> createRandomInstance(): T? {
    if (T::class.java.isPrimitive)
        return null
    val constructor = T::class.constructors.first()
    val args = mutableListOf<Any?>()
    for (i: KParameter in constructor.parameters) {
        when (i.type.classifier) {
            Double::class -> args.add(Random.nextDouble())
            Int::class -> args.add(Random.nextInt())
            Boolean::class -> args.add(Random.nextBoolean())
            String::class -> args.add(String(CharArray(7) { ('a'..'z').random() }))
        }
    }
    return constructor.call(*args.toTypedArray())
}