package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.util.*

abstract class Veiculo(open var identificador: String) : Movimentavel{
    var posicao = Posicao(0,0)
    abstract var dataDeAquisicao : Date
    abstract fun requerCarta():Boolean

    override fun toString(): String {
        val formato = SimpleDateFormat("dd-MM-yyyy")
        val data = formato.format(dataDeAquisicao)
        return this.javaClass.simpleName.toString() + " | " + identificador + " | " + data + " | Posicao | x:" + posicao.x + " | y:" + posicao.y
    }
}

