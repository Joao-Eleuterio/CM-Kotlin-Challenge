package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(var cavalos:Int,var cilindrada:Int):Ligavel{
    var ligado:Boolean = false


    override fun desligar() {
        if(ligado){
            ligado=false;
        }else{throw VeiculoDesligadoException("")}
    }

    override fun estaLigado() {
        super.estaLigado()
        ligado
    }

    override fun ligar() {
        if(!ligado){
        ligado= true}else{throw VeiculoLigadoException("")}
    }

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }



}