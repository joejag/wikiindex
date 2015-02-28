(ns wikiindex.core-test
  (:require [midje.sweet :refer :all]
            [wikiindex.core :refer :all]))

(fact "home page route exists"
      (:status (app {:uri "/"
                     :request-method :get})) => 200)

(fact "search route exists"
      (:status (app {:uri "/search"
                     :request-method :get})) => 200)