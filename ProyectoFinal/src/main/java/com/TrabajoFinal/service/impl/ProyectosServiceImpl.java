package com.TrabajoFinal.service.impl;

import com.TrabajoFinal.domain.Proyectos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.TrabajoFinal.service.ProyectosService;
import com.TrabajoFinal.dao.ProyectosDao;

@Service
public class ProyectosServiceImpl implements ProyectosService {

    @Autowired
    private ProyectosDao proyectosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Proyectos> getProyectos(boolean activos) {
        var lista = proyectosDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Proyectos getProyectos(Proyectos proyectos) {
        return proyectosDao.findById(proyectos.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Proyectos proyectos) {
        proyectosDao.save(proyectos);
    }

    @Override
    @Transactional
    public void delete(Proyectos proyectos) {
        proyectosDao.delete(proyectos);
    }
}