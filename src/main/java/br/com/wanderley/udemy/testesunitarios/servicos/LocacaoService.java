package br.com.wanderley.udemy.testesunitarios.servicos;

import java.util.Date;

import br.com.wanderley.udemy.testesunitarios.entidades.Usuario;
import br.com.wanderley.udemy.testesunitarios.utils.DataUtils;
import br.com.wanderley.udemy.testesunitarios.entidades.Filme;
import br.com.wanderley.udemy.testesunitarios.entidades.Locacao;
import br.com.wanderley.udemy.testesunitarios.exceptions.FilmeSemEstoqueException;
import br.com.wanderley.udemy.testesunitarios.exceptions.LocadoraException;
import org.junit.Assert;
import org.junit.Test;

public class LocacaoService {

    public Locacao alugarFilme(Usuario usuario, Filme filme) {
//        if (usuario == null) {
//            throw new LocadoraException("Usuario Vazio");
//        }
//        if (filme == null) {
//            throw new LocadoraException("Filme Vazio");
//        }
//        if (filme.getEstoque() == 0) {
//            throw new FilmeSemEstoqueException();
//        }

        Locacao locacao = new Locacao();
        locacao.setFilme(filme);
        locacao.setUsuario(usuario);
        locacao.setDataLocacao(new Date());
        locacao.setValor(filme.getPrecoLocacao());

        //Entrega no dia seguinte
        Date dataEntrega = new Date();
        dataEntrega = DataUtils.adicionarDias(dataEntrega, 1);
        locacao.setDataRetorno(dataEntrega);

        //Salvando a locacao...
        //TODO adicionar método para salvar

        return locacao;
    }


}