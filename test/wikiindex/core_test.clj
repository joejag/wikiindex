(ns wikiindex.core-test
  (:require [midje.sweet :refer :all]
            [wikiindex.core :refer :all]))

(fact "should return 200 on home page"
      (:status (app {:uri "/"
                     :request-method :get})) => 200)