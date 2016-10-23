package com.booster.data.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booster.data.document.ItemDocument;
import com.booster.data.entity.Item;
import com.booster.data.repository.ItemRepository;

@Service
public class DataIndexingService {

    @Autowired
    private ItemRepository itemRepository;

    public void indexItems() throws SolrServerException, IOException {
        HttpSolrServer httpSolrServer = getSolrServer();
        List<ItemDocument> itemDocuments = new ArrayList<>();
        getItemsForIndexing().forEach(i -> itemDocuments.add(new ItemDocument(i)));
        itemDocuments.forEach(doc -> {
            try {
                httpSolrServer.addBean(doc);
            }
            catch (IOException | SolrServerException e) {
                e.printStackTrace();
            }
        });
        httpSolrServer.commit();
    }

    private HttpSolrServer getSolrServer() {
        String solrUrl = "http://solr.master.com/ecom";
        HttpSolrServer httpSolrServer = new HttpSolrServer(solrUrl);
        httpSolrServer.setParser(new XMLResponseParser());
        httpSolrServer.setMaxRetries(2);
        httpSolrServer.setConnectionTimeout(1000);
        return httpSolrServer;
    }

    private List<Item> getItemsForIndexing() {
        return itemRepository.findAll();
    }

}
