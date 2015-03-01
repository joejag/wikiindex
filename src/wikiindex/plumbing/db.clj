(ns wikiindex.plumbing.db
  (:require [clucy.core :as clucy]))

(defn create-db []
  (clucy/memory-index))

(defn index [db doc]
  (clucy/add db doc))

(defn search [db query]
  (clucy/search db query 10))


