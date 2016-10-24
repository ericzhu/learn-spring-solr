package com.booster.data.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booster.data.document.ItemDocument;
import com.booster.data.entity.Item;
import com.booster.data.repository.ItemRepository;
import com.booster.data.solr.repository.ItemDocumentRepository;

@Service
public class DataIndexingService {

    @Autowired
    private ItemRepository         itemRepository;

    @Autowired
    private ItemDocumentRepository itemDocumentRepository;

    public void indexItems() throws SolrServerException, IOException {
        HttpSolrClient httpSolrServer = getSolrServer();
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
    
    private void indexItemsV2() {
        itemDocumentRepository.save(arg0)
    }

    private HttpSolrClient getSolrServer() {
        String solrUrl = "http://solr.master.com/ecom";
        HttpSolrClient httpSolrClient = new HttpSolrClient(solrUrl);
        httpSolrClient.setParser(new XMLResponseParser());
        httpSolrClient.setConnectionTimeout(1000);
        return httpSolrClient;
    }

    private List<Item> getItemsForIndexing() {
        return itemRepository.findAll();
    }

}
