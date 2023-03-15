package pt.ulusofona.cm.kotlin.challenge.models
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(var cavalos: Int, var cilindrada: Int) : Ligavel {
    var ligado: Boolean = false


    override fun desligar() {
            if (ligado) {
                ligado = false;
            } else {
                throw VeiculoDesligadoException("Não pode desligar um carro desligado")
            }
    }

    override fun estaLigado():Boolean {
        return ligado
    }

    override fun ligar() {
            if (!ligado) {
                ligado = true
            } else {
                throw VeiculoLigadoException("Não pode ligar um carro ligado")
            }
    }

     override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }


}