package com.mitocode.service.impl;
import com.mitocode.model.Patient;
import com.mitocode.model.Signos;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.ISignosRepo;
import com.mitocode.service.ISignosService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SignosServiceImpl extends CRUDImpl<Signos, Integer> implements ISignosService {

  private final ISignosRepo repo;

    @Override
    protected IGenericRepo<Signos, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Signos> listarPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
