(ns wikiindex.core.indexer
  (:require [clojure.data.xml :as xml]
            [wikiindex.plumbing.functions :refer [in?]]
            [wikiindex.plumbing.logger :as log]))

(def ^:private desired-fields [:title :url :abstract])
(def ^:private default-value "")

(defn- desired-field? [field]
  (in? desired-fields (:tag field)))

(defn- extract-tag-and-content [elem]
  (let [tag (:tag elem)
        content (or (first (:content elem)) default-value)]
    [tag content]))

(defn- xml-doc->filtered-map [elem]
  (->> elem
       :content
       (filter desired-field?)
       (map extract-tag-and-content)
       (into {})))

(defn parse [xml-stream]
  (log/indexing-file)
  (let [docs (->> (xml/parse xml-stream) :content)]
    (map xml-doc->filtered-map docs)))