(ns wikiindex.plumbing.config-test
  (:require [midje.sweet :refer :all]
            [wikiindex.plumbing.config :as subject]))

(fact "port defaults to 5000"
      (subject/port) => 5000)

(fact "search results limit defaults to 20"
      (subject/search-results-limit) => 20)