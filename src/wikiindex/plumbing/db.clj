(ns wikiindex.plumbing.db
  (:require [clucy.core :as clucy]
            [wikiindex.plumbing.logger :as log]))

(defn create-db []
  (clucy/disk-index "/tmp/wikiindex"))

(defn index [db doc]
  (clucy/add db doc))

(defn search [db query]
  (clucy/search db query 10))

(def amount (atom 0))

(defn init [coll]
  (log/creating-lucene-index)
  (let [db (create-db)]
    (doseq [doc coll]
      (swap! amount (fn [cur] (inc cur)))
      (if (= 0 (rem @amount 1000)) (println @amount))
      (index db doc))
    db))