package com.mitocode.service;
import com.mitocode.model.Medic;
import com.mitocode.service.impl.CRUDImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitocode.model.Signos;
public interface ISignosService extends ICRUD<Signos, Integer> {

    Page<Signos> listarPageable(Pageable pageable);
}
