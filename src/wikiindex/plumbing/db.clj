(ns wikiindex.plumbing.db
  (:require [clucy.core :as clucy]
            [wikiindex.plumbing.logger :as log]))

(defn create-db []
  (clucy/memory-index))

(defn index [db doc]
  (clucy/add db doc))

(defn search [db query]
  (clucy/search db query 10))

(defn init [coll]
  (log/creating-lucene-index)
  (let [db (create-db)]
    (doseq [doc coll] (index db doc))
    db))