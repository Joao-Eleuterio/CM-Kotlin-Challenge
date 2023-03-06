package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.Carro
import pt.ulusofona.cm.kotlin.challenge.models.Motor
import pt.ulusofona.cm.kotlin.challenge.models.Pessoa
import java.util.*

fun main() {
    // aqui escreves o código do programa
    var carro = Carro("aabbcc", Motor(90,90))
    var pessoa = Pessoa("aaa", Date())
    pessoa.comprarVeiculo(carro)

    println(carro)
}
    