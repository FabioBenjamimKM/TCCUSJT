package com.usjt.tcc.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.usjt.tcc.model.SugestaoInvestimento;
import com.usjt.tcc.model.entity.Acao;
import com.usjt.tcc.model.entity.Perfil;
import com.usjt.tcc.model.entity.Sugestao;
import com.usjt.tcc.model.entity.Usuario;
import com.usjt.tcc.repository.AcaoRepository;
import com.usjt.tcc.repository.Perfils;
import com.usjt.tcc.repository.SugestaoRepository;
import com.usjt.tcc.repository.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SugestaoService {

    @Autowired
    private SugestaoRepository _repository;

    @Autowired
    private Usuarios _usuarioRepository;

    @Autowired
    private AcaoRepository _acaoRepository;

    public Sugestao consultar(long idTipoSugestao, int posicao){
        List<Sugestao> sugestoes = _repository.find(idTipoSugestao, getDataHoje());

        return sugestoes.get(posicao);
    }

    public SugestaoInvestimento sugestaoPorUsuario(long idTipoSugestao, long idUsuario, int posicao){
        Optional<Usuario> usuario = _usuarioRepository.findById(idUsuario);
        Perfil perfil = usuario.get().getPerfil();

        List<Long> idTipoInvestimentoList = getIdTipoInvestimentoList(perfil.getPerfil_investidor().name());

        List<Sugestao> sugestaoList = _repository.buscarPorTipoInvestimento(idTipoSugestao, getDataHoje(), idTipoInvestimentoList);

        SugestaoInvestimento sugestaoInvestimento = convert(sugestaoList).get(posicao);

        if(sugestaoInvestimento.getInvestimento().getTipoInvestimento().getId() == 2){
            List<Acao> acoes = _acaoRepository.findByTopSugestao(sugestaoInvestimento.getInvestimento().getId());
            sugestaoInvestimento.setAcoes(acoes);
        }
        
        return sugestaoInvestimento; 
    }

    private String getDataHoje(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date hoje = Calendar.getInstance().getTime();

		return format.format(hoje);
    }

    private List<Long> getIdTipoInvestimentoList(String perfilInvestidor){
        List<Long> idTipoInvestimentoList = new ArrayList<Long>();

        switch (perfilInvestidor) {
            case "Conservador":
                idTipoInvestimentoList.add((long)1);
                break;
            case "Diversificado":
                idTipoInvestimentoList.add((long)2);
                break;
            case "Agressivo":
                idTipoInvestimentoList.add((long)2);
                break;
            default:
                break;
        }

        return idTipoInvestimentoList;
    }

    private List<SugestaoInvestimento> convert(List<Sugestao> sugestaoList){
        List<SugestaoInvestimento> sugestaoInvestimentoList = new ArrayList<SugestaoInvestimento>();

        for (Sugestao sugestao : sugestaoList) {
            SugestaoInvestimento sugestaoInvestimento = new SugestaoInvestimento();
            sugestaoInvestimento.setInvestimento(sugestao.getInvestimento());
            sugestaoInvestimento.setValor(sugestao.getValor());
            sugestaoInvestimento.setRisco(getRisco(sugestao.getInvestimento().getTipoInvestimento().getId()));
            sugestaoInvestimentoList.add(sugestaoInvestimento);
        }

        return sugestaoInvestimentoList;
    }

    private String getRisco(Long idTipoInvestimento){
        String risco = "";

        switch (Math.toIntExact(idTipoInvestimento)) {
            case 2:
                risco = "Alto";
                break;
            case 1:
                risco = "Baixo";
                break;
            default:
                break;
        }

        return risco;
    }
}
