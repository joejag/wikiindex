(ns wikiindex.plumbing.functions-test
  (:require [midje.sweet :refer :all]
            [wikiindex.plumbing.functions :refer [in?]]))

(fact "in? works like contains? in most other languages"
      (in? [1 2 3] 1) => true
      (in? [1 2 3] 4) => nil)
