package pt.ulusofona.cm.kotlin.challenge.models
import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.util.*

class Pessoa(var nome: String, var dataDeNascimento: Date) : Movimentavel {
    var veiculos : List<Veiculo> = listOf()
    lateinit var carta : Carta
    var posicao = Posicao(0, 0)

    fun comprarVeiculo(veiculo: Veiculo) {
        this.veiculos += veiculo
        this.veiculos.last().dataDeAquisicao = Date()

    }

    fun pesquisarVeiculo(identificador: String): Veiculo {
            for (veiculo in veiculos) {
                if (veiculo.identificador == identificador) {
                    return veiculo
                }
            }
            throw VeiculoNaoEncontradoException("Não exite o veiculo com o identificador: $identificador")
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
            val veiculo = pesquisarVeiculo(identificador)
            comprador.comprarVeiculo(veiculo)
            comprador.veiculos.last().dataDeAquisicao = Date()
            this.veiculos -= veiculo

    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        val veiculo = pesquisarVeiculo(identificador)
        if(veiculo.requerCarta() && !temCarta()){
            throw PessoaSemCartaException("$nome não tem carta para o fazer" )
        }
        veiculo.moverPara(x, y)
    }

    fun temCarta(): Boolean {
            if (this::carta.isInitialized && carta.javaClass.simpleName == Carta().javaClass.simpleName) {
                return true
            }
        return false
    }

    fun tirarCarta() {
        val today = Date()
        val diffInMillis = today.time - dataDeNascimento.time
        val age = (diffInMillis / (1000 * 60 * 60 * 24 * 365.25)).toInt()
            if (age>=18) {
                this.carta = Carta()
            } else {
                throw MenorDeIdadeException("$nome é menor de idade" )
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
        val formato = SimpleDateFormat("dd-MM-yyyy")
        val data = formato.format(dataDeNascimento)
        return "Pessoa | " + nome + " | " + data + " | Posicao | x:" + posicao.x + " | y:" + posicao.y
    }

}