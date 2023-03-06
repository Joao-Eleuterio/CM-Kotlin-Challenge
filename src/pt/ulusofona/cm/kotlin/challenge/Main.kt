package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.models.Carro
import pt.ulusofona.cm.kotlin.challenge.models.Motor
import pt.ulusofona.cm.kotlin.challenge.models.Pessoa
import java.util.*

fun main() {
    // aqui escreves o código do programa
    val carro = Carro("aabbcc", Motor(90,90))
    val pessoa = Pessoa("aaa", Date())
    pessoa.comprarVeiculo(carro)
    val pessoa1 = Pessoa("bbb", Date())
    pessoa.venderVeiculo("aabbcc",pessoa1)
    try {
        print(pessoa1.tirarCarta())
    }catch (e: MenorDeIdadeException){
       print(e.message)
    }
}
    