package com.example.exercicios.semana1

class ExerciciosSemana1 {

    fun maior(a: Int, b: Int, c: Int): Int {
        return maxOf(a, b, c)
    }

    fun reduzirLista(lista: List<Int>): Int {
        return lista.reduce { acc, i -> maxOf(acc, i) }
    }

    data class Produto(val nome: String, var preco: Double, val categoria: String) {
        fun aplicarDesconto(taxa: Double): Double {
            preco *= (1 - taxa / 100)
            return preco
        }
    }

    companion object {
        fun transformarNomes(nomes: List<String>): List<String> {
            return nomes
                .filter { it.startsWith("A", ignoreCase = true) && it.length > 3 }
                .map { it.uppercase() }
        }

        fun imprimirResultado(resultado: ResultadoOperacao) {
            when (resultado) {
                is Sucesso -> println("Sucesso: valor = ${resultado.valor}")
                is Falha -> println("Falha: ${resultado.mensagem}")
                Pendente -> println("Pendente...")
            }
        }
    }
}

fun String.inverter(): String {
    return this.reversed()
}

fun String.trocarVogais(): String {
    val vogais = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    return this.map { char ->
        if (vogais.contains(char)) '*' else char
    }.joinToString("")
}

sealed class ResultadoOperacao
data class Sucesso(val valor: Int) : ResultadoOperacao()
data class Falha(val mensagem: String) : ResultadoOperacao()
object Pendente : ResultadoOperacao()