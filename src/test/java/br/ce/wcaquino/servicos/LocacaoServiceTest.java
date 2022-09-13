package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class LocacaoServiceTest {

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Test
    @DisplayName("Responsavel por realizar o teste do metodo Alugar filme da classe LocacaoService")
    public void deveTestarOMetodoAlugarFilmeEmLocacaoService() throws Exception {
        //Cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Matrix", 2, 10.00);

        //Ação
        Locacao locacao = service.alugarFilme(usuario, filme);


        //Verificação
        assertThat(locacao.getValor(), is(10.0));
        assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
        assertThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));


        //Tratativa de erro com o ErrorCollector, com esse metodo, quando um teste tiver mais de uma inconsistencia, ambas serão apresentadas no stacktrace.
        error.checkThat(locacao.getValor(), is(10.0));
        error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
        error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));

        //Exemplos de validação utilizando o assertEquals
        assertEquals(10.00, locacao.getValor(), 0.01);
        assertThat(locacao.getValor(), is(not(6.00)));

        //Mesmo sentido da assertiva acima porém utilizando o metod assertThat
        assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
    }

    //No metodo abaixo eu indico para o teste que ele deve estourar uma exception, criando o cenario de falha para ter esse retorno.
    @Test(expected = Exception.class)
    public void deveLancarExceptionFilmeSemEstoqueFormaElegante() throws Exception {
        //cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Matrix", 0, 10.00);

        //acao
        service.alugarFilme(usuario, filme);
    }

    @Test
    public void deveLancarExceptionFilmeSemEstoqueFormaRobusta() {
        //cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Matrix", 0, 10.00);

        //acao
        try {
            service.alugarFilme(usuario, filme);
            Assert.fail("Deveria ter lançado a exception");
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Filme sem estoque"));
        }
    }

    @Test
    public void deveLancarExceptionNovaForma() throws Exception {

        //cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Matrix", 0, 10.00);

        exception.expect(Exception.class);
        exception.expectMessage("Filme sem estoque");

        //acao
        service.alugarFilme(usuario, filme);
    }


}