package com.booster.data;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booster.data.entity.Item;
import com.booster.data.entity.Stock;
import com.booster.data.repository.ItemRepository;
import com.booster.data.repository.StockRepository;
import com.booster.data.service.DataIndexingService;

@SpringBootApplication
@RestController
public class SpringBootDataJpaApplication {

    @Autowired
    private EntityManager       entityManager;

    @Autowired
    private StockRepository     stockRepository;

    @Autowired
    private ItemRepository      itemRepository;

    @Autowired
    private DataIndexingService dataIndexingService;

    @RequestMapping(value = "/stocks")
    public List<Stock> stocks() {
        return entityManager.createQuery("select s from Stock s", Stock.class).getResultList();
    }

    @RequestMapping(value = "/stocks/{symbol}")
    public Stock stockBySymbol(@PathVariable(name = "symbol") String symbol) {
        return stockRepository.findBySymbol(symbol);
    }
    
    @RequestMapping(value = "/indexData")
    public String indexData() {
        try {
            dataIndexingService.indexItems();
            return "Indexing succeeded!";
        }
        catch (SolrServerException | IOException e) {
            return "Indexing failed!";
        }
    }

    @RequestMapping(value = "/items")
    public List<Item> items() {
        return itemRepository.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataJpaApplication.class, args);
    }
}
