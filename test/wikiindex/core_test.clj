(ns wikiindex.core-test
  (:require [midje.sweet :refer :all]
            [wikiindex.core :refer :all]))

(fact "the home page should return succesfully"
      (:status (app {:uri "/"
                     :request-method :get})) => 200)

(fact "search is deliberately broken for now - testing bidi"
      (:status (app {:uri "/search"
                     :request-method :get})) => 200)