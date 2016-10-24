package com.booster.data.solr.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.booster.data.document.ItemDocument;

public interface ItemDocumentRepository extends CustomSolrRepository, SolrCrudRepository<ItemDocument, Long> {

}
