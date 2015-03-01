(ns wikiindex.core.search-test
  (:require [midje.sweet :refer :all]
            [wikiindex.core.search :as subject]
            [wikiindex.plumbing.config :as config]))

(def manchester {:title "Manchester" :abstract "Manchsster is a city" :url "url"})
(def london {:title "London" :abstract "London is a city" :url "url"})
(def cities [manchester london])

(facts "a map containing search results is given"
       (fact "your search query request is returned in the response"
             (subject/search ..request.. []) => (contains {:q ..request..}))

       (fact "you get a list of results back"
             (subject/search irrelevant []) => (contains {:results irrelevant})))

(facts "can find search results"
       (fact "no possible matches"
             (subject/search-for "unknown" cities) => [])

       (fact "exact match on title"
             (subject/search-for "Manchester" cities) => [manchester])

       (fact "exact match on abstracts"
             (subject/search-for "city" cities) => [manchester london]))

(fact "search results are limited"
      (count (subject/search-for "Manchester" (repeat 100 manchester))) => (config/search-results-limit))