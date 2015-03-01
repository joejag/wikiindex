(ns wikiindex.routing-test
  (:require [midje.sweet :refer :all]
            [wikiindex.routing :refer :all]))

(fact "home page route exists"
      (app {:uri "/" :request-method :get}) => (contains {:body anything}))

(fact "search route exists"
      (app {:uri "/search" :request-method :get}) => (contains {:body anything}))