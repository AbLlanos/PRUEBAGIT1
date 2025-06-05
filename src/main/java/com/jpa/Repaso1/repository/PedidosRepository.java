package com.jpa.Repaso1.repository;

import com.jpa.Repaso1.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidosRepository extends JpaRepository<Pedidos,Long> {

    //Buscar por id
    List<Pedidos> findByCedulaContainingIgnoreCase(String cedula);

}
