(ns wikiindex.search-test
  (:require [midje.sweet :refer :all]
            [wikiindex.search :refer :all]))

(fact "your search request is returned in the response"
      (search ..request.. irrelevant) => (contains {:q ..request..}))
