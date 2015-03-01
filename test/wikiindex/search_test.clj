(ns wikiindex.search-test
  (:require [midje.sweet :refer :all]
            [wikiindex.search :refer :all]))

(def manchester {:title "Manchester" :abstract "Manchsster is a city" :url "url"})
(def london {:title "London" :abstract "London is a city" :url "url"})
(def cities [manchester london])

(facts "a map containing search results is given"
       (fact "your search query request is returned in the response"
             (search ..request.. irrelevant) => (contains {:q ..request..}))

       (fact "you get a list of results back"
             (search irrelevant irrelevant) => (contains {:results irrelevant})))

(facts "can find search results"
       (fact "no possible matches"
             (search-for "unknown" cities) => [])

       (fact "exact match on title"
             (search-for "Manchester" cities) => [manchester])

       (fact "exact match on abstracts"
             (search-for "city" cities) => [manchester london]))