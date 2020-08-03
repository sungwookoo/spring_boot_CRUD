package com.n2014958006.main.service;

import com.n2014958006.main.domain.Basic;
import com.n2014958006.main.repository.BasicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicService {

    private final BasicRepository basicRepository;

    public BasicService(BasicRepository basicRepository) {
        this.basicRepository = basicRepository;
    }

    public Basic findBasicByIdx(Long idx) {
        return basicRepository.findById(idx).orElse(new Basic());
    }

    public List<Basic> findBasicList() {
        return basicRepository.findAll();
    }

    public Basic saveBasic(Basic basic) {
        return basicRepository.save(basic);
    }

    public void deleteBasic(Basic basic) {
        basicRepository.delete(basic);
    }

    public void getCreatedDate(Basic basic) {
        basic.setCreatedDat(basicRepository.getOne(basic.getIdx()).getCreatedDat());
    }
}

