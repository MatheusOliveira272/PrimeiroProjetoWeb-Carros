package br.com.unincor.web.controller;

import br.com.unincor.web.model.dao.CarroDao;
import br.com.unincor.web.model.domain.Carro;
import br.com.unincor.web.model.domain.TipoCombustivel;
import br.com.unincor.web.model.domain.TipoTransmissao;
import br.com.unincor.web.model.domain.TipoVeiculo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Getter;
import lombok.Setter;


/*Anotações de ingeções de dependência para o 
java instanciá-las automáticamente*/
@ManagedBean
@SessionScoped
@Getter
@Setter
public class BeanPrincipal implements Serializable {

    private List<Carro> carros = new ArrayList<>();
    private Carro carro;
    private boolean editando = false;

    /* public BeanPrincipalAluno() {
        aluno = new Aluno();

    }*/
    @PostConstruct
    public void init() {
        buscar();
    }

    public void salvar() {
        new CarroDao().save(carro);
        cancelar();
        buscar();
        editando = false;
    }

    public void limparTabela() {
        carros.clear();
    }

    public void editar(Carro carro) {
        this.carro = carro;
    }

    public void novo() {
        this.carro = new Carro();

    }

    public void cancelar() {
        this.carro = null;
    }

    public void remover(Carro carro) {

        new CarroDao().delete(carro);
        buscar();

    }

    public void buscar() {
        this.carros = new CarroDao().findAll();

    }

    public List<TipoCombustivel> getTipoCombustiveis() {
        return Arrays.asList(TipoCombustivel.values());
    }
    
    public List<TipoTransmissao> getTipoTransmissoes() {
        return Arrays.asList(TipoTransmissao.values());
    }
    
    public List<TipoVeiculo> getTipoVeiculos() {
        return Arrays.asList(TipoVeiculo.values());
    }
}

//obs: usar o netbeans 17
