(ns wikiindex.indexer-test
  (:require [midje.sweet :refer :all]
            [clojure.zip :as zip]
            [wikiindex.indexer :refer :all]
            [clojure.java.io :as io]))

(defn create-xml-inputstream []
  (io/input-stream (io/resource "two-docs.xml")))

(fact "parses wikimedia dump into map"
      (first (parse (create-xml-inputstream))) => {:title "title 1" :abstract "abstract 1" :url "url 1"}
      (second (parse (create-xml-inputstream))) => {:title "title 2" :abstract "abstract 2" :url "url 2"})

