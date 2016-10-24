package com.booster.data.solr.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;

import com.booster.data.solr.repository.CustomSolrRepository;

public class CustomSolrRepositoryImpl implements CustomSolrRepository {

    @Autowired
    private SolrTemplate solrTemplate;
    
    public void test() {
       
    }
}