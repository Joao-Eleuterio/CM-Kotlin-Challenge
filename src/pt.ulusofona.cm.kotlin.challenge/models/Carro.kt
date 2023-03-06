package pt.ulusofona.cm.kotlin.challenge.models

import java.util.*

class Carro(override var identificador:String, val motor:Motor) : Veiculo(identificador){
    override lateinit var dataDeAquisicao: Date

    override fun requerCarta(): Boolean {
        return true
    }

}