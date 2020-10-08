package com.usjt.tcc.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.usjt.tcc.model.entity.Sugestao;
import com.usjt.tcc.repository.SugestaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SugestaoService {

    @Autowired
    private SugestaoRepository _repository;
    
    public Sugestao consultar(long idTipoSugestao, int posicao){
        List<Sugestao> sugestoes = _repository.find(idTipoSugestao, GetDataHoje());

        return sugestoes.get(posicao);
    }

    public String GetDataHoje(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date hoje = Calendar.getInstance().getTime();
        
		return format.format(hoje);
    }
}
