package com.jpa.Repaso1.controller;


import com.jpa.Repaso1.entity.Pedidos;
import com.jpa.Repaso1.services.PedidosServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PedidosController {

    @Autowired
    private PedidosServices pedidosServices;

    //Leer pedidos

    @GetMapping("/dirigirlistaPedidos")
    public String listarPedidos(@RequestParam(name = "buscarPedido", required = false, defaultValue = "") String buscarFormPedido, Model model) {
        List<Pedidos> pedidosDatos = pedidosServices.buscarPedidoCedula(buscarFormPedido);
        model.addAttribute("mostrarLibro", buscarFormPedido);
        model.addAttribute("mostrarPedidos", pedidosDatos);
        return "pages/listaPedidos";
    }


    //isnertar un neuvo libro
    @GetMapping("/formulario")
    public String mostrarFormularioLibro(Model model){
        model.addAttribute("pedido",new Pedidos());
                return "pages/formulario";
    }


    //guardar datos desde form
    @PostMapping("/guardarPedidos")
    public String crearPedidos(@Valid @ModelAttribute("pedido") Pedidos pedido,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            model.addAttribute("pedido", pedido);
            return "pages/formulario";
        }
        pedidosServices.guardarPedido(pedido);
        return "redirect:/dirigirlistaPedidos";
    }

    /*
    @PostMapping ("/guardarPedidos")
    public String crearPedidos(Pedidos pedidos){
        pedidosServices.guardarPedido(pedidos);
        return "redirect:/dirigirlistaPedidos";
    }*/


    //actualizar
    @GetMapping("editarPedido/{id}")
    public String actualziarPedido(@PathVariable Long id, Model model){

        Optional<Pedidos> pedido2 = pedidosServices.buscarPedidoPorID(id);
        model.addAttribute("mostrarPedido2",pedido2);
        return "pages/formulario";

    }

    //eliminar
    @GetMapping("eliminarPedido/{id}")
    public String eliminarPedido(@PathVariable Long id){
        pedidosServices.eliminarPedido(id);
        return  "redirect:/dirigirlistaPedidos";
    }


}
