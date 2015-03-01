(ns wikiindex.indexer
  (:require [clojure.data.xml :as xml]
            [wikiindex.util :refer [in?]]
            [wikiindex.logger :as log]))

(def ^:private desired-fields [:title :url :abstract])

(defn- desired-field? [field]
  (in? desired-fields (:tag field)))

(defn- extract-tag-and-content [tag]
  [(:tag tag) (first (:content tag))])

(defn- xml-doc->filtered-map [elem]
  (->> elem
       :content
       (filter desired-field?)
       (map extract-tag-and-content)
       (into (sorted-map))))

(defn parse [xml-stream]
  (log/indexing-file)
  (let [docs (->> (xml/parse xml-stream) :content)]
    (map xml-doc->filtered-map docs)))