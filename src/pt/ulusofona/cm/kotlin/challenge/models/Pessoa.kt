package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

class Pessoa(var nome: String, var dataDeNascimento: Date) : Movimentavel {
    var veiculo : List<Veiculo> = listOf()
    lateinit var carta: Carta
    var posicao = Posicao(0, 0)

    fun comprarVeiculo(veiculo: Veiculo) {
        this.veiculo += veiculo
        this.veiculo.last().dataDeAquisicao = Date()
    }

    fun pesquisarVeiculo(identificador: String): Veiculo {
            for (veiculos in veiculo) {
                if (veiculos.identificador == identificador) {
                    return veiculos
                }
            }
            throw VeiculoNaoEncontradoException("Não exite o veiculo com o identificador: $identificador")
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
            val veiculo = pesquisarVeiculo(identificador)
            comprador.comprarVeiculo(veiculo)
            comprador.veiculo.last().dataDeAquisicao = Date()
            this.veiculo -= veiculo
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        val veiculo = pesquisarVeiculo(identificador)
        veiculo.moverPara(x, y)
    }

    fun temCarta(): Boolean {
            if (carta == Carta()) {
                return true
            }
            throw PessoaSemCartaException("$nome não tem carta para conduzir o veículo indicado")
    }

    fun tirarCarta() {
            if (dataDeNascimento.year - Date().year >= 18 && !temCarta()) {
                this.carta = Carta()
            } else {
                throw MenorDeIdadeException("Não pode tirar a carta" )
            }
    }

    override fun moverPara(x: Int, y: Int) {
            if (posicao.x == x && posicao.y == y) {
                throw AlterarPosicaoException("Não pode ir para a mesma posicao")
            } else {
                posicao.alterarPosicaoPara(x, y)
            }

    }

    override fun toString(): String {
        return "Pessoa | $nome | $dataDeNascimento | Posicao | x:${posicao.x} | y:${posicao.y}"
    }

}