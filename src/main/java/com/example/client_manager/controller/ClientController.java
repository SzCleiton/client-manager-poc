package com.example.client_manager.controller;

import com.example.client_manager.model.Client;
import com.example.client_manager.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    @Autowired
    private ClientService clienteService;

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        return "listar-clientes";
    }

    @GetMapping("/clientes/novo")
    public String novoClienteForm(Model model) {
        model.addAttribute("cliente", new Client());
        return "novo-cliente";
    }

    @PostMapping("/clientes")
    public String salvarCliente(@ModelAttribute("cliente") Client cliente) {
        clienteService.salvar(cliente);
        return "redirect:/clientes";
    }
}
