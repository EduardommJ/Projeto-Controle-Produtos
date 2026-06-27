package br.com.controleprodutos.service;

import br.com.controleprodutos.model.Produto;
import br.com.controleprodutos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    // injeção via construtor (forma correta e simples)
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    // CREATE / UPDATE
    public void salvar(Produto produto) {
        repository.save(produto);
    }

    // READ
    public List<Produto> listar() {
        return repository.findAll();
    }

    // DELETE
    public void deletar(int codigo) {
        repository.deleteById(codigo);
    }
}