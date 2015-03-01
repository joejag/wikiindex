(ns wikiindex.indexer-test
  (:require [midje.sweet :refer :all]
            [clojure.xml :as xml]
            [wikiindex.indexer :refer :all]
            [clojure.java.io :as io]))

; filter xml map to just what we want
; save in atom
(def xml-input (xml/parse (io/file (io/resource "two-docs.xml"))))


(future-fact "filter xml to reduced clojure map")