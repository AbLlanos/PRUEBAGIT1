package com.jpa.Repaso1.services;

import com.jpa.Repaso1.entity.Pedidos;
import com.jpa.Repaso1.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosServices {

    @Autowired
    private PedidosRepository pedidosRepository;

    //1.Para mostrar lo que se guardo

    public List<Pedidos> mostrarPedidos(){
    return pedidosRepository.findAll();
    }


    //2 Buscar pedido por cedula

    public  List<Pedidos> buscarPedidoCedula(String buscarCedula){

        if (buscarCedula == null || buscarCedula.isEmpty()){
            return pedidosRepository.findAll();
        }else{
            return pedidosRepository.findByCedulaContainingIgnoreCase(buscarCedula);
        }

    }


    //3 Buscar por id y es optional y lo de id ya vien incluido

    public Optional<Pedidos> buscarPedidoPorID(Long id){
        return pedidosRepository.findById(id);
    }


    //4.Guardar datos no lista solo pedido

    public Pedidos guardarPedido(Pedidos pedidos){
        return pedidosRepository.save(pedidos);
    }


    //5 Eliminar pedido es void

    public void eliminarPedido(Long id){
    pedidosRepository.deleteById(id);
    }




}
