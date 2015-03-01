(ns wikiindex.functional-test
  (:require [midje.sweet :refer :all]
            [wikiindex.blastoff :as subject]))

(fact "As a customer, I can search for terms on the WikiMedia database"
      (subject/blastoff-testing
        {:uri            "/search"
         :request-method :get
         :query-params   {"q" "1"}})
      => (contains {:body (contains "title 1")}))