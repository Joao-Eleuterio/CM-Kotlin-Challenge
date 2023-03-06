package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

class Pessoa(var nome: String, var dataDeNascimento: Date) : Movimentavel {
    var veiculo = listOf<Veiculo>()
    lateinit var carta: Carta
    var posicao = Posicao(0, 0)

    fun comprarVeiculo(veiculo: Veiculo) {
        this.veiculo += veiculo
        this.veiculo.last().dataDeAquisicao = Date()
    }

    fun pesquisarVeiculo(identificador: String): Veiculo {
        try {
            for (veiculos in veiculo) {
                if (veiculos.identificador == identificador) {
                    return veiculos
                }
            }
            throw VeiculoNaoEncontradoException("")
        } catch (_: VeiculoNaoEncontradoException) {
        }
        return TODO("Provide the return value")
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

            if (dataDeNascimento.year - Date().year >= 18) {
                this.carta = Carta()
            } else {
                throw MenorDeIdadeException("")
            }
    }

    override fun moverPara(x: Int, y: Int) {
            if (posicao.x == x && posicao.y == y) {
                throw AlterarPosicaoException("")
            } else {
                posicao.alterarPosicaoPara(x, y)
            }

    }

}