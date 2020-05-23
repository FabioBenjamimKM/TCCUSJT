package com.usjt.tcc.model;

import java.util.Comparator;

public class ComparadorTop implements Comparator<Top> 
{ 
    public int compare(Top a, Top b) 
    { 
        return (int) (b.getValor() - a.getValor()); 
    } 
} 