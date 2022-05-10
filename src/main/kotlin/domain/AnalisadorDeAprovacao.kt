package domain

import domain.criterios.CriterioDeAprovacao

class AnalisadorDeAprovacao {
    private lateinit var criterioDeAprovacao: CriterioDeAprovacao

    fun defineCriterio(criterio: CriterioDeAprovacao) {
        criterioDeAprovacao = criterio
    }

    fun fechaBoletim(boletim: Boletim): BoletimFechado {
        val mediaFinal = criterioDeAprovacao.mediaFinal(boletim)
        val aprovado = criterioDeAprovacao.estaAprovado(boletim)
        return BoletimFechado(
            boletim.mediaEPs, boletim.mediaMiniEPs, mediaFinal, aprovado
        )
    }

}