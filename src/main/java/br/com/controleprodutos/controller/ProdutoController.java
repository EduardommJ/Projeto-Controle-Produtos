package br.com.controleprodutos.controller;

import br.com.controleprodutos.model.Produto;
import br.com.controleprodutos.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class ProdutoController {

    private final ProdutoService service;

    // jeito simples (sem @Autowired, mas correto)
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastroProduto";
    }

    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("produtos", service.listar());
        return "listaProdutos";
    }

    @PostMapping("/salvar")
    public String salvar(
            @RequestParam int codigo,
            @RequestParam String nome,
            @RequestParam double preco,
            @RequestParam int quantidade) {

        Produto produto = new Produto();

        produto.setCodigo(codigo);
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);

        service.salvar(produto);

        return "redirect:/lista";
    }

    @GetMapping("/excluir/{codigo}")
    public String excluir(@PathVariable int codigo) {

        service.deletar(codigo);

        return "redirect:/lista";
    }
}