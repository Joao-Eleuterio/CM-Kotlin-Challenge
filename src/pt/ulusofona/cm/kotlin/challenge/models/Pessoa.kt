package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDate
import java.util.*

class Pessoa(var nome: String, var dataDeNascimento: Date) :Movimentavel{
    var veiculo = listOf<Veiculo>()
    var carta : Carta? = null
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
        return throw VeiculoNaoEncontradoException("")
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
       val veiculo = pesquisarVeiculo(identificador)
       comprador.comprarVeiculo(veiculo!!)
        comprador.veiculo.last().dataDeAquisicao = Date()
       this.veiculo -=veiculo
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        val veiculo = pesquisarVeiculo(identificador)
        veiculo.moverPara(x,y)
    }
    fun temCarta(): Boolean {
        if (carta) {
            return true
        }
        throw PessoaSemCartaException("$nome não tem carta para conduzir o veículo indicado")
    }

    fun tirarCarta() {
        if(dataDeNascimento.year-Date().year>= 18) {
            this.carta = Carta()
        }else{
           throw MenorDeIdadeException("")
        }

    }

    override fun moverPara(x: Int, y: Int) {
        super.moverPara(x, y)
        if(this.x=x && this.y=y){ throw AlterarPosicaoException("")}
        posicao.alterarPosicaoPara(x,y)
    }

}