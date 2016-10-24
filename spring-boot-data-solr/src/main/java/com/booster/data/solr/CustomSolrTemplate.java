package com.booster.data.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.data.solr.core.QueryParsers;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.convert.SolrConverter;
import org.springframework.data.solr.server.SolrClientFactory;

public class CustomSolrTemplate extends SolrTemplate {

    private final QueryParsers queryParsers = new QueryParsers();

    private SolrClientFactory  solrClientFactory;

    private SolrConverter      solrConverter;

    public CustomSolrTemplate(SolrClient solrClient) {
        super(solrClient);
    }

}
