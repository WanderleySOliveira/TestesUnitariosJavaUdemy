package br.com.wanderley.udemy.testesunitarios.servicos;

import br.com.wanderley.udemy.testesunitarios.entidades.Filme;
import br.com.wanderley.udemy.testesunitarios.entidades.Locacao;
import br.com.wanderley.udemy.testesunitarios.entidades.Usuario;
import br.com.wanderley.udemy.testesunitarios.utils.DataUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class LocacaoServiceTest {

    @Test
    public void Teste() {
        //cenario
        LocacaoService locacaoservice = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Zorro", 2, 10.0);

        //acao
        Locacao locacao = locacaoservice.alugarFilme(usuario,filme);

        //verificacao inicial com Sout mostrando os resultado, não atende os principios dos testes unitarios
//        System.out.println(locacao.getValor());
//        System.out.println(locacao.getDataLocacao());
//        System.out.println(locacao.getDataRetorno());


        //Verificação - Dentro dos principios utilizando Assert
        Assert.assertTrue(locacao.getValor() == 10.0);
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(),DataUtils.obterDataComDiferencaDias(1)));
    }
}
