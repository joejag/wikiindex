(ns wikiindex.core.indexer-test
  (:require [midje.sweet :refer :all]
            [clojure.java.io :as io]
            [wikiindex.core.indexer :as subject])
  (:import (java.io ByteArrayInputStream)))

(defn string->stream [string]
  (ByteArrayInputStream. (.getBytes string)))

(defn create-xml-inputstream []
  (io/input-stream (io/resource "test-docs.xml")))

(fact "parses wikimedia dump into map"
      (let [results (subject/parse (create-xml-inputstream))]
        results => (contains {:title "title 1" :abstract "abstract 1" :url "url 1"})
        results => (contains {:title "title 2" :abstract "abstract 2" :url "url 2"})))

(fact "missing data comes through as an empty string"
      (subject/parse (string->stream "
      <feed><doc>
        <title></title>
        <url></url>
        <abstract></abstract>
      </doc></feed>")) => [{:title "" :abstract "" :url ""}])